import { GetStaticProps } from "next";
import { getAllPostsForHome } from "../../../lib/api";

interface Post {
    title: string;
    // Other properties of a post
}

interface AllPostsResponse {
    edges: { node: Post }[];
}

interface Props {
    allPosts: AllPostsResponse;
    preview: boolean;
}

const Wp = ({ allPosts, preview }: Props) => {
    // const heroPost = edges[0]?.node.title;
    return (
        <div>
            title={ }
        </div>
    );
}

export const getStaticProps: GetStaticProps = async ({ preview = false }) => {
    const allPosts = await getAllPostsForHome(preview);
    console.log(allPosts);

    return {
        props: { allPosts, preview },
        revalidate: 10,
    };
};

export default Wp;