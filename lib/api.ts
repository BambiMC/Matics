const API_URL: string = "https://dev2.fnbg.de/graphql";

interface NodeObject {
  [key: string]: any;
}

export function removeNode(obj: NodeObject): NodeObject {
  const newObj: NodeObject = {};
  for (const key in obj) {
    if (obj.hasOwnProperty(key)) {
      const value = obj[key];
      if (
        typeof value === "object" &&
        value !== null &&
        !Array.isArray(value)
      ) {
        newObj[key] = removeNode(value);
      } else if (Array.isArray(value)) {
        newObj[key] = value.map((item: any) => {
          if (
            typeof item === "object" &&
            item !== null &&
            !Array.isArray(item)
          ) {
            return removeNode(item);
          }
          return item;
        });
      } else if (key !== "node") {
        newObj[key] = value;
      }
    }
  }
  if (
    "node" in newObj &&
    typeof newObj["node"] === "object" &&
    newObj["node"] !== null
  ) {
    return newObj["node"]; // Returning contents of the node
  }
  return newObj;
}

async function fetchAPI(query = "", { variables }: Record<string, any> = {}) {
  const headers = {
    "Content-Type": "application/json",
  };

  const res = await fetch(API_URL, {
    headers,
    method: "POST",
    body: JSON.stringify({
      query,
      variables,
    }),
    next: { revalidate: 0 },
  });

  const json = await res.json();
  if (json.errors) {
    console.error(json.errors);
    throw new Error("Failed to fetch API");
  }
  return json.data;
}

export async function getAllPostsForHome(preview: any) {
  const data = await fetchAPI(
    `
    query AllPosts {
      posts(first: 200, where: { orderby: { field: DATE, order: DESC } }) {
        edges {
          node {
            title
            excerpt
            slug
            date
            featuredImage {
              node {
                sourceUrl
              }
            }
            author {
              node {
                name
                firstName
                lastName
                avatar {
                  url
                }
              }
            }
          }
        }
      }
    }
  `,
    {
      variables: {
        onlyEnabled: !preview,
        preview,
      },
    }
  );

  const cleanedData = removeNode(data?.posts);
  return cleanedData;
}

export async function getPost(title: string) {
  const data = await fetchAPI(
    `
    query GetPost($title: String!) {
      posts(first: 1, where: { title: $title }) {
        edges {
          node {
            title
            excerpt
            slug
            date
            featuredImage {
              node {
                sourceUrl
              }
            }
            author {
              node {
                name
                firstName
                lastName
                avatar {
                  url
                }
              }
            }
          }
        }
      }
    }
  `,
    {
      variables: {
        title,
      },
    }
  );
  return removeNode(data?.posts);
}

export async function getPostContent(title: string) {
  const data = await fetchAPI(
    `
query GetPostContent($title: String!) {
  posts(first: 1, where: {title: $title}) {
    edges {
      node {
        content
      }
    }
  }
}
  `,
    {
      variables: {
        title,
      },
    }
  );
  return data?.posts?.edges[0].node.content;
}
