"use client"
import React from 'react';
import { useLanguageData } from '@/data/languageLoader';
import Tile from './components/Tile/tile';

const Homepage: React.FC = () => {
  const data = useLanguageData("homepage");

  return (
    <div>
      {data && (
        <main className='p-20 mt-20'>
          <div className="grid grid-cols-4 grid-rows-2 gap-4 ">
            <Tile label='Binomial-Calculator' color='bg-red-50'></Tile>
            <Tile label='Periodic Table' color='bg-red-100'></Tile>
            <Tile label='Test3' color='bg-red-200'></Tile>
            <Tile label='Test4' color='bg-red-300'></Tile>
            <Tile label='Test5' color='bg-red-400'></Tile>
            <Tile label='Test6' color='bg-red-500'></Tile>
          </div>
        </main >
      )}
    </div>
  );
};

export default Homepage;