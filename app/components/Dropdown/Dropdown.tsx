import { useLanguageData } from '@data/languageLoader';
import { ElementData } from '@public/libChem/elementData';
import React, { useState, FC } from 'react';


interface DropdownOption {
    key: keyof ElementData;
    value: number;
    type: string;
}

interface DropdownProps {
    options: DropdownOption[];
    onSelect: (option: DropdownOption) => void;
}

const Dropdown: FC<DropdownProps> = ({ options, onSelect }) => {
    const data = useLanguageData("periodicTableFilter");

    const [selectedAttribute, setSelectedAttribute] = useState<DropdownOption | null>(options[0]);
    const [isOpen, setIsOpen] = useState(false);

    const handleSelect = (option: DropdownOption) => {
        setSelectedAttribute(option);
        onSelect(option);
        setIsOpen(false);
    };

    return (
        <div className="dropdown-container">
            {data && (
                <div>
                    <div className="selected-option p-2 cursor-pointer" onClick={() => setIsOpen(!isOpen)}>
                        {selectedAttribute ? data[selectedAttribute.key.toString()] : data['attributAuswaehlen']}
                    </div>
                    {isOpen && (
                        <div className="options-container">
                            {options.map((option) => (
                                <div
                                    key={option.value}
                                    className="option cursor-pointer"
                                    onClick={() => handleSelect(option)}
                                >
                                    {data[option!.key.toString()]}
                                </div>
                            ))}
                        </div>
                    )}
                </div>
            )}
        </div>
    );
};

export default Dropdown;
