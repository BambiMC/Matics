"use client"
import React from 'react';
import { useLanguageData } from '@data/languageLoader';
import Tile from './components/Tile/Tile';
import ElementTile from './components/ElementTile/ElementTile';

//TODO amd intel nvidia comparator
//TODO clound upload with password



const Homepage: React.FC = () => {
  const data = useLanguageData("homepage");

  return (
    <main className='p-20 mt-20'>
      {data && (
        <div className="grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-3 xl:grid-cols-3 2xl:grid-cols-6 gap-4 m-auto">
          <Tile to='/periodicTable'>Periodic Table</Tile>
          <Tile to='/test2'>test2</Tile>
        </div>
      )}
    </main>
  );
};

export default Homepage;