import { ElementData } from '@public/libraryChemistry';
import React, { useState } from 'react';
import ElementPopUp from '../ElementPopUp/ElementPopUp';

interface ElementTileProps {
  elementData?: ElementData;
  className?: string;
}

const ElementTile: React.FC<ElementTileProps> = ({ elementData, className }) => {
  const [isPopUpVisible, setIsPopUpVisible] = useState(false);

  const togglePopUp = () => {
    setIsPopUpVisible(!isPopUpVisible);
  };

  return (
    <div
      className={`flex aspect-square cursor-pointer text-center items-center justify-center duration-300 text-xs md:text-xl xl:text-2xl text-black p-1 md:p-2 xl:p-4 border-[#404040] sm:border-2 hover:border-4 hover:z-10 hover:border-black p-auto ${className}`}
      onClick={() => {
        if (elementData) {
          togglePopUp();
        }
      }}
    >
      {elementData ? elementData.kurzsymbol : '↓'}

      {isPopUpVisible && (
        <ElementPopUp onClose={togglePopUp} elementData={elementData} />
      )}
    </div>
  );
};

export default ElementTile;