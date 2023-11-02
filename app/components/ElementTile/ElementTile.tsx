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
      className={`duration-300 text-xs md:text-xl xl:text-2xl text-center flex items-center justify-center text-black p-1 md:p-2 xl:p-4   md:border-black aspect-square hover:font-extrabold hover:outline  ${addClasses}`}
      style={{ cursor: 'pointer' }}
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