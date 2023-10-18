import React from 'react';

type ButtonProps = {
    children: React.ReactNode;
    onClick: () => void;
};

const Button: React.FC<ButtonProps> = ({ onClick, children }) => {
    return (
        <button onClick={onClick} className="button font-bold p-4 hover:bg-fnbg-accent rounded-lg hover:text-fnbg-purple duration-300">
            {children}
        </button>
    );
};

export default Button;
