import { ElementData } from '@public/libChem/elementData';
import React, { useEffect, useState } from 'react';
import Button from '@components/Button/Button';
import Dropdown from '@components/Dropdown/Dropdown';
import PSEActiveFilter from './PSEActiveFilter';
import ToggleOperator from './ToggleOperator';
import { useLanguageData } from '@data/languageLoader';

type PSEFilterProps = {
    elements: ElementData[];
    dataExtern: any;
};

interface DropdownOption {
    key: keyof ElementData;
    value: number;
    type: string;
}

class Search {
    searchCategory: DropdownOption;
    operator: string;
    searchValue: string;
    constructor(searchCategory: DropdownOption, operator: string, searchValue: string) {
        this.searchCategory = searchCategory;
        this.operator = operator;
        this.searchValue = searchValue;
    }
}

const options: DropdownOption[] = [
    { key: 'name', value: 0, type: 'string' },
    { key: 'kurzsymbol', value: 1, type: 'string' },
    { key: 'unterkategorie', value: 2, type: 'string' },
    { key: 'aussehen', value: 3, type: 'string' },
    { key: 'aggregatszustand', value: 4, type: 'string' },
    { key: 'struktur', value: 5, type: 'string' },
    { key: 'protonen', value: 6, type: 'number' },
    { key: 'neutronen', value: 7, type: 'number' },
    { key: 'haerte', value: 8, type: 'number' },
    { key: 'volumen', value: 9, type: 'number' },
    { key: 'prozentsatzAnDerErdhuelle', value: 10, type: 'number' },
    { key: 'atommasse', value: 11, type: 'number' },
    { key: 'ionisierungsenergie', value: 12, type: 'number' },
    { key: 'dichte', value: 13, type: 'number' },
    { key: 'schmelzpunkt', value: 14, type: 'number' },
    { key: 'siedepunkt', value: 15, type: 'number' },
    { key: 'elektronegativitaet', value: 16, type: 'number' },
    { key: 'flammenfarbe', value: 17, type: 'string' },
];

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

function getDropdownOptionByKey(key: string): DropdownOption {
    return options.find((option) => option.key.toString() === key)!;
}

const PSEFilter: React.FC<PSEFilterProps> = ({ elements }) => {
    const data = useLanguageData('periodicTableFilter');

    const [isDropdownOpen, setIsDropdownOpen] = useState(false);
    const [selectedAttribute, setSelectedAttribute] = useState<DropdownOption>(options[0]);

    console.log("selectedAttribute:");
    console.log(selectedAttribute.toString());

    const toggleDropdown = () => {
        setIsDropdownOpen(!isDropdownOpen);
    };


    const handleDropdownSelect = (option: DropdownOption) => {
        setSelectedAttribute(option);
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
            if (elements[i][search.searchCategory.key]) {
                if (search.searchCategory.type === 'number') {
                    if (!operatorTableNumber[search.operator](Number(elements[i][search.searchCategory.key]), Number(search.searchValue))) {
                        document.getElementById('ElliTile-' + i)!.style.filter = 'blur(6px)';
                        document.getElementById('ElliTile-' + i)!.style.pointerEvents = 'none';
                    }
                } else if (search.searchCategory.type === 'string') {
                    if (!operatorTableString[search.operator](elements[i][search.searchCategory.key]!.toString(), search.searchValue)) {
                        document.getElementById('ElliTile-' + i)!.style.filter = 'blur(6px)';
                        document.getElementById('ElliTile-' + i)!.style.pointerEvents = 'none';
                    }
                }
            } else {
                document.getElementById('ElliTile-' + i)!.style.filter = 'blur(6px)';
                document.getElementById('ElliTile-' + i)!.style.pointerEvents = 'none';

            }
        }

        const emptyFilter = document.querySelector("#selectedFilters [id^=filter-]:not([searchCategory])") as HTMLElement;
        if (emptyFilter) {
            emptyFilter.setAttribute('searchCategory', search.searchCategory.key);
            emptyFilter.setAttribute('operator', search.operator);
            emptyFilter.setAttribute('searchValue', search.searchValue);
            emptyFilter.innerHTML = search.searchCategory.key + ' ' + search.operator + ' ' + search.searchValue + '&emsp;&#x2716;';
            emptyFilter.style.pointerEvents = 'auto';
            emptyFilter.style.display = 'block';


        } else {
            alert('Maximale Anzahl an Filtern erreicht.');
        }
    };

    function resetFilterComponent(filterToReset: HTMLElement) {
        filterToReset.removeAttribute('searchCategory');
        filterToReset.removeAttribute('operator');
        filterToReset.removeAttribute('searchValue');
        filterToReset.innerText = '';
        filterToReset.style.pointerEvents = 'none';
        filterToReset.style.display = 'none';



    }

    const removeFilter = (filterIdToBeDeactivated: string) => {
        console.log('removeFilter from ' + filterIdToBeDeactivated);

        resetFilterComponent(document.getElementById(filterIdToBeDeactivated) as HTMLElement);

        const elementTiles = document.querySelectorAll('[id^=ElliTile]:not([placeholder])');
        elementTiles.forEach(function (elementTile) {
            (elementTile as HTMLElement).style.filter = '';
            (elementTile as HTMLElement).style.pointerEvents = 'auto';
        });

        const activeFilter = document.querySelectorAll("#selectedFilters [id^=filter-][searchCategory]") as NodeListOf<HTMLElement>;
        var activeSearches = new Array<Search>();

        activeFilter.forEach(function (activeFilter) {
            activeSearches.push(new Search(getDropdownOptionByKey(activeFilter.getAttribute('searchCategory')!), activeFilter.getAttribute('operator')!, activeFilter.getAttribute('searchValue')!));
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
        <div>
            {data && (
                <div className='flex bg-fnbg-accent my-4'>
                    <div id='selectedFilters' className='flex'>
                        <p className='my-auto px-4 font-bold'>{data['activeFilters'] + ": "}</p>
                        <PSEActiveFilter id='filter-1' onClick={() => removeFilter('filter-1')} />
                        <PSEActiveFilter id='filter-2' onClick={() => removeFilter('filter-2')} />
                        <PSEActiveFilter id='filter-3' onClick={() => removeFilter('filter-3')} />
                        <PSEActiveFilter id='filter-3' onClick={() => removeFilter('filter-4')} />
                        <PSEActiveFilter id='filter-3' onClick={() => removeFilter('filter-5')} />
                    </div>
                    {/* TODO break here if horizontal space is not enough */}
                    <div className='mr-8 bg-fnbg-body ml-auto my-2'>
                        <div className="dropdown border-2 flex">
                            <button onClick={toggleDropdown} className="dropbtn ml-auto pl-auto button font-bold p-2 rounded-lg text-fnbg-text hover:text-fnbg-purple duration-300">{data['filterElement']}</button>

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
            )}
        </div>
    );
};

export default PSEFilter;