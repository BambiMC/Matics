import React from 'react';

type ButtonProps = {
    children: React.ReactNode;
    onClick: () => void;
    className?: string;
};

const Button: React.FC<ButtonProps> = ({ onClick, children, className }) => {
    return (
        <button onClick={onClick} className={`button font-bold p-4 hover:bg-fnbg-accent rounded-lg hover:text-fnbg-purple duration-300 ${className}`} >
            {children}
        </button>
    );
};

export default Button;
