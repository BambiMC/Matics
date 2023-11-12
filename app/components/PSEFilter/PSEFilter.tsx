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
    type: string;
}

type SearchType = {
    attribute: string;
    toggleOperator: string;
    filterValue: string;
};

class Search {
    attribute!: string;
    toggleOperator!: string;
    filterValue!: string;
    constructor(attribute: string, toggleOperator: string, filterValue: string) {
        this.attribute = attribute;
        this.toggleOperator = toggleOperator;
        this.filterValue = filterValue;
    }
}

interface OperatorTableNumber {
    [key: string]: (a: number, b: number) => boolean;
}
interface OperatorTableString {
    [key: string]: (a: string, b: string) => boolean;
}

const operatorTableNumber: OperatorTableNumber = {
    '>': (a, b) => a > b,
    '>=': (a, b) => a >= b,
    '<': (a, b) => a < b,
    '<=': (a, b) => a <= b,
    '=': (a, b) => a === b,
    '!=': (a, b) => a !== b,
};

const operatorTableString: OperatorTableString = {
    '=': (a, b) => a.trim().toLowerCase().includes(b.trim().toLowerCase()),
    '!=': (a, b) => !a.trim().toLowerCase().includes(b.trim().toLowerCase()),
};

// const operatorTableString: OperatorTableString = {
//     '=': (a, b) => {
//         const c = a.trim().toLowerCase();
//         const d = b.trim().toLowerCase();
//         console.log("c: " + c + " d: " + d + ", bool: " + c.includes(d));
//         return c.includes(d);
//     },
//     '!=': (a, b) => {
//         const c = a.trim().toLowerCase();
//         const d = b.trim().toLowerCase();
//         console.log("c: " + c + " d: " + d + ", bool: " + c.includes(d));
//         return !c.includes(d);
//     }
// };

const options: DropdownOption[] = [
    { label: 'Name', value: 0, type: 'string' },
    { label: 'Kürzel', value: 1, type: 'string' },
    { label: 'Kategorie', value: 2, type: 'string' },
    { label: 'Aussehen', value: 3, type: 'string' },
    { label: 'Aggregatszustand', value: 4, type: 'string' },
    { label: 'Struktur', value: 5, type: 'string' },

    { label: 'Protonen', value: 6, type: 'number' },
    { label: 'Neutronen', value: 7, type: 'number' },
    { label: 'Härte', value: 8, type: 'number' },
    { label: 'Volumen', value: 9, type: 'number' },
    { label: 'Häufigkeit', value: 10, type: 'number' },
    { label: 'Atomares Gewicht', value: 11, type: 'number' },
    { label: 'Ionisierungsenergie', value: 12, type: 'number' },
    { label: 'Dichte', value: 13, type: 'number' },
    { label: 'Schmelzpunkt', value: 14, type: 'number' },
    { label: 'Siedepunkt', value: 15, type: 'number' },
    { label: 'Elektronegativität', value: 16, type: 'number' },

    { label: 'Flammenfarbe', value: 17, type: 'string' },
];

