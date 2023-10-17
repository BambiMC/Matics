import React from 'react';

type ButtonProps = {
    children: React.ReactNode; // The 'children' prop for the button text
    onClick: () => void;
};

const Button: React.FC<ButtonProps> = ({ onClick, children }) => {
    return (
        <button onClick={onClick} className="button p-4">
            {children}
        </button>
    );
};

export default Button;
