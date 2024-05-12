"use client";
import { useState, useEffect } from 'react';
import { getContent } from '../../lib/api';

export default function Index() {
    const [data, setData] = useState(null);

    useEffect(() => {
        getContent("Überschrift").then((res: any) => res.json()).then((json: any) => {
            console.log(json);
            setData(json.data.posts.edges[0].node.content);
        });
    }, []);

    if (!data) return <p>No data</p>;

    return (
        <div className="p-32" dangerouslySetInnerHTML={{ __html: data }} />
    );
}