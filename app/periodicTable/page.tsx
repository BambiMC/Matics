"use client"
import React from 'react';
import ElementTile from '@app/components/ElementTile/ElementTile';
import { elements } from '@public/libraryChemistry';
import { useLanguageData } from '@data/languageLoader';


const Projects: React.FC = () => {
  const data = useLanguageData("periodicTable");
  return (


    <main className='mx-auto max-w-9xl mt-16 lg:mt-8'>
      <div className="grid grid-cols-18 grid-rows-9 gap-0 sm:gap-1 md:gap-2 xl:gap-4 m-4 md:m-16">
        {/* Line Number 1 */}
        <ElementTile addClasses='bg-cyan-500' elementData={elements[0]} />
        <ElementTile addClasses='bg-purple-500 col-start-18' elementData={elements[1]} />
        {/* Line Number 2 */}
        <ElementTile addClasses='bg-red-500' elementData={elements[2]} />
        <ElementTile addClasses='bg-amber-500' elementData={elements[3]} />
        <ElementTile addClasses='bg-teal-300 col-start-13' elementData={elements[4]} />
        <ElementTile addClasses='bg-cyan-500' elementData={elements[5]} />
        <ElementTile addClasses='bg-cyan-500' elementData={elements[6]} />
        <ElementTile addClasses='bg-cyan-500' elementData={elements[7]} />
        <ElementTile addClasses='bg-blue-600' elementData={elements[8]} />
        <ElementTile addClasses='bg-purple-500' elementData={elements[9]} />
        {/* Line Number 3 */}
        <ElementTile addClasses='bg-red-500' elementData={elements[10]} />
        <ElementTile addClasses='bg-amber-500' elementData={elements[11]} />
        <ElementTile addClasses='bg-green-600 col-start-13' elementData={elements[12]} />
        <ElementTile addClasses='bg-teal-300' elementData={elements[13]} />
        <ElementTile addClasses='bg-cyan-500' elementData={elements[14]} />
        <ElementTile addClasses='bg-cyan-500' elementData={elements[15]} />
        <ElementTile addClasses='bg-blue-600' elementData={elements[16]} />
        <ElementTile addClasses='bg-purple-500' elementData={elements[17]} />
        {/* Line Number 4 */}
        <ElementTile addClasses='bg-red-500' elementData={elements[18]} />
        <ElementTile addClasses='bg-amber-500' elementData={elements[19]} />
        <ElementTile addClasses='bg-yellow-300' elementData={elements[20]} />
        <ElementTile addClasses='bg-yellow-300' elementData={elements[21]} />
        <ElementTile addClasses='bg-yellow-300' elementData={elements[22]} />
        <ElementTile addClasses='bg-yellow-300' elementData={elements[23]} />
        <ElementTile addClasses='bg-yellow-300' elementData={elements[24]} />
        <ElementTile addClasses='bg-yellow-300' elementData={elements[25]} />
        <ElementTile addClasses='bg-yellow-300' elementData={elements[26]} />
        <ElementTile addClasses='bg-yellow-300' elementData={elements[27]} />
        <ElementTile addClasses='bg-yellow-300' elementData={elements[28]} />
        <ElementTile addClasses='bg-yellow-300' elementData={elements[29]} />
        <ElementTile addClasses='bg-green-600' elementData={elements[30]} />
        <ElementTile addClasses='bg-teal-300' elementData={elements[31]} />
        <ElementTile addClasses='bg-teal-300' elementData={elements[32]} />
        <ElementTile addClasses='bg-cyan-500' elementData={elements[33]} />
        <ElementTile addClasses='bg-blue-600' elementData={elements[34]} />
        <ElementTile addClasses='bg-purple-500' elementData={elements[35]} />
        {/* Line Number 5 */}
        <ElementTile addClasses='bg-red-500' elementData={elements[36]} />
        <ElementTile addClasses='bg-amber-500' elementData={elements[37]} />
        <ElementTile addClasses='bg-yellow-300' elementData={elements[38]} />
        <ElementTile addClasses='bg-yellow-300' elementData={elements[39]} />
        <ElementTile addClasses='bg-yellow-300' elementData={elements[40]} />
        <ElementTile addClasses='bg-yellow-300' elementData={elements[41]} />
        <ElementTile addClasses='bg-yellow-300' elementData={elements[42]} />
        <ElementTile addClasses='bg-yellow-300' elementData={elements[43]} />
        <ElementTile addClasses='bg-yellow-300' elementData={elements[44]} />
        <ElementTile addClasses='bg-yellow-300' elementData={elements[45]} />
        <ElementTile addClasses='bg-yellow-300' elementData={elements[46]} />
        <ElementTile addClasses='bg-yellow-300' elementData={elements[47]} />
        <ElementTile addClasses='bg-green-600' elementData={elements[48]} />
        <ElementTile addClasses='bg-green-600' elementData={elements[49]} />
        <ElementTile addClasses='bg-teal-300' elementData={elements[50]} />
        <ElementTile addClasses='bg-teal-300' elementData={elements[51]} />
        <ElementTile addClasses='bg-blue-600' elementData={elements[52]} />
        <ElementTile addClasses='bg-purple-500' elementData={elements[53]} />
        {/* Line Number 6 */}
        <ElementTile addClasses='bg-red-500' elementData={elements[54]} />
        <ElementTile addClasses='bg-amber-500' elementData={elements[55]} />
        <div className='bg-rose-400 text-xs md:text-xl xl:text-2xl text-center flex items-center justify-center text-black p-0 md:p-2 xl:p-4 2xl:p-8 border-2 border-black'>↓</div>
        <ElementTile addClasses='bg-yellow-300' elementData={elements[71]} />
        <ElementTile addClasses='bg-yellow-300' elementData={elements[72]} />
        <ElementTile addClasses='bg-yellow-300' elementData={elements[73]} />
        <ElementTile addClasses='bg-yellow-300' elementData={elements[74]} />
        <ElementTile addClasses='bg-yellow-300' elementData={elements[75]} />
        <ElementTile addClasses='bg-yellow-300' elementData={elements[76]} />
        <ElementTile addClasses='bg-yellow-300' elementData={elements[77]} />
        <ElementTile addClasses='bg-yellow-300' elementData={elements[78]} />
        <ElementTile addClasses='bg-yellow-300' elementData={elements[79]} />
        <ElementTile addClasses='bg-green-600' elementData={elements[80]} />
        <ElementTile addClasses='bg-green-600' elementData={elements[81]} />
        <ElementTile addClasses='bg-green-600' elementData={elements[82]} />
        <ElementTile addClasses='bg-teal-300' elementData={elements[83]} />
        <ElementTile addClasses='bg-blue-600' elementData={elements[84]} />
        <ElementTile addClasses='bg-purple-500' elementData={elements[85]} />
        {/* Line Number 7 */}
        <ElementTile addClasses='bg-red-500' elementData={elements[86]} />
        <ElementTile addClasses='bg-amber-500' elementData={elements[87]} />
        <div className='bg-pink-500 text-xs md:text-xl xl:text-2xl text-center flex items-center justify-center text-black p-0 md:p-2 xl:p-4 2xl:p-8 border-2 border-black'>↓</div>
        <ElementTile addClasses='bg-yellow-300' elementData={elements[103]} />
        <ElementTile addClasses='bg-yellow-300' elementData={elements[104]} />
        <ElementTile addClasses='bg-yellow-300' elementData={elements[105]} />
        <ElementTile addClasses='bg-yellow-300' elementData={elements[106]} />
        <ElementTile addClasses='bg-yellow-300' elementData={elements[107]} />
        <ElementTile addClasses='bg-yellow-300' elementData={elements[108]} />
        <ElementTile addClasses='bg-yellow-300' elementData={elements[109]} />
        <ElementTile addClasses='bg-yellow-300' elementData={elements[110]} />
        <ElementTile addClasses='bg-yellow-300' elementData={elements[111]} />
        <ElementTile addClasses='bg-green-600' elementData={elements[112]} />
        <ElementTile addClasses='bg-green-600' elementData={elements[113]} />
        <ElementTile addClasses='bg-green-600' elementData={elements[114]} />
        <ElementTile addClasses='bg-green-600' elementData={elements[115]} />
        <ElementTile addClasses='bg-blue-600' elementData={elements[116]} />
        <ElementTile addClasses='bg-purple-500' elementData={elements[117]} />
        {/* Line Number 8 */}
        <ElementTile addClasses='bg-rose-400 col-start-3 mt-4' elementData={elements[56]} />
        <ElementTile addClasses='bg-rose-400 mt-4' elementData={elements[57]} />
        <ElementTile addClasses='bg-rose-400 mt-4' elementData={elements[58]} />
        <ElementTile addClasses='bg-rose-400 mt-4' elementData={elements[59]} />
        <ElementTile addClasses='bg-rose-400 mt-4' elementData={elements[60]} />
        <ElementTile addClasses='bg-rose-400 mt-4' elementData={elements[61]} />
        <ElementTile addClasses='bg-rose-400 mt-4' elementData={elements[62]} />
        <ElementTile addClasses='bg-rose-400 mt-4' elementData={elements[63]} />
        <ElementTile addClasses='bg-rose-400 mt-4' elementData={elements[64]} />
        <ElementTile addClasses='bg-rose-400 mt-4' elementData={elements[65]} />
        <ElementTile addClasses='bg-rose-400 mt-4' elementData={elements[66]} />
        <ElementTile addClasses='bg-rose-400 mt-4' elementData={elements[67]} />
        <ElementTile addClasses='bg-rose-400 mt-4' elementData={elements[68]} />
        <ElementTile addClasses='bg-rose-400 mt-4' elementData={elements[69]} />
        <ElementTile addClasses='bg-rose-400 mt-4' elementData={elements[70]} />
        {/* Line Number 9 */}
        <ElementTile addClasses='bg-pink-500 col-start-3' elementData={elements[88]} />
        <ElementTile addClasses='bg-pink-500' elementData={elements[89]} />
        <ElementTile addClasses='bg-pink-500' elementData={elements[90]} />
        <ElementTile addClasses='bg-pink-500' elementData={elements[91]} />
        <ElementTile addClasses='bg-pink-500' elementData={elements[92]} />
        <ElementTile addClasses='bg-pink-500' elementData={elements[93]} />
        <ElementTile addClasses='bg-pink-500' elementData={elements[94]} />
        <ElementTile addClasses='bg-pink-500' elementData={elements[95]} />
        <ElementTile addClasses='bg-pink-500' elementData={elements[96]} />
        <ElementTile addClasses='bg-pink-500' elementData={elements[97]} />
        <ElementTile addClasses='bg-pink-500' elementData={elements[98]} />
        <ElementTile addClasses='bg-pink-500' elementData={elements[99]} />
        <ElementTile addClasses='bg-pink-500' elementData={elements[100]} />
        <ElementTile addClasses='bg-pink-500' elementData={elements[101]} />
        <ElementTile addClasses='bg-pink-500' elementData={elements[102]} />



      </div>
    </main>
  );
};

export default Projects;