const API_URL: string = "https://dev2.fnbg.de/graphql";

export function getContent(postTitle: string) {
    return fetch(API_URL, {
        headers: { "Content-Type": "application/json" },
        method: "POST",
        body: JSON.stringify({
            query: `query GetPostContent($title: String!) {
                posts(first: 1, where: { title: $title }) {
                    edges {
                        node {
                            content
                        }
                    }
                }
            }`,
            variables: {
                title: postTitle
            }
        }),
    });
}