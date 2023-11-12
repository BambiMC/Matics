"use client"
import React from 'react';
import ElementTile from '@app/components/ElementTile/ElementTile';
import { elements } from '@public/libraryChemistry';
import { useLanguageData } from '@data/languageLoader';
import PSEFilter from '@app/components/PSEFilter/PSEFilter';


const Projects: React.FC = () => {
  const data = useLanguageData("periodicTable");
  return (

    <main className='mx-auto max-w-9xl my-40 md:mt-20 lg:mt-24'>
      <PSEFilter elements={elements} />
      <div className="grid grid-cols-18 grid-rows-9 gap-0 sm:gap-1 lg:gap-2 xl:gap-4">
        {/* Line Number 1 */}
        <ElementTile addClasses='bg-cyan-500' elementData={elements[0]} id='ElliTile-0' />
        <ElementTile addClasses='bg-purple-500 col-start-18' elementData={elements[1]} id='ElliTile-1' />
        {/* Line Number 2 */}
        <ElementTile addClasses='bg-red-500' elementData={elements[2]} id='ElliTile-2' />
        <ElementTile addClasses='bg-amber-500' elementData={elements[3]} id='ElliTile-3' />
        <ElementTile addClasses='bg-teal-300 col-start-13' elementData={elements[4]} id='ElliTile-4' />
        <ElementTile addClasses='bg-cyan-500' elementData={elements[5]} id='ElliTile-5' />
        <ElementTile addClasses='bg-cyan-500' elementData={elements[6]} id='ElliTile-6' />
        <ElementTile addClasses='bg-cyan-500' elementData={elements[7]} id='ElliTile-7' />
        <ElementTile addClasses='bg-blue-600' elementData={elements[8]} id='ElliTile-8' />
        <ElementTile addClasses='bg-purple-500' elementData={elements[9]} id='ElliTile-9' />
        {/* Line Number 3 */}
        <ElementTile addClasses='bg-red-500' elementData={elements[10]} id='ElliTile-10' />
        <ElementTile addClasses='bg-amber-500' elementData={elements[11]} id='ElliTile-11' />
        <ElementTile addClasses='bg-green-600 col-start-13' elementData={elements[12]} id='ElliTile-12' />
        <ElementTile addClasses='bg-teal-300' elementData={elements[13]} id='ElliTile-13' />
        <ElementTile addClasses='bg-cyan-500' elementData={elements[14]} id='ElliTile-14' />
        <ElementTile addClasses='bg-cyan-500' elementData={elements[15]} id='ElliTile-15' />
        <ElementTile addClasses='bg-blue-600' elementData={elements[16]} id='ElliTile-16' />
        <ElementTile addClasses='bg-purple-500' elementData={elements[17]} id='ElliTile-17' />
        {/* Line Number 4 */}
        <ElementTile addClasses='bg-red-500' elementData={elements[18]} id='ElliTile-18' />
        <ElementTile addClasses='bg-amber-500' elementData={elements[19]} id='ElliTile-19' />
        <ElementTile addClasses='bg-yellow-300' elementData={elements[20]} id='ElliTile-20' />
        <ElementTile addClasses='bg-yellow-300' elementData={elements[21]} id='ElliTile-21' />
        <ElementTile addClasses='bg-yellow-300' elementData={elements[22]} id='ElliTile-22' />
        <ElementTile addClasses='bg-yellow-300' elementData={elements[23]} id='ElliTile-23' />
        <ElementTile addClasses='bg-yellow-300' elementData={elements[24]} id='ElliTile-24' />
        <ElementTile addClasses='bg-yellow-300' elementData={elements[25]} id='ElliTile-25' />
        <ElementTile addClasses='bg-yellow-300' elementData={elements[26]} id='ElliTile-26' />
        <ElementTile addClasses='bg-yellow-300' elementData={elements[27]} id='ElliTile-27' />
        <ElementTile addClasses='bg-yellow-300' elementData={elements[28]} id='ElliTile-28' />
        <ElementTile addClasses='bg-yellow-300' elementData={elements[29]} id='ElliTile-29' />
        <ElementTile addClasses='bg-green-600' elementData={elements[30]} id='ElliTile-30' />
        <ElementTile addClasses='bg-teal-300' elementData={elements[31]} id='ElliTile-31' />
        <ElementTile addClasses='bg-teal-300' elementData={elements[32]} id='ElliTile-32' />
        <ElementTile addClasses='bg-cyan-500' elementData={elements[33]} id='ElliTile-33' />
        <ElementTile addClasses='bg-blue-600' elementData={elements[34]} id='ElliTile-34' />
        <ElementTile addClasses='bg-purple-500' elementData={elements[35]} id='ElliTile-35' />
        {/* Line Number 5 */}
        <ElementTile addClasses='bg-red-500' elementData={elements[36]} id='ElliTile-36' />
        <ElementTile addClasses='bg-amber-500' elementData={elements[37]} id='ElliTile-37' />
        <ElementTile addClasses='bg-yellow-300' elementData={elements[38]} id='ElliTile-38' />
        <ElementTile addClasses='bg-yellow-300' elementData={elements[39]} id='ElliTile-39' />
        <ElementTile addClasses='bg-yellow-300' elementData={elements[40]} id='ElliTile-40' />
        <ElementTile addClasses='bg-yellow-300' elementData={elements[41]} id='ElliTile-41' />
        <ElementTile addClasses='bg-yellow-300' elementData={elements[42]} id='ElliTile-42' />
        <ElementTile addClasses='bg-yellow-300' elementData={elements[43]} id='ElliTile-43' />
        <ElementTile addClasses='bg-yellow-300' elementData={elements[44]} id='ElliTile-44' />
        <ElementTile addClasses='bg-yellow-300' elementData={elements[45]} id='ElliTile-45' />
        <ElementTile addClasses='bg-yellow-300' elementData={elements[46]} id='ElliTile-46' />
        <ElementTile addClasses='bg-yellow-300' elementData={elements[47]} id='ElliTile-47' />
        <ElementTile addClasses='bg-green-600' elementData={elements[48]} id='ElliTile-48' />
        <ElementTile addClasses='bg-green-600' elementData={elements[49]} id='ElliTile-49' />
        <ElementTile addClasses='bg-teal-300' elementData={elements[50]} id='ElliTile-50' />
        <ElementTile addClasses='bg-teal-300' elementData={elements[51]} id='ElliTile-51' />
        <ElementTile addClasses='bg-blue-600' elementData={elements[52]} id='ElliTile-52' />
        <ElementTile addClasses='bg-purple-500' elementData={elements[53]} id='ElliTile-53' />
        {/* Line Number 6 */}
        <ElementTile addClasses='bg-red-500' elementData={elements[54]} id='ElliTile-54' />
        <ElementTile addClasses='bg-amber-500' elementData={elements[55]} id='ElliTile-55' />
        <ElementTile addClasses='bg-rose-400' placeholder={false} />
        <ElementTile addClasses='bg-yellow-300' elementData={elements[71]} id='ElliTile-71' />
        <ElementTile addClasses='bg-yellow-300' elementData={elements[72]} id='ElliTile-72' />
        <ElementTile addClasses='bg-yellow-300' elementData={elements[73]} id='ElliTile-73' />
        <ElementTile addClasses='bg-yellow-300' elementData={elements[74]} id='ElliTile-74' />
        <ElementTile addClasses='bg-yellow-300' elementData={elements[75]} id='ElliTile-75' />
        <ElementTile addClasses='bg-yellow-300' elementData={elements[76]} id='ElliTile-76' />
        <ElementTile addClasses='bg-yellow-300' elementData={elements[77]} id='ElliTile-77' />
        <ElementTile addClasses='bg-yellow-300' elementData={elements[78]} id='ElliTile-78' />
        <ElementTile addClasses='bg-yellow-300' elementData={elements[79]} id='ElliTile-79' />
        <ElementTile addClasses='bg-green-600' elementData={elements[80]} id='ElliTile-80' />
        <ElementTile addClasses='bg-green-600' elementData={elements[81]} id='ElliTile-81' />
        <ElementTile addClasses='bg-green-600' elementData={elements[82]} id='ElliTile-82' />
        <ElementTile addClasses='bg-teal-300' elementData={elements[83]} id='ElliTile-83' />
        <ElementTile addClasses='bg-blue-600' elementData={elements[84]} id='ElliTile-84' />
        <ElementTile addClasses='bg-purple-500' elementData={elements[85]} id='ElliTile-85' />
        {/* Line Number 7 */}
        <ElementTile addClasses='bg-red-500' elementData={elements[86]} id='ElliTile-86' />
        <ElementTile addClasses='bg-amber-500' elementData={elements[87]} id='ElliTile-87' />
        <ElementTile addClasses='bg-pink-500' placeholder={false} />
        <ElementTile addClasses='bg-yellow-300' elementData={elements[103]} id='ElliTile-103' />
        <ElementTile addClasses='bg-yellow-300' elementData={elements[104]} id='ElliTile-104' />
        <ElementTile addClasses='bg-yellow-300' elementData={elements[105]} id='ElliTile-105' />
        <ElementTile addClasses='bg-yellow-300' elementData={elements[106]} id='ElliTile-106' />
        <ElementTile addClasses='bg-yellow-300' elementData={elements[107]} id='ElliTile-107' />
        <ElementTile addClasses='bg-yellow-300' elementData={elements[108]} id='ElliTile-108' />
        <ElementTile addClasses='bg-yellow-300' elementData={elements[109]} id='ElliTile-109' />
        <ElementTile addClasses='bg-yellow-300' elementData={elements[110]} id='ElliTile-110' />
        <ElementTile addClasses='bg-yellow-300' elementData={elements[111]} id='ElliTile-111' />
        <ElementTile addClasses='bg-green-600' elementData={elements[112]} id='ElliTile-112' />
        <ElementTile addClasses='bg-green-600' elementData={elements[113]} id='ElliTile-113' />
        <ElementTile addClasses='bg-green-600' elementData={elements[114]} id='ElliTile-114' />
        <ElementTile addClasses='bg-green-600' elementData={elements[115]} id='ElliTile-115' />
        <ElementTile addClasses='bg-blue-600' elementData={elements[116]} id='ElliTile-116' />
        <ElementTile addClasses='bg-purple-500' elementData={elements[117]} id='ElliTile-117' />
        {/* Line Number 8 */}
        <ElementTile addClasses='bg-rose-400 col-start-3 mt-4' elementData={elements[56]} id='ElliTile-56' />
        <ElementTile addClasses='bg-rose-400 mt-4' elementData={elements[57]} id='ElliTile-57' />
        <ElementTile addClasses='bg-rose-400 mt-4' elementData={elements[58]} id='ElliTile-58' />
        <ElementTile addClasses='bg-rose-400 mt-4' elementData={elements[59]} id='ElliTile-59' />
        <ElementTile addClasses='bg-rose-400 mt-4' elementData={elements[60]} id='ElliTile-60' />
        <ElementTile addClasses='bg-rose-400 mt-4' elementData={elements[61]} id='ElliTile-61' />
        <ElementTile addClasses='bg-rose-400 mt-4' elementData={elements[62]} id='ElliTile-62' />
        <ElementTile addClasses='bg-rose-400 mt-4' elementData={elements[63]} id='ElliTile-63' />
        <ElementTile addClasses='bg-rose-400 mt-4' elementData={elements[64]} id='ElliTile-64' />
        <ElementTile addClasses='bg-rose-400 mt-4' elementData={elements[65]} id='ElliTile-65' />
        <ElementTile addClasses='bg-rose-400 mt-4' elementData={elements[66]} id='ElliTile-66' />
        <ElementTile addClasses='bg-rose-400 mt-4' elementData={elements[67]} id='ElliTile-67' />
        <ElementTile addClasses='bg-rose-400 mt-4' elementData={elements[68]} id='ElliTile-68' />
        <ElementTile addClasses='bg-rose-400 mt-4' elementData={elements[69]} id='ElliTile-69' />
        <ElementTile addClasses='bg-rose-400 mt-4' elementData={elements[70]} id='ElliTile-70' />
        {/* Line Number 9 */}
        <ElementTile addClasses='bg-pink-500 col-start-3' elementData={elements[88]} id='ElliTile-88' />
        <ElementTile addClasses='bg-pink-500' elementData={elements[89]} id='ElliTile-89' />
        <ElementTile addClasses='bg-pink-500' elementData={elements[90]} id='ElliTile-90' />
        <ElementTile addClasses='bg-pink-500' elementData={elements[91]} id='ElliTile-91' />
        <ElementTile addClasses='bg-pink-500' elementData={elements[92]} id='ElliTile-92' />
        <ElementTile addClasses='bg-pink-500' elementData={elements[93]} id='ElliTile-93' />
        <ElementTile addClasses='bg-pink-500' elementData={elements[94]} id='ElliTile-94' />
        <ElementTile addClasses='bg-pink-500' elementData={elements[95]} id='ElliTile-95' />
        <ElementTile addClasses='bg-pink-500' elementData={elements[96]} id='ElliTile-96' />
        <ElementTile addClasses='bg-pink-500' elementData={elements[97]} id='ElliTile-97' />
        <ElementTile addClasses='bg-pink-500' elementData={elements[98]} id='ElliTile-98' />
        <ElementTile addClasses='bg-pink-500' elementData={elements[99]} id='ElliTile-99' />
        <ElementTile addClasses='bg-pink-500' elementData={elements[100]} id='ElliTile-100' />
        <ElementTile addClasses='bg-pink-500' elementData={elements[101]} id='ElliTile-101' />
        <ElementTile addClasses='bg-pink-500' elementData={elements[102]} id='ElliTile-102' />

      </div>
    </main>
  );
};

export default Projects;