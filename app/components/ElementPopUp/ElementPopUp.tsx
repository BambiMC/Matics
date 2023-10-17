import React, { useEffect } from 'react';
import styles from './ElementPopUp.module.css';
import { ElementData } from '@public/libraryChemistry';
import Button from '../Button/Button';

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
            <div className={`text-xs md:text-base 2xl:text-xl font-normal ${styles.popup}`}>
                <div className='flex header-row justify-between'>
                    <p className='element-text font-bold'>{elementData ? elementData.name : ''}</p>
                    <Button onClick={handleCloseClick}>Text</Button>
                </div>
                <p className='element-text'>Kurzsymbol: {elementData ? elementData.kurzsymbol : ''}</p>
                <p className='element-text'>Protonen: {elementData ? elementData.protonen : ''}</p>
                <p className='element-text'>Neutronen: {elementData ? elementData.neutronen : ''} *</p>
                <p className='element-text'>Oberkategorie: {elementData ? elementData.oberkategorie : ''}</p>
                <p className='element-text'>Unterkategorie: {elementData ? elementData.unterkategorie : ''}</p>
                <p className='element-text'>Hauptgruppe: {elementData ? elementData.hauptgruppe : ''}</p>
                <p className='element-text'>Periode: {elementData ? elementData.periode : ''}</p>
                <p className='element-text'>Aussehen: {elementData ? elementData.aussehen : ''}</p>
                <p className='element-text'>Aggregatszustand: {elementData ? elementData.aggregatszustand : ''} **</p>
                <p className='element-text'>Struktur: {elementData ? elementData.struktur : ''} **</p>
                <p className='element-text'>Härte: {elementData ? elementData.haerte : ''} Mohs</p>
                <p className='element-text'>Volumen: {elementData ? elementData.volumen : ''} m³/mol **</p>
                <p className='element-text'>Radioaktiv: {elementData ? elementData.radioaktiv : ''}</p>
                <p className='element-text'>Nur synthetisch herstellbar: {elementData ? elementData.synthetischHergestellt : ''}</p>
                <p className='element-text'>Prozentsatz an der Erdhülle: {elementData ? elementData.prozentsatzAnDerErdhuelle : ''} %</p>
                <p className='element-text'>Atommasse: {elementData ? elementData.atommasse : ''} u</p>
                <p className='element-text'>Ionisierungsenergie: {elementData ? elementData.ionisierungsenergie : ''} eV</p>
                <p className='element-text'>Dichte: {elementData ? elementData.dichte : ''} g/cm³</p>
                <p className='element-text'>Schmelzpunkt: {elementData ? elementData.schmelzpunkt : ''} °C</p>
                <p className='element-text'>Siedepunkt: {elementData ? elementData.siedepunkt : ''} °C</p>
                <p className='element-text'>Elektronegativität: {elementData ? elementData.elektronegativität : ''} ***</p>
                <p className='element-text'>Flammenfarbe: {elementData ? elementData.flammenfarbe : ''}</p>
                <p className='element-text'>Wikipedia: {elementData ? elementData.wikipedia : ''}</p>
                <p className='element-text'>*=Berechnet nach = Masse(gerundet) - Ordnungszahl</p>
                <p className='element-text'>**=Unter Normalbedingungen 20 Grad Celsius</p>
                <p className='element-text'>***=Nach der Pauling-Skala, notfalls nach Allred-Rochow</p>



            </div>
        </div>
    );
};

export default ElementPopUp;