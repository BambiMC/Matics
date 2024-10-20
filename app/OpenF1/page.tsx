"use client";
import React, { useState } from 'react';
import { useLanguageData } from '@data/languageLoader';
import Button from '@app/components/Button/Button';
import ToggleButton from '@app/components/ToggleButton/ToggleButton';

//TODO lang einarbeitung: einmal überall open f1 in der projects seite miteinbauen und dann noch in der openf1 seite
//TODO toggle Anzeige formattiert oder raw
//TODO add clear text button

const Homepage: React.FC = () => {
    const data = useLanguageData("openf1");
    const [responseData, setResponseData] = useState<any>(null);
    const [queryTexts, setQueryTexts] = useState<string[]>(['driver_number=55&session_key=9159&speed>=300', 'driver_number=1&session_key=9158', 'session_key=9165&interval<0.005', 'session_key=9161&driver_number=63&lap_number=8', 'session_key=9161&driver_number=81&date>2023-09-16T13:03:35.200&date<2023-09-16T13:03:35.800', 'year=2023&country_name=Singapore', 'session_key=9158&pit_duration<31', 'meeting_key=1217&driver_number=40&position<=3', 'flag=BLACK AND WHITE&driver_number=1&date>=2023-01-01&date<2023-09-01', 'country_name=Belgium&session_name=Sprint&year=2023', 'session_key=9165&tyre_age_at_start>=3', 'session_key=9158&driver_number=11', 'meeting_key=1208&wind_direction>=130&track_temperature>=52']);

    const apiItems = [['Car data', 'car_data'], ['Drivers', 'drivers'], ['Intervals', 'intervals'], ['Laps', 'laps'], ['Location', 'location'], ['Meetings', 'meetings'], ['Pit', 'pits'], ['Position', 'position'], ['Race Control', 'race_control'], ['Sessions', 'sessions'], ['Stints', 'stints'], ['Team radio', 'team_radio'], ['Weather', 'weather']];
    const [selectedCategory, setSelectedCategory] = useState<string[]>(apiItems[0]);

    const attributeItems = [['brake', 'date', 'driver_number', 'drs', 'meeting_key', 'n_gear', 'rpm', 'session_key', 'speed', 'throttle', 'date_start', 'date_end'], ['broadcast_name', 'country_code', 'driver_number', 'first_name', 'full_name', 'headshot_url', 'last_name', 'meeting_key', 'name_acronym', 'session_key', 'team_colour', 'team_name', 'date_start', 'date_end'], ['date', 'driver_number', 'gap_to_leader', 'interval', 'meeting_key', 'session_key', 'date_start', 'date_end'], ['date_start', 'driver_number', 'duration_sector_1', 'duration_sector_2', 'duration_sector_3', 'i1_speed', 'i2_speed', 'is_pit_out_lap', 'lap_duration', 'lap_number', 'meeting_key', 'segments_sector_1', 'segments_sector_2', 'segments_sector_3', 'session_key', 'st_speed', 'date_start', 'date_end'], ['date', 'driver_number', 'meeting_key', 'session_key', 'x', 'y', 'z', 'date_start', 'date_end'], ['circuit_key', 'circuit_short_name', 'country_code', 'country_key', 'country_name', 'date_start', 'gmt_offset', 'location', 'meeting_key', 'meeting_name', 'meeting_official_name', 'year', 'date_start', 'date_end'], ['date', 'driver_number', 'lap_number', 'meeting_key', 'pit_duration', 'session_key', 'date_start', 'date_end'], ['date', 'driver_number', 'meeting_key', 'position', 'session_key', 'date_start', 'date_end'], ['category', 'date', 'driver_number', 'flag', 'lap_number', 'meeting_key', 'message', 'scope', 'sector', 'session_key', 'date_start', 'date_end'], ['circuit_key', 'circuit_short_name', 'country_code', 'country_key', 'country_name', 'date_end', 'date_start', 'gmt_offset', 'location', 'meeting_key', 'session_key', 'session_name', 'session_type', 'year', 'date_start', 'date_end'], ['compound', 'driver_number', 'lap_end', 'lap_start', 'meeting_key', 'session_key', 'stint_number', 'tyre_age_at_start', 'date_start', 'date_end'], ['date', 'driver_number', 'meeting_key', 'recording_url', 'session_key', 'date_start', 'date_end'], ['air_temperature', 'date', 'humidity', 'meeting_key', 'pressure', 'rainfall', 'session_key', 'track_temperature', 'wind_direction', 'wind_speed', 'date_start', 'date_end']]
    //TODO man kann auch als csv ausgeben mit csv=true
    const [applicableAttributes, setApplicableAttributes] = useState<string[]>(attributeItems[0]);


    const getSelectedCategoryIndex = (): number => {
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
            console.log(`https://api.openf1.org/v1/${selectedCategory[1]}?${queryTexts[getSelectedCategoryIndex()]}`);
            const response = await fetch(`https://api.openf1.org/v1/${selectedCategory[1]}?${queryTexts[getSelectedCategoryIndex()]}`);
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            const data = await response.json();
            setResponseData(data);
        } catch (error) {
            console.error('Error fetching data:', error);
        }
    };

    const handleCategoryChange = (index: number) => {
        setSelectedCategory(apiItems[index]);
        setApplicableAttributes(attributeItems[index]);
    };

    const handleQueryChange = (newQuery: string) => {
        const modifiedQueryTexts = [...queryTexts];
        modifiedQueryTexts[getSelectedCategoryIndex()] = newQuery;
        setQueryTexts(modifiedQueryTexts);
    };

    const toggleAttribute = (index: number) => {
        const modifiedQueryTexts = [...queryTexts];
        if (modifiedQueryTexts[getSelectedCategoryIndex()].includes(applicableAttributes[index])) {

            const indexOfAttribute = modifiedQueryTexts[getSelectedCategoryIndex()].indexOf(applicableAttributes[index]);
            const hasLeadingAmpersand = modifiedQueryTexts[getSelectedCategoryIndex()][indexOfAttribute - 1] === '&';
            const hasTrailingAmpersand = modifiedQueryTexts[getSelectedCategoryIndex()].indexOf('&', indexOfAttribute + 1) !== -1;

            if (hasLeadingAmpersand && hasTrailingAmpersand) {
                alert("1");
                modifiedQueryTexts[getSelectedCategoryIndex()] = modifiedQueryTexts[getSelectedCategoryIndex()].slice(0, indexOfAttribute - 1) + modifiedQueryTexts[getSelectedCategoryIndex()].slice(modifiedQueryTexts[getSelectedCategoryIndex()].indexOf('&', indexOfAttribute + 1));
            } else if (!hasLeadingAmpersand && hasTrailingAmpersand) {
                alert("2");
                modifiedQueryTexts[getSelectedCategoryIndex()] = modifiedQueryTexts[getSelectedCategoryIndex()].slice(0, indexOfAttribute) + modifiedQueryTexts[getSelectedCategoryIndex()].slice(modifiedQueryTexts[getSelectedCategoryIndex()].indexOf('&', indexOfAttribute + 1));
            } else if (hasLeadingAmpersand && !hasTrailingAmpersand) {
                alert("3");
                modifiedQueryTexts[getSelectedCategoryIndex()] = modifiedQueryTexts[getSelectedCategoryIndex()].slice(0, indexOfAttribute - 1) + modifiedQueryTexts[getSelectedCategoryIndex()].slice(indexOfAttribute + modifiedQueryTexts[getSelectedCategoryIndex()].length);
            } else if (!hasLeadingAmpersand && !hasTrailingAmpersand) {
                alert("4");
                modifiedQueryTexts[getSelectedCategoryIndex()] = modifiedQueryTexts[getSelectedCategoryIndex()].slice(0, indexOfAttribute) + modifiedQueryTexts[getSelectedCategoryIndex()].slice(indexOfAttribute + modifiedQueryTexts[getSelectedCategoryIndex()].length);
            }




            alert("removing");
            // modifiedQueryTexts[getSelectedCategoryIndex()] = modifiedQueryTexts[getSelectedCategoryIndex()].replace(`&${applicableAttributes[index]}=`, '');
        } else {
            alert("adding");
            modifiedQueryTexts[getSelectedCategoryIndex()] += `&${applicableAttributes[index]}=`;
        }
        setQueryTexts(modifiedQueryTexts);
    };


    return (
        <main className='p-20 mt-20'>
            {data && (
                <div>
                    <div className='mb-4 p-4 bg-fnbg-accent block'>
                        {apiItems.map((label, index) => (
                            <Button key={index} onClick={() => handleCategoryChange(index)} addClasses={`border-2 m-2 ${selectedCategory[0] === label[0] ? 'bg-fnbg-accent border-fnbg-orange text-white border-fnbg-accent' : 'border-fnbg-body bg-fnbg-accent text-fnbg-purple'}`}>{label[0]}</Button>
                        ))}
                    </div>

                    <div className='mb-4 p-4 bg-fnbg-accent flex'>
                        <p className='pr-4 pt-2 font-bold'>Query</p>
                        <input
                            className='p-1 border-2 border-fnbg-orange rounded-lg w-full'
                            type="text"
                            value={queryTexts[getSelectedCategoryIndex()]}
                            onChange={(e) => handleQueryChange(e.target.value)}
                        />
                        <Button onClick={fetchData} addClasses='border-2 border-fnbg-orange ml-4'>Execute</Button>
                    </div>

                    <div className='mb-4 p-4 bg-fnbg-accent block'>
                        {applicableAttributes.map((label, index) => (
                            <Button key={index} onClick={() => toggleAttribute(index)} addClasses={`border-2 m-2 ${'border-fnbg-body bg-fnbg-accent text-fnbg-purple'}`}>{label}</Button>
                        ))}
                    </div>
                </div>

            )}
            {responseData && (
                <div>
                    <div>
                        <ToggleButton onClick={undefined} offText={'Rohdaten'} onText={'Formatiert'}></ToggleButton>
                    </div>
                    <h2>Fetched Data:</h2>
                    <pre>{JSON.stringify(responseData, null, 2)}</pre>
                </div>
            )}
        </main>
    );
};

export default Homepage;
