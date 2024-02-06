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

                    <p className='font-bold mt-2 text-white'>Classification</p>
                    <p className={styles.elementText}>{data['category']}: {elementData.oberkategorie}{elementData.unterkategorie ? " - " + elementData.unterkategorie : ''}</p>
                    <p className={styles.elementText}>{data['mainGroup']}: {elementData.hauptgruppe}</p>
                    <p className={styles.elementText}>{data['period']}: {elementData.periode}</p>



                    <p className='font-bold mt-2 text-white'>Atomic Properties</p>
                    <p className={styles.elementText}>{data['protons']}: {elementData.protonen}</p>
                    <p className={styles.elementText}>{data['neutrons']}: {elementData.neutronen} *</p>



                    <p className='font-bold mt-2 text-white'>Physical Properties</p>
                    <div className='flex'>
                        {elementData.volumen ? (
                            <>
                                <p className={styles.elementText}>
                                    {data['volume']}: {elementData.volumen}
                                </p>
                                <MathComponent mathExpression="\frac{\text{m}^3}{\text{mol}}" />
                                <p className={styles.elementText}> **</p>
                            </>
                        ) : (
                            <p className={styles.elementText}>{data['volume']}: {data['unbekannt']}</p>
                        )}
                    </div>
                    <div className='flex'>
                        {elementData.dichte ? (
                            <>
                                <p className={styles.elementText}>
                                    {data['density']}: {elementData.dichte}
                                </p>
                                <MathComponent mathExpression="\frac{g}{\text{cm}^3}" />
                                <p className={styles.elementText}> **</p>
                            </>
                        ) : (
                            <p className={styles.elementText}>{data['density']}: {data['unknown']}</p>
                        )}
                    </div>
                    <p className={styles.elementText}>{data['structure']}: {elementData.struktur ? elementData.struktur + ' **' : data['unknown']}</p>
                    <p className={styles.elementText}>{data['hardness']}: {elementData.haerte ? elementData.haerte + ' ' + data['mohs'] : data['unknown']}</p>
                    <p className={styles.elementText}>{data['appearance']}: {elementData.aussehen ? elementData.aussehen : data['unknown']}</p>
                    <p className={styles.elementText}>{data['aggregateState']}: {elementData.aggregatszustand ? elementData.aggregatszustand + ' **' : data['unknown']}</p>
                    <p className={styles.elementText}>{data['meltingPoint']}: {elementData.schmelzpunkt ? elementData.schmelzpunkt + " °C" : data['unknown']}</p>
                    <p className={styles.elementText}>{data['boilingPoint']}: {elementData.siedepunkt ? elementData.siedepunkt + " °C" : data['unknown']}</p>


                    <p className='font-bold mt-2 text-white'>Chemical Properties</p>


                    <p className={styles.elementText}>{data['radioactive']}: {elementData.radioaktiv ? data['yes'] : data['no']}</p>
                    <p className={styles.elementText}>{data['syntheticallyProduced']}: {elementData.synthetischHergestellt ? data['yes'] : data['no']}</p>
                    <p className={styles.elementText}>{data['commonness']}: {elementData.prozentsatzAnDerErdhuelle ? elementData.prozentsatzAnDerErdhuelle + " %" : data['unknown']}</p>
                    <p className={styles.elementText}>{data['atomicWeight']}: {elementData.atommasse ? elementData.atommasse + " u" : data['unknown']}</p>
                    <p className={styles.elementText}>{data['ionizationEnergy']}: {elementData.ionisierungsenergie ? elementData.ionisierungsenergie + " eV" : data['unknown']}</p>
                    <p className={styles.elementText}>{data['electronegativity']}: {elementData.elektronegativitaet ? elementData.elektronegativitaet + " ***" : data['unknown']}</p>


                    <p className='font-bold mt-2 text-white'>Miscellaneous</p>


                    <p className={styles.elementText}>{data['flameColor']}: {elementData.flammenfarbe ? elementData.flammenfarbe : data['unknown']}</p>
                    <div className='flex'>
                        <p className={styles.elementText}>{data['wikipediaLink']}:</p>
                        <Link className='ml-2' href={elementData ? elementData.wikipedia : data['unknown']} target="_blank">{elementData ? elementData.wikipedia : data['unknown']}</Link>
                    </div>


                    <p className='element-text pt-4'>{data['explanation1']}</p>
                    <p className={styles.elementText}>{data['explanation2']}</p>
                    <p className={styles.elementText}>{data['explanation3']}</p>
                </div>
            )}


        </div>
    );
};

export default ElementPopUp;