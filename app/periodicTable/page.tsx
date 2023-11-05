"use client"
import React from 'react';
import ElementTile from '@app/components/ElementTile/ElementTile';
import { elements } from '@public/libraryChemistry';
import { useLanguageData } from '@data/languageLoader';


const Projects: React.FC = () => {
  const data = useLanguageData("periodicTable");
  return (

    <main className='mx-auto max-w-9xl mt-40 md:mt-20 lg:mt-24'>
      <div className="grid grid-cols-18 grid-rows-9 gap-0 sm:gap-1 lg:gap-2 xl:gap-4">
        {/* Line Number 1 */}
        <ElementTile className='bg-cyan-500' elementData={elements[0]} />
        <ElementTile className='bg-purple-500 col-start-18' elementData={elements[1]} />
        {/* Line Number 2 */}
        <ElementTile className='bg-red-500' elementData={elements[2]} />
        <ElementTile className='bg-amber-500' elementData={elements[3]} />
        <ElementTile className='bg-teal-300 col-start-13' elementData={elements[4]} />
        <ElementTile className='bg-cyan-500' elementData={elements[5]} />
        <ElementTile className='bg-cyan-500' elementData={elements[6]} />
        <ElementTile className='bg-cyan-500' elementData={elements[7]} />
        <ElementTile className='bg-blue-600' elementData={elements[8]} />
        <ElementTile className='bg-purple-500' elementData={elements[9]} />
        {/* Line Number 3 */}
        <ElementTile className='bg-red-500' elementData={elements[10]} />
        <ElementTile className='bg-amber-500' elementData={elements[11]} />
        <ElementTile className='bg-green-600 col-start-13' elementData={elements[12]} />
        <ElementTile className='bg-teal-300' elementData={elements[13]} />
        <ElementTile className='bg-cyan-500' elementData={elements[14]} />
        <ElementTile className='bg-cyan-500' elementData={elements[15]} />
        <ElementTile className='bg-blue-600' elementData={elements[16]} />
        <ElementTile className='bg-purple-500' elementData={elements[17]} />
        {/* Line Number 4 */}
        <ElementTile className='bg-red-500' elementData={elements[18]} />
        <ElementTile className='bg-amber-500' elementData={elements[19]} />
        <ElementTile className='bg-yellow-300' elementData={elements[20]} />
        <ElementTile className='bg-yellow-300' elementData={elements[21]} />
        <ElementTile className='bg-yellow-300' elementData={elements[22]} />
        <ElementTile className='bg-yellow-300' elementData={elements[23]} />
        <ElementTile className='bg-yellow-300' elementData={elements[24]} />
        <ElementTile className='bg-yellow-300' elementData={elements[25]} />
        <ElementTile className='bg-yellow-300' elementData={elements[26]} />
        <ElementTile className='bg-yellow-300' elementData={elements[27]} />
        <ElementTile className='bg-yellow-300' elementData={elements[28]} />
        <ElementTile className='bg-yellow-300' elementData={elements[29]} />
        <ElementTile className='bg-green-600' elementData={elements[30]} />
        <ElementTile className='bg-teal-300' elementData={elements[31]} />
        <ElementTile className='bg-teal-300' elementData={elements[32]} />
        <ElementTile className='bg-cyan-500' elementData={elements[33]} />
        <ElementTile className='bg-blue-600' elementData={elements[34]} />
        <ElementTile className='bg-purple-500' elementData={elements[35]} />
        {/* Line Number 5 */}
        <ElementTile className='bg-red-500' elementData={elements[36]} />
        <ElementTile className='bg-amber-500' elementData={elements[37]} />
        <ElementTile className='bg-yellow-300' elementData={elements[38]} />
        <ElementTile className='bg-yellow-300' elementData={elements[39]} />
        <ElementTile className='bg-yellow-300' elementData={elements[40]} />
        <ElementTile className='bg-yellow-300' elementData={elements[41]} />
        <ElementTile className='bg-yellow-300' elementData={elements[42]} />
        <ElementTile className='bg-yellow-300' elementData={elements[43]} />
        <ElementTile className='bg-yellow-300' elementData={elements[44]} />
        <ElementTile className='bg-yellow-300' elementData={elements[45]} />
        <ElementTile className='bg-yellow-300' elementData={elements[46]} />
        <ElementTile className='bg-yellow-300' elementData={elements[47]} />
        <ElementTile className='bg-green-600' elementData={elements[48]} />
        <ElementTile className='bg-green-600' elementData={elements[49]} />
        <ElementTile className='bg-teal-300' elementData={elements[50]} />
        <ElementTile className='bg-teal-300' elementData={elements[51]} />
        <ElementTile className='bg-blue-600' elementData={elements[52]} />
        <ElementTile className='bg-purple-500' elementData={elements[53]} />
        {/* Line Number 6 */}
        <ElementTile className='bg-red-500' elementData={elements[54]} />
        <ElementTile className='bg-amber-500' elementData={elements[55]} />
        <ElementTile className='bg-rose-400' />
        <ElementTile className='bg-yellow-300' elementData={elements[71]} />
        <ElementTile className='bg-yellow-300' elementData={elements[72]} />
        <ElementTile className='bg-yellow-300' elementData={elements[73]} />
        <ElementTile className='bg-yellow-300' elementData={elements[74]} />
        <ElementTile className='bg-yellow-300' elementData={elements[75]} />
        <ElementTile className='bg-yellow-300' elementData={elements[76]} />
        <ElementTile className='bg-yellow-300' elementData={elements[77]} />
        <ElementTile className='bg-yellow-300' elementData={elements[78]} />
        <ElementTile className='bg-yellow-300' elementData={elements[79]} />
        <ElementTile className='bg-green-600' elementData={elements[80]} />
        <ElementTile className='bg-green-600' elementData={elements[81]} />
        <ElementTile className='bg-green-600' elementData={elements[82]} />
        <ElementTile className='bg-teal-300' elementData={elements[83]} />
        <ElementTile className='bg-blue-600' elementData={elements[84]} />
        <ElementTile className='bg-purple-500' elementData={elements[85]} />
        {/* Line Number 7 */}
        <ElementTile className='bg-red-500' elementData={elements[86]} />
        <ElementTile className='bg-amber-500' elementData={elements[87]} />
        <ElementTile className='bg-pink-500' />
        <ElementTile className='bg-yellow-300' elementData={elements[103]} />
        <ElementTile className='bg-yellow-300' elementData={elements[104]} />
        <ElementTile className='bg-yellow-300' elementData={elements[105]} />
        <ElementTile className='bg-yellow-300' elementData={elements[106]} />
        <ElementTile className='bg-yellow-300' elementData={elements[107]} />
        <ElementTile className='bg-yellow-300' elementData={elements[108]} />
        <ElementTile className='bg-yellow-300' elementData={elements[109]} />
        <ElementTile className='bg-yellow-300' elementData={elements[110]} />
        <ElementTile className='bg-yellow-300' elementData={elements[111]} />
        <ElementTile className='bg-green-600' elementData={elements[112]} />
        <ElementTile className='bg-green-600' elementData={elements[113]} />
        <ElementTile className='bg-green-600' elementData={elements[114]} />
        <ElementTile className='bg-green-600' elementData={elements[115]} />
        <ElementTile className='bg-blue-600' elementData={elements[116]} />
        <ElementTile className='bg-purple-500' elementData={elements[117]} />
        {/* Line Number 8 */}
        <ElementTile className='bg-rose-400 col-start-3 mt-4' elementData={elements[56]} />
        <ElementTile className='bg-rose-400 mt-4' elementData={elements[57]} />
        <ElementTile className='bg-rose-400 mt-4' elementData={elements[58]} />
        <ElementTile className='bg-rose-400 mt-4' elementData={elements[59]} />
        <ElementTile className='bg-rose-400 mt-4' elementData={elements[60]} />
        <ElementTile className='bg-rose-400 mt-4' elementData={elements[61]} />
        <ElementTile className='bg-rose-400 mt-4' elementData={elements[62]} />
        <ElementTile className='bg-rose-400 mt-4' elementData={elements[63]} />
        <ElementTile className='bg-rose-400 mt-4' elementData={elements[64]} />
        <ElementTile className='bg-rose-400 mt-4' elementData={elements[65]} />
        <ElementTile className='bg-rose-400 mt-4' elementData={elements[66]} />
        <ElementTile className='bg-rose-400 mt-4' elementData={elements[67]} />
        <ElementTile className='bg-rose-400 mt-4' elementData={elements[68]} />
        <ElementTile className='bg-rose-400 mt-4' elementData={elements[69]} />
        <ElementTile className='bg-rose-400 mt-4' elementData={elements[70]} />
        {/* Line Number 9 */}
        <ElementTile className='bg-pink-500 col-start-3' elementData={elements[88]} />
        <ElementTile className='bg-pink-500' elementData={elements[89]} />
        <ElementTile className='bg-pink-500' elementData={elements[90]} />
        <ElementTile className='bg-pink-500' elementData={elements[91]} />
        <ElementTile className='bg-pink-500' elementData={elements[92]} />
        <ElementTile className='bg-pink-500' elementData={elements[93]} />
        <ElementTile className='bg-pink-500' elementData={elements[94]} />
        <ElementTile className='bg-pink-500' elementData={elements[95]} />
        <ElementTile className='bg-pink-500' elementData={elements[96]} />
        <ElementTile className='bg-pink-500' elementData={elements[97]} />
        <ElementTile className='bg-pink-500' elementData={elements[98]} />
        <ElementTile className='bg-pink-500' elementData={elements[99]} />
        <ElementTile className='bg-pink-500' elementData={elements[100]} />
        <ElementTile className='bg-pink-500' elementData={elements[101]} />
        <ElementTile className='bg-pink-500' elementData={elements[102]} />

      </div>
    </main>
  );
};

export default Projects;