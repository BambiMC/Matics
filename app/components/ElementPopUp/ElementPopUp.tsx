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
            <div className={`text-xs md:text-base 2xl:text-2xl ${styles.popup}`}>
                <p className='element-text'>Name: {elementData ? elementData.name : ''}</p>
                <p className='element-text'>Kurz: {elementData ? elementData.kurzsymbol : ''}</p>
                <p className='element-text'>Protonen: {elementData ? elementData.protonen : ''}</p>
                <p className='element-text'>Neutronen: {elementData ? elementData.neutronen : ''}</p>
                <p className='element-text'>Oberkategorie: {elementData ? elementData.oberkategorie : ''}</p>
                <p className='element-text'>Unterkategorie: {elementData ? elementData.unterkategorie : ''}</p>
                <p className='element-text'>Hauptgruppe: {elementData ? elementData.hauptgruppe : ''}</p>
                <p className='element-text'>Periode: {elementData ? elementData.periode : ''}</p>
                <p className='element-text'>Aussehen: {elementData ? elementData.aussehen : ''}</p>
                <p className='element-text'>Aggregatszustand: {elementData ? elementData.aggregatszustand : ''}</p>
                <p className='element-text'>Struktur: {elementData ? elementData.struktur : ''}</p>
                <p className='element-text'>Härte: {elementData ? elementData.haerte : ''}</p>
                <p className='element-text'>Volumen: {elementData ? elementData.volumen : ''}</p>
                <p className='element-text'>Radioaktiv: {elementData ? elementData.radioaktiv : ''}</p>
                <p className='element-text'>Synthetisch hergestellt: {elementData ? elementData.synthetischHergestellt : ''}</p>
                <p className='element-text'>Prozentsatz an der Erdhülle: {elementData ? elementData.prozentsatzAnDerErdhuelle : ''}</p>
                <p className='element-text'>Atommasse: {elementData ? elementData.atommasse : ''}</p>
                <p className='element-text'>Ionisierungsenergie: {elementData ? elementData.ionisierungsenergie : ''}</p>
                <p className='element-text'>Dichte: {elementData ? elementData.dichte : ''}</p>
                <p className='element-text'>Schmelzpunkt: {elementData ? elementData.schmelzpunkt : ''}</p>
                <p className='element-text'>Siedepunkt: {elementData ? elementData.siedepunkt : ''}</p>
                <p className='element-text'>Elektronegativität: {elementData ? elementData.elektronegativität : ''}</p>
                <p className='element-text'>Flammenfarbe: {elementData ? elementData.flammenfarbe : ''}</p>
                <p className='element-text'>Wikipedia: {elementData ? elementData.wikipedia : ''}</p>

                <button onClick={handleCloseClick}>Close</button>
            </div>
        </div>
    );
};

export default ElementPopUp;