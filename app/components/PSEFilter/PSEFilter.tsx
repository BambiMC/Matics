import { ElementData } from '@public/libraryChemistry';
import React, { useState } from 'react';
import ToggleOperator from './ToggleOperator';
import Button from '../Button/Button';
import Dropdown from '../Dropdown/Dropdown';
import PSEActiveFilter from './PSEActiveFilter';

type PSEFilterProps = {
    elements: ElementData[];
};

interface DropdownOption {
    label: string;
    value: number;
}
interface OperatorTable {
    [key: string]: (a: number, b: number) => boolean;
}

const operatorTable: OperatorTable = {
    '>': (a, b) => a > b,
    '>=': (a, b) => a >= b,
    '<': (a, b) => a < b,
    '<=': (a, b) => a <= b,
    '=': (a, b) => a === b,
    '!=': (a, b) => a !== b,
};

const options: DropdownOption[] = [
    { label: 'Name', value: 1 },
    { label: 'Kürzel', value: 2 },
    { label: 'Kategorie', value: 3 },
    { label: 'Aussehen', value: 4 },
    { label: 'Aggregatszustand', value: 5 },
    { label: 'Struktur', value: 6 },

    { label: 'Protonen', value: 7 },
    { label: 'Neutronen', value: 8 },
    { label: 'Härte', value: 9 },
    { label: 'Volumen', value: 10 },
    { label: 'Häufigkeit', value: 11 },
    { label: 'Atomares Gewicht', value: 12 },
    { label: 'Ionisierungsenergie', value: 13 },
    { label: 'Dichte', value: 14 },
    { label: 'Schmelzpunkt', value: 15 },
    { label: 'Siedepunkt', value: 16 },
    { label: 'Elektronegativität', value: 17 },
    { label: 'Flammenfarbe', value: 18 },
];

