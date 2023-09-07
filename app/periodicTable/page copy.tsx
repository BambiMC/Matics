"use client"
import { useLanguageData } from '@data/languageLoader';


const Projects: React.FC = () => {
  const data = useLanguageData("periodicTable");
  return (


    <main className='p-20 mt-20'>
      {data && (
        <div className="grid grid-cols-4 grid-rows-2 gap-4 xl:gap-16 2xl:gap-32">
          <div></div>
          <div></div>
          <div></div>
          <div></div>
          <div></div>
          <div></div>
        </div>
      )}
    </main>
  );
};

export default Projects;