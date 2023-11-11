import React from 'react';

type ButtonProps = {
    children: React.ReactNode;
    onClick: any;
    addClasses?: string;
    id?: string;
};

const Button: React.FC<ButtonProps> = ({ onClick, children, addClasses, id }) => {
    return (
        <button onClick={onClick} className={`button font-bold p-2 hover:bg-fnbg-accent rounded-lg hover:text-fnbg-purple duration-300 ${addClasses}`} id={id} >
            {children}
        </button>
    );
};

export default Button;
