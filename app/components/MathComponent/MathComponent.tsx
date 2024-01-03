import React, { useEffect } from 'react';
import katex from 'katex';
import 'katex/dist/katex.min.css';

interface MathComponentProps {
    mathExpression: string;
}

const MathComponent: React.FC<MathComponentProps> = ({ mathExpression }) => {
    const mathContainerId = `math-container-${Math.random().toString(36).substring(7)}`;

    useEffect(() => {
        katex.render(mathExpression, document.getElementById(mathContainerId)!, {
            throwOnError: false,
        });
    }, [mathExpression, mathContainerId]);

    return <div className='px-1 text-fnbg-text' id={mathContainerId} />;
};

export default MathComponent;
