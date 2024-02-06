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
                        <p className='font-bold text-3xl text-fnbg-orange mt-4 mb-2'>{elementData.name} - {elementData.kurzsymbol}</p>
                        <Button onClick={onClose} addClasses='text-3xl'>&#x2716;</Button>
                    </div>
                    <p className="pl-2 text-sm">{data['category']}: {elementData.oberkategorie}{elementData.unterkategorie ? " - " + elementData.unterkategorie : ''}</p>
                    <p className="pl-2 text-sm">{data['mainGroup']}: {elementData.hauptgruppe}</p>
                    <p className="pl-2 text-sm">{data['period']}: {elementData.periode}</p>
                    <p className="pl-2 text-sm">{data['protons']}: {elementData.protonen}</p>
                    <p className="pl-2 text-sm">{data['neutrons']}: {elementData.neutronen} *</p>



                    <p className='font-bold mt-2 text-fnbg-text2 text-lg'>{data['physicalProperties']}</p>
                    <div className='flex'>
                        {elementData.volumen ? (
                            <>
                                <p className="pl-2 text-sm my-auto">
                                    {data['volume']}: {elementData.volumen}
                                </p>
                                <MathComponent mathExpression="\frac{\text{m}^3}{\text{mol}}" />
                                <p className="pl-2 text-sm">**</p>
                            </>
                        ) : (
                            <p className="pl-2 text-sm">{data['volume']}: {data['unbekannt']}</p>
                        )}
                    </div>
                    <div className='flex'>
                        {elementData.dichte ? (
                            <>
                                <p className="pl-2 text-sm my-auto">
                                    {data['density']}: {elementData.dichte}
                                </p>
                                <MathComponent mathExpression="\frac{g}{\text{cm}^3}" />
                                <p className="pl-2 text-sm">**</p>
                            </>
                        ) : (
                            <p className="pl-2 text-sm">{data['density']}: {data['unknown']}</p>
                        )}
                    </div>
                    <p className="pl-2 text-sm">{data['structure']}: {elementData.struktur ? elementData.struktur + ' **' : data['unknown']}</p>
                    <p className="pl-2 text-sm">{data['hardness']}: {elementData.haerte ? elementData.haerte + ' ' + data['mohs'] : data['unknown']}</p>
                    <p className="pl-2 text-sm">{data['appearance']}: {elementData.aussehen ? elementData.aussehen : data['unknown']}</p>
                    <p className="pl-2 text-sm">{data['aggregateState']}: {elementData.aggregatszustand ? elementData.aggregatszustand + ' **' : data['unknown']}</p>
                    <p className="pl-2 text-sm">{data['meltingPoint']}: {elementData.schmelzpunkt ? elementData.schmelzpunkt + " °C" : data['unknown']}</p>
                    <p className="pl-2 text-sm">{data['boilingPoint']}: {elementData.siedepunkt ? elementData.siedepunkt + " °C" : data['unknown']}</p>


                    <p className='font-bold mt-2 text-fnbg-text2 text-lg'>{data['chemicalProperties']}</p>


                    <p className="pl-2 text-sm">{data['radioactive']}: {elementData.radioaktiv ? data['yes'] : data['no']}</p>
                    <p className="pl-2 text-sm">{data['syntheticallyProduced']}: {elementData.synthetischHergestellt ? data['yes'] : data['no']}</p>
                    <p className="pl-2 text-sm">{data['commonness']}: {elementData.prozentsatzAnDerErdhuelle ? elementData.prozentsatzAnDerErdhuelle + " %" : data['unknown']}</p>
                    <p className="pl-2 text-sm">{data['atomicWeight']}: {elementData.atommasse ? elementData.atommasse + " u" : data['unknown']}</p>
                    <p className="pl-2 text-sm">{data['ionizationEnergy']}: {elementData.ionisierungsenergie ? elementData.ionisierungsenergie + " eV" : data['unknown']}</p>
                    <p className="pl-2 text-sm">{data['electronegativity']}: {elementData.elektronegativitaet ? elementData.elektronegativitaet + " ***" : data['unknown']}</p>


                    <p className='font-bold mt-2 text-fnbg-text2 text-lg'>{data['miscellaneous']}</p>


                    <p className="pl-2 text-sm">{data['flameColor']}: {elementData.flammenfarbe ? elementData.flammenfarbe : data['unknown']}</p>
                    <div className='flex'>
                        <p className="pl-2 text-sm my-auto">{data['wikipediaLink']}:</p>
                        <Link className='ml-2' href={elementData ? elementData.wikipedia : data['unknown']} target="_blank">{elementData ? elementData.wikipedia : data['unknown']}</Link>
                    </div>


                    <p className='pt-4 text-sm'>{data['explanation1']}</p>
                    <p className="text-sm">{data['explanation2']}</p>
                    <p className="text-sm">{data['explanation3']}</p>
                </div>
            )}


        </div>
    );
};

export default ElementPopUp;