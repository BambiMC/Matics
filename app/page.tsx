"use client"
import React from 'react';
import { useLanguageData } from '@data/languageLoader';
import Triangles from '@app/components/Triangle/Triangles';

const Homepage: React.FC = () => {
  const data = useLanguageData("homepage");

  return (
    <div className='h-screen overflow-x-hidden md:overflow-y-hidden'>
      {data && (
        <div className='max-w-9xl mx-auto'>
          <main className='p-2 md:p-20 mt-32 md:mt-20'>
            <div className="flex justify-center items-center flex-row">
              <img className="w-3/6 z-20" src="imgs/W2.webp" alt={data['altPicture']} />
              <p className="z-30 w-2/6 p-4 md:p-8 lg:p-12 font-bold from-neutral-200 text-center text-xs md:text-lg -translate-x-12 bg-white/30 backdrop-blur-sm shadow-black drop-shadow-lg">
                {data['welcomeText']}
              </p>
              <div className='w-2/12'>
                <Triangles />
              </div>
            </div>
          </main>
        </div>
      )}
    </div>
  );
};

export default Homepage;