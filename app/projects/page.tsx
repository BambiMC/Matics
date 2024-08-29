"use client"
import React from 'react';
import { useLanguageData } from '@data/languageLoader';
import Tile from '@app/components/Tile/Tile';

//TODO amd intel nvidia comparator
//TODO clound upload with password



const Homepage: React.FC = () => {
  const data = useLanguageData("projects");

  return (
    <main className='p-20 mt-20'>
      {data && (
        <div className="grid grid-cols-1 sm:grid-cols-1 md:grid-cols-2 lg:grid-cols-2 xl:grid-cols-3 2xl:grid-cols-4 3xl:grid-cols-6 gap-4 m-auto">
          <Tile to='/periodicTable'>{data['periodicTable']}</Tile>
          <Tile to='https://marketplace.visualstudio.com/items?itemName=FabianBerger.angry-dino' newTab>{data['angrydino']}</Tile>
          <Tile to='https://curseforge.com/minecraft/mc-mods/non-intrusive-doors' newTab>{data['nonintrusivedoors']}</Tile>
          <Tile to='https://blog.fnbg.de' newTab>{data['blog']}</Tile>
          <Tile to='https://github.com/BambiMC' newTab>{data['github']}</Tile>
          {/* <Tile to='/'>Big-Data.AI Summit 2019 & 2022</Tile> */}
          <Tile to='/DSAG-Beitrag.pdf' newTab>{data['dsag']}</Tile>
          <Tile to='/Kurzbeschreibung-Bachelorthesis.pdf' newTab>{data['ba']}</Tile>
          <Tile to='https://dev.fnbg.de' newTab>{data['psg']}</Tile>
          <Tile to='/CPUX-F-Zertifikat-Fabian-Berger.pdf' newTab>{data['cpuxf']}</Tile>
          <Tile to='/ISTQB-CTFL-Zertifikat-Fabian-Berger.pdf' newTab>{data['ctfl']}</Tile>
          <Tile to='/Expose-Master-Projekt-Fabian-Berger.pdf' newTab>{data['masterProject']}</Tile>
          <Tile to='/OpenF1'>{data['openf1']}</Tile>
          {/* <Tile to='/'></Tile> */}


        </div>
      )}
    </main>
  );
};

export default Homepage;