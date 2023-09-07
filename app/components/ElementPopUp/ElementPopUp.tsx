import React, { useEffect } from 'react';
import styles from './ElementPopUp.module.css';
import { ElementData } from '@public/libraryChemistry';

interface PopUpProps {
    onClose: () => void;
    elementData?: ElementData;
    addClasses?: string;
}

const ElementPopUp: React.FC<PopUpProps> = ({ onClose, elementData, addClasses }) => {
    const handleCloseClick = () => {
        onClose();
    };

    useEffect(() => {
        console.log("ElementPopUp mounted"); // Add this line for debugging
        return () => {
            console.log("ElementPopUp unmounted"); // Add this line for debugging
        };
    }, []);

    const overlayClasses = `${styles.overlay} ${addClasses}`;

    return (
        <div className={overlayClasses}>
            <div className={styles.popup}>
                Name: {elementData ? elementData.name : ''}
                Kurz: {elementData ? elementData.kurzsymbol : ''}
                <button onClick={handleCloseClick}>Close</button>
            </div>
        </div>
    );
};

export default ElementPopUp;