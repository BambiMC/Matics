import { ElementData } from '@public/libraryChemistry';
import React, { useState } from 'react';
import ElementPopUp from '../ElementPopUp/ElementPopUp';

interface ElementTileProps {
  elementData?: ElementData;
  addClasses?: string;
}

const ElementTile: React.FC<ElementTileProps> = ({ elementData, addClasses }) => {
  const [isPopupOpen, setIsPopupOpen] = useState(false);

  const handleLeftClick = () => {
    setIsPopupOpen(true);
  };

  const handleClose = () => {
    console.log("Closing popup1");
    setIsPopupOpen(false);
    console.log("Closing popup2");
  };

  return (
    <div
      className={`text-center flex items-center justify-center text-black p-0 md:p-2 xl:p-4 2xl:p-8 ${addClasses}`}
      onContextMenu={(e) => e.preventDefault()}
      onClick={handleLeftClick}
      style={{ cursor: 'pointer' }}
    >
      {elementData ? elementData.kurzsymbol : ''}
      {isPopupOpen && (
        <ElementPopUp onClose={handleClose} elementData={elementData} addClasses="additional-class" />
      )}
    </div>
  );
};

// ... Example component and other code

export default ElementTile;