const PSEFilter: React.FC<PSEFilterProps> = ({ elements }) => {
    const [isDropdownOpen, setIsDropdownOpen] = useState(false);

    function getElementDataValue(elementData: ElementData, idNumber: number): string | number {
        switch (idNumber) {
            case 0:
                return elementData.name;
            case 1:
                return elementData.kurzsymbol;
            case 2:
                return elementData.unterkategorie, ', ' + elementData.oberkategorie;
            case 3:
                return elementData.aussehen;
            case 4:
                return elementData.aggregatszustand;
            case 5:
                return elementData.struktur;
            case 6:
                return elementData.flammenfarbe;
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
            default:
                return 'Error in getElementDataValue';
        }
    };

    const toggleDropdown = () => {
        setIsDropdownOpen(!isDropdownOpen);
    };

    const [selectedAttribute, setselectedAttribute] = useState<DropdownOption | null>(options[0]);

    const handleDropdownSelect = (option: DropdownOption) => {
        setselectedAttribute(option);
        document.dispatchEvent(new CustomEvent('changedAttribute', {
            detail: option
        }));
    };

    const applyFilter = (search: Search) => {
        console.log('applyFilter to: ' + search.attribute + ' ' + search.toggleOperator + ' ' + search.filterValue);

        const elementTiles = document.querySelectorAll('[id^="Elltile-"]');
        for (let index = 0; index < 118; index++) {
            const element = array[index];
            //HERE COONTINUE WORK WITH NEW IDS

        }

        elementTiles.forEach(function (elementTile, i) {
            const elementDataValue: number | string = getElementDataValue(elements[i], (selectedAttribute!.value));

            if (typeof elementDataValue === 'number') {
                if (!operatorTableNumber[search.toggleOperator](elementDataValue, Number(search.filterValue))) {
                    (elementTile as HTMLElement).style.filter = 'blur(6px)';
                }
            } else if (typeof elementDataValue === 'string') {
                if (!operatorTableString[search.toggleOperator](elementDataValue, search.filterValue)) {
                    console.log('elementDataValue: ' + elementDataValue);
                    (elementTile as HTMLElement).style.filter = 'blur(6px)';
                }
            }
        });

        const emptyFilter = document.querySelector("#selectedFilters [id^=filter-]:not([attribute])") as HTMLElement;
        if (emptyFilter) {
            emptyFilter.setAttribute('attribute', search.attribute);
            emptyFilter.setAttribute('toggleOperator', search.toggleOperator);
            emptyFilter.setAttribute('filterValue', search.filterValue);

            document.dispatchEvent(new CustomEvent('addedFilter', { detail: emptyFilter.id }));
        } else {
            alert('Maximale Anzahl an Filtern erreicht - Seite muss neugeladen werden.')
        }
    };

    const removeFilter = (filterIdToBeDeactivated: string) => {
        console.log('removeFilter');

        const filterToBeDeactivated = document.getElementById(filterIdToBeDeactivated) as HTMLElement;
        filterToBeDeactivated.removeAttribute('attribute');
        filterToBeDeactivated.removeAttribute('toggleOperator');
        filterToBeDeactivated.removeAttribute('filterValue');
        filterToBeDeactivated.innerText = '';

        const elementTiles = document.querySelectorAll('#ElementTile:not([placeholder])');
        elementTiles.forEach(function (elementTile) {
            (elementTile as HTMLElement).style.filter = '';
        });

        const activeFilter = document.querySelectorAll("#selectedFilters [id^=filter-][attribute]") as NodeListOf<HTMLElement>;
        activeFilter.forEach(function (activeFilter) {
            var attribute = activeFilter.getAttribute('attribute');
            var toggleOperator = activeFilter.getAttribute('toggleOperator');
            var filterValue = activeFilter.getAttribute('filterValue');

            activeFilter.removeAttribute('attribute');
            activeFilter.removeAttribute('toggleOperator');
            activeFilter.removeAttribute('filterValue');
            activeFilter.innerText = '';

            applyFilter(new Search(attribute!, toggleOperator!, filterValue!));
        });
    };

    return (
        <div className='flex bg-fnbg-accent my-4'>
            <div id='selectedFilters' className='flex'>
                <PSEActiveFilter id='filter-1' onClick={() => removeFilter('filter-1')} />
                <PSEActiveFilter id='filter-2' onClick={() => removeFilter('filter-2')} />
                <PSEActiveFilter id='filter-3' onClick={() => removeFilter('filter-3')} />
            </div>
            <div className='mr-8 bg-fnbg-body ml-auto my-2'>
                <div className="dropdown border-2 flex">
                    <Button onClick={toggleDropdown} addClasses="dropbtn ml-auto pl-auto">Elemente filtern</Button>
                    {isDropdownOpen && (
                        <div className="dropdown-content">
                            <div className='flex'>
                                <Dropdown options={options} onSelect={handleDropdownSelect} />
                                <ToggleOperator id='filter-toggle' currentType={selectedAttribute!.type} />
                                <input type="text" className='w-24' id='filter-input' />
                                <Button onClick={() => applyFilter(new Search(options[selectedAttribute!.value].label, (document.getElementById('filter-toggle') as HTMLInputElement).innerText, (document.getElementById('filter-input') as HTMLInputElement).value))} id='execute-button' addClasses='p-2'>✓</Button>
                            </div>
                        </div>
                    )}
                </div>
            </div>
        </div>
    );
};
export default PSEFilter;