const PSEFilter: React.FC<PSEFilterProps> = ({ elements }) => {
    const [isDropdownOpen, setIsDropdownOpen] = useState(false);
    const [isFilterActive, setIsFilterActive] = useState(true);

    function getElementDataValue(elementData: ElementData, idNumber: number): string | number {
        switch (idNumber) {
            case 1:
                return elementData.name;
            case 2:
                return elementData.kurzsymbol;
            case 3:
                return elementData.unterkategorie, ', ' + elementData.oberkategorie;
            case 4:
                return elementData.aussehen;
            case 5:
                return elementData.aggregatszustand;
            case 6:
                return elementData.struktur;
            case 7:
                return elementData.protonen;
            case 8:
                return elementData.neutronen;
            case 9:
                return elementData.haerte;
            case 10:
                return elementData.volumen;
            case 11:
                return elementData.prozentsatzAnDerErdhuelle;
            case 12:
                return elementData.atommasse;
            case 13:
                return elementData.ionisierungsenergie;
            case 14:
                return elementData.dichte;
            case 15:
                return elementData.schmelzpunkt;
            case 16:
                return elementData.siedepunkt;
            case 17:
                return elementData.elektronegativität;
            case 18:
                return elementData.flammenfarbe;
            default:
                return 'Error in getElementDataValue';
        }
    };

    const toggleDropdown = () => {
        setIsDropdownOpen(!isDropdownOpen);
    };

    const [selectedAttribute, setselectedAttribute] = useState<DropdownOption | null>(null);

    const handleSelect = (option: DropdownOption) => {
        console.log('Selected option:', option);
        setselectedAttribute(option);
    };

    const toggleFilter = (idNumber: number) => {
        setIsFilterActive(!isFilterActive);
        handleFilter(idNumber);
    };

    const handleFilter = (idNumber: number) => {
        const elementTiles = document.querySelectorAll('#ElementTile');
        var filterValue: string | number = 0;
        if (isFilterActive) {
            console.log('Filter is active');
            const toggleOperator: string = (document.getElementById('filter-toggle') as HTMLInputElement).innerText;

            elementTiles.forEach(function (elementTile, i) {
                const elementDataValue: number | string = getElementDataValue(elements[i], idNumber);
                if (typeof elementDataValue === 'number') {
                    const filterValue: number = Number((document.getElementById('filter-input') as HTMLInputElement).value);

                    if (!operatorTable[toggleOperator](elementDataValue, filterValue)) {
                        (elementTile as HTMLElement).style.filter = 'blur(6px)';
                    }
                } else if (typeof elementDataValue === 'string') {
                    filterValue = (document.getElementById('filter-input') as HTMLInputElement).value;


                    if (toggleOperator === '~') {
                        if (!elementDataValue.includes(filterValue.toString())) {
                            (elementTile as HTMLElement).style.filter = 'blur(6px)';
                        }
                    } else if (toggleOperator === '!=') {
                        if (elementDataValue === filterValue.toString()) {
                            (elementTile as HTMLElement).style.filter = 'blur(6px)';
                        }
                    } else {
                        console.log('cant find this toggle: ' + toggleOperator);
                    }
                }

            });

            // var newActiveFilterElement = document.createElement('button');
            // newActiveFilterElement.id = 'active-filter';
            // // newActiveFilterElement.addEventListener('click', function () {
            // //     () => toggleFilter(selectedAttribute!.value)
            // // });
            // newActiveFilterElement.onclick = function () { () => toggleFilter(selectedAttribute!.value) };
            // var textNode = document.createTextNode('TEST');
            // newActiveFilterElement.appendChild(textNode);

            // document.getElementById('selectedFilters')!.appendChild(newActiveFilterElement);
            document.getElementById('execute-button')!.textContent = '✗';


        } else {
            console.log('Filter is inactive');
            const toggleOperator: string = (document.getElementById('filter-toggle') as HTMLInputElement).innerText;

            elementTiles.forEach(function (elementTile, i) {
                const elementDataValue: number | string = getElementDataValue(elements[i], idNumber);
                if (typeof elementDataValue === 'number') {
                    const filterValue: number = Number((document.getElementById('filter-input') as HTMLInputElement).value);

                    if (!operatorTable[toggleOperator](elementDataValue, filterValue)) {
                        (elementTile as HTMLElement).style.filter = '';
                    }
                } else if (typeof elementDataValue === 'string') {
                    filterValue = (document.getElementById('filter-input') as HTMLInputElement).value;


                    if (toggleOperator === '~') {
                        if (!elementDataValue.includes(filterValue.toString())) {
                            (elementTile as HTMLElement).style.filter = '';
                        }
                    } else if (toggleOperator === '!=') {
                        if (elementDataValue === filterValue.toString()) {
                            (elementTile as HTMLElement).style.filter = '';
                        }
                    } else {
                        console.log('cant find this toggle: ' + toggleOperator);
                    }
                }

            });

            // document.getElementById('active-filter')!.remove();
            document.getElementById('execute-button')!.textContent = '✓';


        }
    };

    return (
        <div className='flex bg-fnbg-accent my-4'>
            <div id='selectedFilters' className='bg-blue-900'>
            </div>
            <div className='mr-8 bg-fnbg-body ml-auto my-2'>
                <div className="dropdown border-2 flex">
                    <Button onClick={toggleDropdown} addClasses="dropbtn ml-auto pl-auto">Elemente filtern</Button>
                    {isDropdownOpen && (
                        <div className="dropdown-content">
                            <div className='flex'>
                                <Dropdown options={options} onSelect={handleSelect} />
                                <ToggleOperator id='filter-toggle' />
                                <input type="text" className='w-24' id='filter-input' />
                                <Button onClick={() => toggleFilter(selectedAttribute!.value)} id='execute-button' addClasses='p-2'>✓</Button>
                            </div>
                        </div>
                    )}
                </div>
            </div>
        </div>
    );
};

export default PSEFilter;
