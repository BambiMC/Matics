"use client"
import React from 'react';
import { useLanguageData } from '@data/languageLoader';
import Tile from './components/Tile/Tile';

const Homepage: React.FC = () => {
  const data = useLanguageData("homepage");

  return (
    <main className='p-20 mt-20'>
      {data && (
        <div className="grid grid-cols-8 grid-rows-2 gap-4 xl:gap-16 2xl:gap-3">
          <Tile label='Periodic Table' color='bg-white' to='/periodicTable'></Tile>
          <Tile label='Test2' color='bg-white' to='/test2'></Tile>
          <Tile label='Test3' color='bg-white' to='/test3'></Tile>
          <Tile label='Test4' color='bg-white' to='/test4'></Tile>
          <Tile label='Test5' color='bg-white' to='/test5'></Tile>
          <Tile label='Test6' color='bg-white' to='/test6'></Tile>
        </div>
      )}
    </main>
  );
};

export default Homepage;