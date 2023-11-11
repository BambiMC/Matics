import React, { useState } from 'react';
import Button from '../Button/Button';

// Operators enum
enum ToggleOperator {
    LessThan = '<',
    LessThanOrEqual = '<=',
    GreaterThan = '>',
    GreaterThanOrEqual = '>=',
    Equal = '~',
    NotEqual = '!=',
}

type ToggleOperatorProps = {
    id?: string;
};

// Function to toggle the operator
function toggleOperator(currentOperator: ToggleOperator): ToggleOperator {
    switch (currentOperator) {
        case ToggleOperator.LessThan:
            return ToggleOperator.LessThanOrEqual;
        case ToggleOperator.LessThanOrEqual:
            return ToggleOperator.GreaterThan;
        case ToggleOperator.GreaterThan:
            return ToggleOperator.GreaterThanOrEqual;
        case ToggleOperator.GreaterThanOrEqual:
            return ToggleOperator.Equal;
        case ToggleOperator.Equal:
            return ToggleOperator.NotEqual;
        case ToggleOperator.NotEqual:
            return ToggleOperator.LessThan;
        default:
            return ToggleOperator.LessThan;
    }
}

const ToggleComponent: React.FC<ToggleOperatorProps> = ({ id }) => {
    const [operator, setOperator] = useState<ToggleOperator>(ToggleOperator.Equal);

    const handleToggle = () => {
        setOperator(toggleOperator(operator));
    };

    return (
        <div>
            <Button onClick={handleToggle} addClasses='p-2' id={id}>{operator}</Button>
        </div>
    );
};

export default ToggleComponent;
