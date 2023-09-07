"use client"
import React, { useState } from 'react';
import ElementPopUp from '@components/ElementPopUp/ElementPopUp';

const Home: React.FC = () => {
  const [isPopUpVisible, setIsPopUpVisible] = useState(false);

  const togglePopUp = () => {
    setIsPopUpVisible(!isPopUpVisible);
  };

  return (
    <div>
      <header >Navbar</header>
      <main className='m-32'>
        {/* Your main content goes here */}
        <button onClick={togglePopUp}>Show Popup</button>
      </main>
      <footer >Footer</footer>
      {isPopUpVisible && <ElementPopUp onClose={togglePopUp} />}
    </div>
  );
};

export default Home;