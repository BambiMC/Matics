"use client";
import React, { useState } from 'react';
import { useLanguageData } from '@data/languageLoader';

const Homepage: React.FC = () => {
    const data = useLanguageData("openf1");
    const [responseData, setResponseData] = useState<any>(null);
    const [queryParameter, setQueryParameter] = useState<string>("driver_number=55&session_key=9159&speed>=300");

    const fetchData = async () => {
        try {
            const response = await fetch(`https://api.openf1.org/v1/car_data?${queryParameter}`);
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            const data = await response.json();
            setResponseData(data);
            console.log("done");
        } catch (error) {
            console.error('Error fetching data:', error);
        }
    };

    return (
        <main className='p-20 mt-20'>
            {data && (
                <div>
                    <div className='flex'>
                        <p>query parameter</p>
                        <input
                            type="text"
                            value={queryParameter}
                            onChange={(e) => setQueryParameter(e.target.value)}
                        />
                    </div>
                    <button onClick={fetchData}>Click for fetch</button>
                </div>
            )}

            {responseData && (
                <div>
                    <h2>Fetched Data:</h2>
                    <pre>{JSON.stringify(responseData, null, 2)}</pre>
                </div>
            )}
        </main>
    );
};

export default Homepage;
