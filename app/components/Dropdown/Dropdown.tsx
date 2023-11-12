// components/Dropdown.tsx
import React, { useState, FC } from 'react';


interface DropdownOption {
    label: string;
    value: number;
    type: string;
}

interface DropdownProps {
    options: DropdownOption[];
    onSelect: (option: DropdownOption) => void;
}

const Dropdown: FC<DropdownProps> = ({ options, onSelect }) => {
    const [selectedAttribute, setselectedAttribute] = useState<DropdownOption | null>(null);
    const [isOpen, setIsOpen] = useState(false);

    const handleSelect = (option: DropdownOption) => {
        setselectedAttribute(option);
        onSelect(option);
        setIsOpen(false);
    };

    return (
        <div className="dropdown-container">
            <div className="selected-option p-2" onClick={() => setIsOpen(!isOpen)}>
                {selectedAttribute ? selectedAttribute.label : 'Attribut auswählen'}
            </div>
            {isOpen && (
                <div className="options-container">
                    {options.map((option) => (
                        <div
                            key={option.value}
                            className="option"
                            onClick={() => handleSelect(option)}
                        >
                            {option.label}
                        </div>
                    ))}
                </div>
            )}
        </div>
    );
};

export default Dropdown;
