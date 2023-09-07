"use client"
import React from 'react';
import { useLanguageData } from '@data/languageLoader';
import Tile from './components/Tile/Tile';

const Homepage: React.FC = () => {
  const data = useLanguageData("homepage");

  return (
    <main className='p-20 mt-20'>
      {data && (
        <div className="grid grid-cols-4 grid-rows-2 gap-4 xl:gap-16 2xl:gap-32">
          <Tile label='Binomial-Calculator' color='bg-red-50' to='/binomial-calculator'></Tile>
          <Tile label='Periodic Table' color='bg-red-100' to='/periodicTable'></Tile>
          <Tile label='Test3' color='bg-red-200' to='/test3'></Tile>
          <Tile label='Test4' color='bg-red-300' to='/test4'></Tile>
          <Tile label='Test5' color='bg-red-400' to='/test5'></Tile>
          <Tile label='Test6' color='bg-red-500' to='/test6'></Tile>
        </div>
      )}
    </main>
  );
};

export default Homepage;