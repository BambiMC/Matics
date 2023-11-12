import { ElementData } from '@public/libraryChemistry';
import React, { useState } from 'react';
import ElementPopUp from '../ElementPopUp/ElementPopUp';

interface ElementTileProps {
  elementData?: ElementData;
  addClasses?: string;
  placeholder?: boolean;
  id?: string;
}

const ElementTile: React.FC<ElementTileProps> = ({ elementData, addClasses, placeholder = false, id }) => {
  const [isPopUpVisible, setIsPopUpVisible] = useState(false);

  const togglePopUp = () => {
    setIsPopUpVisible(!isPopUpVisible);
  };

  if (placeholder) {
    id = 'PlaceholderTile';
  }


  return (
    <div
      className={`flex aspect-square cursor-pointer text-center items-center justify-center duration-300 text-xs md:text-xl xl:text-2xl text-black p-1 md:p-2 xl:p-4 border-[#404040] sm:border-2 hover:border-4 hover:z-10 hover:border-black p-auto ${addClasses}`}
      id={id}
      onClick={() => {
        if (elementData) {
          togglePopUp();
        }
      }}
    >
      <p>
        {elementData ? elementData.kurzsymbol : '↓'}
      </p>

      {isPopUpVisible && (
        <ElementPopUp onClose={togglePopUp} elementData={elementData} />
      )}
    </div>
  );
};

export default ElementTile;