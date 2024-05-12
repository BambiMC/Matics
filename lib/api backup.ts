const API_URL: string = process.env.WORDPRESS_API_URL!;

async function fetchAPI(query = "", { variables }: Record<string, any> = {}) {
  const headers = { "Content-Type": "application/json" };

  // if (process.env.WORDPRESS_AUTH_REFRESH_TOKEN) {
  //   headers[
  //     "Authorization"
  //   ] = `Bearer ${process.env.WORDPRESS_AUTH_REFRESH_TOKEN}`;
  // }

  // WPGraphQL Plugin must be enabled
  const res = await fetch(API_URL, {
    headers,
    method: "POST",
    body: JSON.stringify({
      query,
      variables,
    }),
  });

  const json = await res.json();
  if (json.errors) {
    console.error(json.errors);
    throw new Error("Failed to fetch API");
  }
  return json.data;
}

export async function getPreviewPost(id: any, idType = "DATABASE_ID") {
  const data = await fetchAPI(
    `
    query PreviewPost($id: ID!, $idType: PostIdType!) {
      post(id: $id, idType: $idType) {
        databaseId
        slug
        status
      }
    }`,
    {
      variables: { id, idType },
    }
  );
  return data.post;
}

export async function getAllPostsWithSlug() {
  const data = await fetchAPI(`
    {
      posts(first: 10000) {
        edges {
          node {
            slug
          }
        }
      }
    }
  `);
  return data?.posts;
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

  // console.log(data);
  // console.log(data.posts);
  // console.log(data.posts?.edges);
  // console.log(data.posts?.edges[0]);

  const cleanedData = removeNode(data?.posts);
  console.log("cleanedData");
  console.log(JSON.stringify(cleanedData));
  return cleanedData;
}

interface NodeObject {
  [key: string]: any;
}

// Remove "node" from the object hierarchy
function removeNode(obj: NodeObject): NodeObject {
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
      postBy(title: $title) {
        content
      }
    }
  `,
    {
      variables: {
        title,
      },
    }
  );
  return data?.postBy?.content;
}

// export async function getPostAndMorePosts(slug: any, preview: any, previewData: { post: any; }) {
//   const postPreview = preview && previewData?.post;
//   // The slug may be the id of an unpublished post
//   const isId = Number.isInteger(Number(slug));
//   const isSamePost = isId
//     ? Number(slug) === postPreview.id
//     : slug === postPreview.slug;
//   const isDraft = isSamePost && postPreview?.status === "draft";
//   const isRevision = isSamePost && postPreview?.status === "publish";
//   const data = await fetchAPI(
//     `
//     fragment AuthorFields on User {
//       name
//       firstName
//       lastName
//       avatar {
//         url
//       }
//     }
//     fragment PostFields on Post {
//       title
//       excerpt
//       slug
//       date
//       featuredImage {
//         node {
//           sourceUrl
//         }
//       }
//       author {
//         node {
//           ...AuthorFields
//         }
//       }
//       categories {
//         edges {
//           node {
//             name
//           }
//         }
//       }
//       tags {
//         edges {
//           node {
//             name
//           }
//         }
//       }
//     }
//     query PostBySlug($id: ID!, $idType: PostIdType!) {
//       post(id: $id, idType: $idType) {
//         ...PostFields
//         content
//         ${
//           // Only some of the fields of a revision are considered as there are some inconsistencies
//           isRevision
//             ? `
//         revisions(first: 1, where: { orderby: { field: MODIFIED, order: DESC } }) {
//           edges {
//             node {
//               title
//               excerpt
//               content
//               author {
//                 node {
//                   ...AuthorFields
//                 }
//               }
//             }
//           }
//         }
//         `
//             : ""
//         }
//       }
//       posts(first: 3, where: { orderby: { field: DATE, order: DESC } }) {
//         edges {
//           node {
//             ...PostFields
//           }
//         }
//       }
//     }
//   `,
//     {
//       variables: {
//         id: isDraft ? postPreview.id : slug,
//         idType: isDraft ? "DATABASE_ID" : "SLUG",
//       },
//     }
//   );

//   // Draft posts may not have an slug
//   if (isDraft) data.post.slug = postPreview.id;
//   // Apply a revision (changes in a published post)
//   if (isRevision && data.post.revisions) {
//     const revision = data.post.revisions.edges[0]?.node;

//     if (revision) Object.assign(data.post, revision);
//     delete data.post.revisions;
//   }

//   // Filter out the main post
//   data.posts.edges = data.posts.edges.filter(({ node}) => node.slug !== slug);
//   // If there are still 3 posts, remove the last one
//   if (data.posts.edges.length > 2) data.posts.edges.pop();

//   return data;
// }
