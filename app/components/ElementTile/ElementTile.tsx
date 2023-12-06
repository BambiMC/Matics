import React, { useState } from 'react';
import { ElementData } from '@public/libraryChemistry';
import ElementPopUp from '../ElementPopUp/ElementPopUp';

interface ElementTileProps {
  elementData?: ElementData;
  addClasses?: string;
  placeholder?: boolean;
  id?: string;
}

const ElementTile: React.FC<ElementTileProps> = ({
  elementData,
  addClasses = '',
  placeholder = false,
  id: propId,
}) => {
  const [isPopUpVisible, setIsPopUpVisible] = useState(false);
  const id = placeholder ? 'PlaceholderTile' : propId;
  const placeholderAttribute = placeholder ? { placeholder: 'true' } : {};

  const togglePopUp = () => {
    setIsPopUpVisible(!isPopUpVisible);
  };

  const handleClick = () => {
    if (elementData) {
      togglePopUp();
    } else if (placeholder) {
      console.log('clicked');
      // Jump to the bottom of the page
      window.scrollTo(0, document.body.scrollHeight);
    }
  };

  return (
    <div
      {...placeholderAttribute}
      className={`flex aspect-square cursor-pointer text-center items-center justify-center duration-300 text-xs md:text-xl xl:text-2xl text-black p-0 lg:p-2 xl:p-4 border-[#404040] border-1 sm:border-2 lg:border-4 hover:z-10 hover:border-black ${addClasses}`}
      id={id}
      onClick={handleClick}
    >
      <p>{elementData ? elementData.kurzsymbol : '↓'}</p>

      {isPopUpVisible && <ElementPopUp onClose={togglePopUp} elementData={elementData} />}
    </div>
  );
};

export default ElementTile;
