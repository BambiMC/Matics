const API_URL: string = "https://dev2.fnbg.de/graphql";

export function getData() {
    return fetch(API_URL, {
        headers: { "Content-Type": "application/json" },
        method: "POST",
        body: JSON.stringify({
            query: `query GetPostContent {
                posts(first: 1, where: { title: "Überschrift" }) {
                    edges {
                        node {
                            content
                        }
                    }
                }
            }`,
        }),
    });
}