"use client"

import React from 'react';
import styles from './ElementPopUp.module.css';
import { ElementData } from '@public/libChem/elementData';
import Button from '../../Button/Button';
import Link from 'next/link';
import { useLanguageData } from "@data/languageLoader";
import MathComponent from '@components/MathComponent/MathComponent';

interface PopUpProps {
    onClose: () => void;
    elementData?: ElementData;
}

const ElementPopUp: React.FC<PopUpProps> = ({ onClose, elementData }) => {

    const data = useLanguageData("elementPopUp");

    const handleOverlayClick = (event: React.MouseEvent) => {
        event.stopPropagation();
    };

    return (

        <div className={styles.blurred} onClick={onClose}>
            {data && (
                <div className={`text-xs md:text-base 2xl:text-xl font-normal ${styles.popup}`} onClick={handleOverlayClick}>
                    <div className='flex header-row justify-between'>
                        <p className='font-bold text-3xl text-fnbg-orange my-4'>{elementData ? elementData.name : ''} - {elementData ? elementData.kurzsymbol : ''}</p>
                        <Button onClick={onClose} addClasses='text-3xl'>&#x2716;</Button>
                    </div>
                    <p className='element-text'>{data['protons']}: {elementData ? elementData.protonen : ''}</p>
                    <p className='element-text'>{data['neutrons']}: {elementData ? elementData.neutronen : ''} *</p>
                    <p className='element-text'>{data['category']}: {elementData ? elementData.oberkategorie : ''} - {elementData ? elementData.unterkategorie : ''}</p>
                    <p className='element-text'>{data['mainGroup']}: {elementData ? elementData.hauptgruppe : ''}</p>
                    <p className='element-text'>{data['period']}: {elementData ? elementData.periode : ''}</p>
                    <p className='element-text'>{data['appearance']}: {elementData ? elementData.aussehen : ''}</p>
                    <p className='element-text'>{data['aggregateState']}: {elementData ? elementData.aggregatszustand : ''} **</p>
                    <p className='element-text'>{data['structure']}: {elementData ? elementData.struktur : ''} **</p>
                    <p className='element-text'>{data['hardness']}: {elementData ? elementData.haerte : ''} {data['mohs']}</p>
                    <div className='flex'>
                        <p className='element-text'>{data['volume']}: {elementData ? elementData.volumen : ''}</p>
                        <MathComponent mathExpression="\frac{\text{m}^3}{\text{mol}}" />
                        <p className='element-text'> **</p>
                    </div>
                    <p className='element-text'>{data['radioactive']}: {elementData?.radioaktiv ? data['yes'] : data['no']}</p>
                    <p className='element-text'>{data['syntheticallyProduced']}: {elementData?.synthetischHergestellt ? data['yes'] : data['no']}</p>
                    <p className='element-text'>{data['commonness']}: {elementData ? elementData.prozentsatzAnDerErdhuelle : ''} %</p>
                    <p className='element-text'>{data['atomicWeight']}: {elementData ? elementData.atommasse : ''} u</p>
                    <p className='element-text'>{data['ionizationEnergy']}: {elementData ? elementData.ionisierungsenergie : ''} eV</p>
                    <div className='flex'>
                        <p className='element-text'>{data['density']}: {elementData ? elementData.dichte : ''}</p>
                        <MathComponent mathExpression='\frac{g}{\text{cm}^3}' />
                    </div>
                    <p className='element-text'>{data['meltingPoint']}: {elementData ? elementData.schmelzpunkt : ''} °C</p>
                    <p className='element-text'>{data['boilingPoint']}: {elementData ? elementData.siedepunkt : ''} °C</p>
                    <p className='element-text'>{data['electronegativity']}: {elementData ? elementData.elektronegativitaet : ''} eV ***</p>
                    <p className='element-text'>{data['flameColor']}: {elementData ? elementData.flammenfarbe : ''}</p>
                    <div className='flex'>
                        <p className='element-text'>{data['wikipediaLink']}:</p>
                        <Link className='ml-2' href={elementData ? elementData.wikipedia : ''} target="_blank">{elementData ? elementData.wikipedia : ''}</Link>
                    </div>
                    <p className='element-text pt-4'>{data['explanation1']}</p>
                    <p className='element-text'>{data['explanation2']}</p>
                    <p className='element-text'>{data['explanation3']}</p>

                </div>
            )}
        </div>
    );
};

export default ElementPopUp;