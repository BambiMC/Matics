import { ElementData } from '@public/libraryChemistry';
import React, { useState } from 'react';
import ElementPopUp from '../ElementPopUp/ElementPopUp';

interface ElementTileProps {
  elementData?: ElementData;
  addClasses?: string;
}

const ElementTile: React.FC<ElementTileProps> = ({ elementData, addClasses }) => {
  const [isPopUpVisible, setIsPopUpVisible] = useState(false);

  const togglePopUp = () => {
    setIsPopUpVisible(!isPopUpVisible);
  };

  return (
    <div
      className={`text-xs md:text-xl xl:text-2xl text-center flex items-center justify-center text-black p-1 md:p-2 xl:p-4 2xl:p-8 md:border-2 md:border-black aspect-square hover:font-extrabold hover:outline sm:outline-4 outline-white ${addClasses}`}
      style={{ cursor: 'pointer' }}
      onClick={togglePopUp}
    >
      {elementData ? elementData.kurzsymbol : '↓'}
      {isPopUpVisible && <ElementPopUp onClose={togglePopUp} elementData={elementData} addClasses="" />}

    </div>
  );
};

export default ElementTile;