"use client";
import { useState, useEffect } from 'react';
import { getData } from '../../lib2/api';

export default function Index() {
    const [data, setData] = useState(null);
    const [isLoading, setLoading] = useState(true);

    useEffect(() => {
        getData().then((res: any) => res.json()).then((json: any) => {
            console.log(json);
            setData(json.data.posts.edges[0].node.content);
            setLoading(false);
        });
    }, []);

    // if (isLoading) return <p>Loading...</p>;
    if (!data) return <p>No data</p>;

    return (
        <div className="p-32" dangerouslySetInnerHTML={{ __html: data }} />
    );
}