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
            {data && elementData && (
                <div className={`text-xs md:text-base 2xl:text-xl font-normal ${styles.popup}`} onClick={handleOverlayClick}>
                    <div className='flex header-row justify-between'>
                        <p className='font-bold text-3xl text-fnbg-orange my-4'>{elementData.name} - {elementData.kurzsymbol}</p>
                        <Button onClick={onClose} addClasses='text-3xl'>&#x2716;</Button>
                    </div>
                    <p className='element-text'>{data['protons']}: {elementData.protonen}</p>
                    <p className='element-text'>{data['neutrons']}: {elementData.neutronen} *</p>
                    <p className='element-text'>{data['category']}: {elementData.oberkategorie}{elementData.unterkategorie ? " - " + elementData.unterkategorie : ''}</p>
                    <p className='element-text'>{data['mainGroup']}: {elementData.hauptgruppe}</p>
                    <p className='element-text'>{data['period']}: {elementData.periode}</p>
                    <p className='element-text'>{data['appearance']}: {elementData.aussehen ? elementData.aussehen : data['unknown']}</p>
                    <p className='element-text'>{data['aggregateState']}: {elementData.aggregatszustand ? elementData.aggregatszustand + ' **' : data['unknown']}</p>
                    <p className='element-text'>{data['structure']}: {elementData.struktur ? elementData.struktur + ' **' : data['unknown']}</p>
                    <p className='element-text'>{data['hardness']}: {elementData.haerte ? elementData.haerte + data['mohs'] : data['unknown']}</p>
                    <div className='flex'>
                        {elementData.volumen ? (
                            <>
                                <p className='element-text'>
                                    {data['volume']}: {elementData.volumen}
                                </p>
                                <MathComponent mathExpression="\frac{\text{m}^3}{\text{mol}}" />
                                <p className='element-text'> **</p>
                            </>
                        ) : (
                            <p className='element-text'>{data['volume']}: {data['unbekannt']}</p>
                        )}
                    </div>

                    <p className='element-text'>{data['radioactive']}: {elementData.radioaktiv ? data['yes'] : data['no']}</p>
                    <p className='element-text'>{data['syntheticallyProduced']}: {elementData.synthetischHergestellt ? data['yes'] : data['no']}</p>
                    <p className='element-text'>{data['commonness']}: {elementData.prozentsatzAnDerErdhuelle ? elementData.prozentsatzAnDerErdhuelle + " %" : data['unknown']}</p>
                    <p className='element-text'>{data['atomicWeight']}: {elementData.atommasse ? elementData.atommasse + " u" : data['unknown']}</p>
                    <p className='element-text'>{data['ionizationEnergy']}: {elementData.ionisierungsenergie ? elementData.ionisierungsenergie + " eV" : data['unknown']}</p>
                    <div className='flex'>
                        {elementData.dichte ? (
                            <>
                                <p className='element-text'>
                                    {data['density']}: {elementData.dichte}
                                </p>
                                <MathComponent mathExpression="\frac{g}{\text{cm}^3}" />
                                <p className='element-text'> **</p>
                            </>
                        ) : (
                            <p className='element-text'>{data['density']}: {data['unknown']}</p>
                        )}
                    </div>
                    <p className='element-text'>{data['meltingPoint']}: {elementData.schmelzpunkt ? elementData.schmelzpunkt + " °C" : data['unknown']}</p>
                    <p className='element-text'>{data['boilingPoint']}: {elementData.siedepunkt ? elementData.siedepunkt + " °C" : data['unknown']}</p>
                    <p className='element-text'>{data['electronegativity']}: {elementData.elektronegativitaet ? elementData.elektronegativitaet + " eV ***" : data['unknown']}</p>
                    <p className='element-text'>{data['flameColor']}: {elementData.flammenfarbe ? elementData.flammenfarbe : data['unknown']}</p>
                    <div className='flex'>
                        <p className='element-text'>{data['wikipediaLink']}:</p>
                        <Link className='ml-2' href={elementData ? elementData.wikipedia : data['unknown']} target="_blank">{elementData ? elementData.wikipedia : data['unknown']}</Link>
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