"use client"
import React from 'react';
import { useLanguageData } from '@data/languageLoader';
import Tile from '@components/Tile/Tile';
import ElementTile from '@components/ElementTile/ElementTile';

//TODO amd intel nvidia comparator
//TODO clound upload with password



const Homepage: React.FC = () => {
  const data = useLanguageData("homepage");

  return (
    <main className='p-20 mt-20'>
      {data && (
        <div className="grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-3 xl:grid-cols-3 2xl:grid-cols-6 gap-4 m-auto">
          <Tile to='/periodicTable'>Periodic Table</Tile>
          <Tile to='https://marketplace.visualstudio.com/items?itemName=FabianBerger.angry-dino' newTab>Angry Dino Theme</Tile>
          <Tile to='https://curseforge.com/minecraft/mc-mods/non-intrusive-doors' newTab>Non Intrusive Doors Mod</Tile>
          <Tile to='https://blog.fnbg.de' newTab>FNBG Blog</Tile>
          <Tile to='https://github.com/BambiMC' newTab>Github</Tile>
          {/* <Tile to='/'>Big-Data.AI Summit 2019 & 2022</Tile> */}
          <Tile to='/DSAG-Beitrag.pdf'>DSAG Artikel 2019</Tile>
          <Tile to='/Kurzbeschreibung-Bachelorthesis.pdf'>Kurzbeschreibung Bachelorthesis</Tile>
          {/* <Tile to='/'></Tile> */}

        </div>
      )}
    </main>
  );
};

export default Homepage;