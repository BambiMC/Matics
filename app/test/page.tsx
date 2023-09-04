"use client"
import React from 'react';
import { useLanguageData } from '@/data/languageLoader';

const MyPage: React.FC = () => {
  const data = useLanguageData("homepage");

  return (
    <div>
      <h1 className='mt-32'>User Information</h1>
      {data && (
        <div>
          <p>{data['welcomeText']}</p>
          <p>{data['imprint']}</p>
        </div>
      )}
    </div>
  );
};

export default MyPage;