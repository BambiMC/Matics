import { ElementData } from '@public/libraryChemistry';
import React, { useEffect, useState } from 'react';
import Button from '../Button/Button';
import Dropdown from '../Dropdown/Dropdown';
import PSEActiveFilter from './PSEActiveFilter';
import ToggleOperator from './ToggleOperator';

type PSEFilterProps = {
    elements: ElementData[];
};

interface DropdownOption {
    key: keyof ElementData;
    label: string;
    value: number;
    type: string;
}

class Search {
    searchCategory!: DropdownOption;
    operator!: string;
    searchValue!: string;
    constructor(searchCategory: DropdownOption, operator: string, searchValue: string) {
        this.searchCategory = searchCategory;
        this.operator = operator;
        this.searchValue = searchValue;
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
    '≠': (a, b) => a !== b,
};

const operatorTableString: OperatorTableString = {
    '=': (a, b) => a.trim().toLowerCase().includes(b.trim().toLowerCase()),
    '≠': (a, b) => !a.trim().toLowerCase().includes(b.trim().toLowerCase()),
};

const options: DropdownOption[] = [
    { key: 'name', label: 'Name', value: 0, type: 'string' },
    { key: 'kurzsymbol', label: 'Kürzel', value: 1, type: 'string' },
    { key: 'unterkategorie', label: 'Kategorie', value: 2, type: 'string' },
    { key: 'aussehen', label: 'Aussehen', value: 3, type: 'string' },
    { key: 'aggregatszustand', label: 'Aggregatszustand', value: 4, type: 'string' },
    { key: 'struktur', label: 'Struktur', value: 5, type: 'string' },
    { key: 'protonen', label: 'Protonen', value: 6, type: 'number' },
    { key: 'neutronen', label: 'Neutronen', value: 7, type: 'number' },
    { key: 'haerte', label: 'Härte', value: 8, type: 'number' },
    { key: 'volumen', label: 'Volumen', value: 9, type: 'number' },
    { key: 'prozentsatzAnDerErdhuelle', label: 'Häufigkeit', value: 10, type: 'number' },
    { key: 'atommasse', label: 'Atomares Gewicht', value: 11, type: 'number' },
    { key: 'ionisierungsenergie', label: 'Ionisierungsenergie', value: 12, type: 'number' },
    { key: 'dichte', label: 'Dichte', value: 13, type: 'number' },
    { key: 'schmelzpunkt', label: 'Schmelzpunkt', value: 14, type: 'number' },
    { key: 'siedepunkt', label: 'Siedepunkt', value: 15, type: 'number' },
    { key: 'elektronegativität', label: 'Elektronegativität', value: 16, type: 'number' },
    { key: 'flammenfarbe', label: 'Flammenfarbe', value: 17, type: 'string' },
];

function getDropdownOptionByLabel(label: string): DropdownOption {
    return options.find((option) => option.label === label)!;
}

const PSEFilter: React.FC<PSEFilterProps> = ({ elements }) => {
    const [isDropdownOpen, setIsDropdownOpen] = useState(false);

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
        if (search.searchValue === '') {
            return;
        }
        console.log('applyFilter to: ' + search.searchCategory + ' ' + search.operator + ' ' + search.searchValue);

        for (let i = 0; i < 118; i++) {
            if (search.searchCategory.type === 'number') {
                if (!operatorTableNumber[search.operator](Number(elements[i][search.searchCategory.key]), Number(search.searchValue))) {
                    document.getElementById('ElliTile-' + i)!.style.filter = 'blur(6px)';
                }
            } else if (search.searchCategory.type === 'string') {
                if (!operatorTableString[search.operator](elements[i][search.searchCategory.key].toString(), search.searchValue)) {
                    document.getElementById('ElliTile-' + i)!.style.filter = 'blur(6px)';
                }
            }
        }

        const emptyFilter = document.querySelector("#selectedFilters [id^=filter-]:not([searchCategory])") as HTMLElement;
        if (emptyFilter) {
            emptyFilter.setAttribute('searchCategory', search.searchCategory.label);
            emptyFilter.setAttribute('operator', search.operator);
            emptyFilter.setAttribute('searchValue', search.searchValue);
            emptyFilter.innerText = search.searchCategory.label + ' ' + search.operator + ' ' + search.searchValue;
        } else {
            alert('Maximale Anzahl an Filtern erreicht.');
        }
    };

