"use client"
import React from 'react';
import { useLanguageData } from '@/data/languageLoader';
import Triangle from '@/app/components/Triangle/Triangle';

const Homepage: React.FC = () => {
  const data = useLanguageData();

  return (
    <div>
      {data && (
        <main className='overflow-visible p-20 mt-20'>
          <div className="flex justify-evenly flex-col md:flex-row">
            <img className=" w-5/6 lg:w-2/6 self-center" src="/W2.webp" alt={data['altPicture']} />
            <p className="z-10 ml-4 w-5/6 lg:w-3/6 self-center p-12 font-bold text-2xl from-neutral-200" style={{ backgroundColor: "var(--bg-accent)" }}>
              {data['welcomeText']}
            </p>
            <div className='w-1/6'>
              <Triangle />
            </div>
          </div>

        </main >
      )}

    </div>
  );
};

export default Homepage;