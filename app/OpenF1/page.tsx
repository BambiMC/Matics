"use client";
import React, { useEffect, useState } from 'react';
import { useLanguageData } from '@data/languageLoader';
import Button from '@app/components/Button/Button';

//TODO lang einarbeitung: einmal überall open f1 in der projects seite miteinbauen und dann noch in der openf1 seite
//TODO toggle Anzeige formattiert oder raw
//TODO add clear text button

const Homepage: React.FC = () => {
    const data = useLanguageData("openf1");
    const [responseData, setResponseData] = useState<any>(null);
    const [queryTexts, setQueryTexts] = useState<string[]>(['driver_number=55&session_key=9159&speed>=300', 'driver_number=1&session_key=9158', 'session_key=9165&interval<0.005', 'session_key=9161&driver_number=63&lap_number=8', 'session_key=9161&driver_number=81&date>2023-09-16T13:03:35.200&date<2023-09-16T13:03:35.800', 'year=2023&country_name=Singapore', 'session_key=9158&pit_duration<31', 'meeting_key=1217&driver_number=40&position<=3', 'flag=BLACK AND WHITE&driver_number=1&date>=2023-01-01&date<2023-09-01', 'country_name=Belgium&session_name=Sprint&year=2023', 'session_key=9165&tyre_age_at_start>=3', 'session_key=9158&driver_number=11', 'meeting_key=1208&wind_direction>=130&track_temperature>=52']);

    const apiItems = [['Car data', 'car_data'], ['Drivers', 'drivers'], ['Intervals', 'intervals'], ['Laps', 'laps'], ['Location', 'location'], ['Meetings', 'meetings'], ['Pit', 'pits'], ['Position', 'position'], ['Race Control', 'race_control'], ['Sessions', 'sessions'], ['Stints', 'stints'], ['Team radio', 'team_radio'], ['Weather', 'weather']];
    const [selectedCategory, setSelectedCategory] = useState<string[]>(apiItems[0]);

    const attributeItems = [['brake', 'date', 'driver_number'], ['broadcast_name', 'country_code', 'driver_number'], ['date', 'driver_number', 'gap_to_leader']]
    const [applicableAttributes, setApplicableAttributes] = useState<string[]>(attributeItems[0]);


    const getQueryIndex = (): number => {
        for (let i = 0; i < apiItems.length; i++) {
            if (apiItems[i][0] === selectedCategory[0]) {
                return i;
            }
        }
        console.log("apiItems: ", apiItems);
        console.log("selectedCategory: ", selectedCategory);
        alert("ERROR WHILE GETTING QUERY INDEX");
        return -1;
    }

    const fetchData = async () => {
        try {
            console.log(`https://api.openf1.org/v1/${selectedCategory[1]}?${queryTexts[getQueryIndex()]}`);
            const response = await fetch(`https://api.openf1.org/v1/${selectedCategory[1]}?${queryTexts[getQueryIndex()]}`);
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            const data = await response.json();
            setResponseData(data);
        } catch (error) {
            console.error('Error fetching data:', error);
        }
    };

    const handleCategoryChange = (label: string[]) => {
        setSelectedCategory(label);
        setApplicableAttributes(attributeItems[getQueryIndex()]);
        //TODO Load saved query?

    };

    const handleQueryChange = (newQuery: string) => {
        const modifiedQueryTexts = queryTexts;
        modifiedQueryTexts[getQueryIndex()] = newQuery;
        setQueryTexts(modifiedQueryTexts);
    };
    const addAttribute = (label: string) => {
        //TODO
    };


    return (
        <main className='p-20 mt-20'>
            {data && (
                <div>
                    <div className='mb-4 p-4 bg-fnbg-accent block'>
                        {apiItems.map((label, index) => (
                            <Button key={index} onClick={() => handleCategoryChange(label)} addClasses={`border-2 m-2 ${selectedCategory[0] === label[0] ? 'bg-fnbg-accent border-fnbg-orange text-white border-fnbg-accent' : 'border-fnbg-body bg-fnbg-accent text-fnbg-purple'}`}>{label[0]}</Button>
                        ))}
                    </div>

                    <div className='mb-4 p-4 bg-fnbg-accent flex'>
                        <p className='pr-4 pt-2 font-bold'>Query</p>
                        <input
                            className='p-1 border-2 border-fnbg-orange rounded-lg w-full'
                            type="text"
                            value={queryTexts[getQueryIndex()]}
                            onChange={(e) => handleQueryChange(e.target.value)}
                        />
                        <Button onClick={fetchData} addClasses='border-2 border-fnbg-orange ml-4'>Execute</Button>
                    </div>

                    <div className='mb-4 p-4 bg-fnbg-accent block'>
                        {applicableAttributes.map((label, index) => (
                            <Button key={index} onClick={() => addAttribute(label)} addClasses={`border-2 m-2 ${'border-fnbg-body bg-fnbg-accent text-fnbg-purple'}`}>{label}</Button>
                        ))}
                    </div>
                </div>

            )}
            {responseData && (
                <div>
                    <div>
                    </div>
                    <h2>Fetched Data:</h2>
                    <pre>{JSON.stringify(responseData, null, 2)}</pre>
                </div>
            )}
        </main>
    );
};

export default Homepage;