    function resetFilterComponent(filter: HTMLElement) {
        filter.removeAttribute('searchCategory');
        filter.removeAttribute('operator');
        filter.removeAttribute('searchValue');
        filter.innerText = '';
    }

    const removeFilter = (filterIdToBeDeactivated: string) => {
        console.log('removeFilter from ' + filterIdToBeDeactivated);

        const filterToBeDeactivated = document.getElementById(filterIdToBeDeactivated) as HTMLElement;
        resetFilterComponent(filterToBeDeactivated);

        const elementTiles = document.querySelectorAll('[id^=ElliTile]:not([placeholder])');
        elementTiles.forEach(function (elementTile) {
            (elementTile as HTMLElement).style.filter = '';
        });

        const activeFilter = document.querySelectorAll("#selectedFilters [id^=filter-][searchCategory]") as NodeListOf<HTMLElement>;
        var activeSearches = new Array<Search>();

        activeFilter.forEach(function (activeFilter) {
            activeSearches.push(new Search(getDropdownOptionByLabel(activeFilter.getAttribute('searchCategory')!)!, activeFilter.getAttribute('operator')!, activeFilter.getAttribute('searchValue')!));
            resetFilterComponent(activeFilter);
        });
        activeSearches.forEach(function (activeSearch) {
            applyFilter(new Search(activeSearch.searchCategory, activeSearch.operator, activeSearch.searchValue));
        });
    };

    useEffect(() => {
        const handleEscapeKey = (event: { key: string; }) => {
            if (event.key === 'Escape') {
                console.log('Escape key pressed!');
                for (let i = 5; i > 0; i--) {
                    if (document.getElementById('filter-' + i)?.hasAttribute('searchCategory')) {
                        removeFilter('filter-' + i);
                        break;
                    }
                }
            }
        };
        document.addEventListener('keydown', handleEscapeKey);

        return () => {
            document.removeEventListener('keydown', handleEscapeKey);
        };
    }); // Empty dependency array means this effect runs once when the component mounts

    const handlePossibleEnterInInput = (event: { key: string; }) => {
        if (event.key === 'Enter') {
            applyFilter(new Search(options[selectedAttribute!.value], (document.getElementById('filter-toggle') as HTMLInputElement).innerText, (document.getElementById('filter-input') as HTMLInputElement).value));
        }
    };

    return (
        <div className='flex bg-fnbg-accent my-4'>
            <div id='selectedFilters' className='flex'>
                <PSEActiveFilter id='filter-1' onClick={() => removeFilter('filter-1')} />
                <PSEActiveFilter id='filter-2' onClick={() => removeFilter('filter-2')} />
                <PSEActiveFilter id='filter-3' onClick={() => removeFilter('filter-3')} />
                <PSEActiveFilter id='filter-3' onClick={() => removeFilter('filter-4')} />
                <PSEActiveFilter id='filter-3' onClick={() => removeFilter('filter-5')} />
            </div>
            <div className='mr-8 bg-fnbg-body ml-auto my-2'>
                <div className="dropdown border-2 flex">
                    <Button onClick={toggleDropdown} addClasses="dropbtn ml-auto pl-auto">Elemente filtern</Button>
                    {isDropdownOpen && (
                        <div className="dropdown-content">
                            <div className='flex'>
                                <Dropdown options={options} onSelect={handleDropdownSelect} />
                                <ToggleOperator id='filter-toggle' currentType={selectedAttribute!.type} />
                                <input type="text" className='w-24' id='filter-input' onKeyDown={handlePossibleEnterInInput} />
                                <Button onClick={() => applyFilter(new Search(options[selectedAttribute!.value], (document.getElementById('filter-toggle') as HTMLInputElement).innerText, (document.getElementById('filter-input') as HTMLInputElement).value))} id='execute-button' addClasses='p-2'>✓</Button>
                            </div>
                        </div>
                    )}
                </div>
            </div>
        </div>
    );
};
export default PSEFilter;