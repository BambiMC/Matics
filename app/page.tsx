"use client"
import React from 'react';
import { useLanguageData } from '@data/languageLoader';
import Triangle from '@app/components/Triangle/Triangle';

const Homepage: React.FC = () => {
  const data = useLanguageData("homepage");

  return (
    <div className='h-screen overflow-x-hidden md:overflow-y-hidden'>
      {data && (
        <div className='max-w-9xl mx-auto'>
          <main className='p-20 mt-20'>
            <div className="flex justify-center items-center flex-col md:flex-row">
              <img className="w-5/6 lg:w-2/6" src="imgs/W2.webp" alt={data['altPicture']} />
              <p className="z-10 w-5/6 lg:w-3/6 p-12 font-bold text-2xl from-neutral-200 bg-fnbg-accent text-center">
                {data['welcomeText']}
              </p>
              <div className='w-1/6'>
                <Triangle />
              </div>
            </div>
          </main>
        </div>
      )}
    </div>
  );
};

export default Homepage;
