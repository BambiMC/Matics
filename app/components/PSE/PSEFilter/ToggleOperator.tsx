import React, { useState } from 'react';
import Button from '@components/Button/Button';

enum ToggleOperator {
    LessThan = '<',
    LessThanOrEqual = '<=',
    GreaterThan = '>',
    GreaterThanOrEqual = '>=',
    Equal = '=',
    NotEqual = '≠',
}

type ToggleOperatorProps = {
    id: string;
    currentType: string;
};

function toggleOperatorNumber(currentOperator: ToggleOperator): ToggleOperator {
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

function toggleOperatorString(currentOperator: ToggleOperator): ToggleOperator {
    if (currentOperator === ToggleOperator.Equal) {
        return ToggleOperator.NotEqual;
    } else if (currentOperator === ToggleOperator.NotEqual) {
        return ToggleOperator.Equal;
    } else {
        return ToggleOperator.Equal;
    }
}

const ToggleComponent: React.FC<ToggleOperatorProps> = ({ id, currentType }) => {
    const [operator, setOperator] = useState<ToggleOperator>(ToggleOperator.Equal);

    document.addEventListener("changedAttribute", ((event: CustomEvent) => {
        if (event.detail.type === 'string' && operator != ToggleOperator.Equal && operator != ToggleOperator.NotEqual) {
            setOperator(ToggleOperator.Equal);
        }
    }) as EventListener);

    const handleToggle = () => {
        if (currentType === 'string') {
            setOperator(toggleOperatorString(operator));
        } else if (currentType === 'number') {
            setOperator(toggleOperatorNumber(operator));
        } else {
            console.log('Unknown type: ' + currentType);
        }
    };

    return (
        <div>
            <Button onClick={handleToggle} addClasses='p-2' id={id}>{operator}</Button>
        </div>
    );
};

export default ToggleComponent;
