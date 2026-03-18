import React from "react";

type ButtonProps = {
  children?: React.ReactNode;
  onClick: any;
  addClasses?: string;
  id?: string;
  disabled?: boolean;
};

const Button: React.FC<ButtonProps> = ({
  onClick,
  children,
  addClasses,
  id,
  disabled,
}) => {
  const disabledClasses = disabled ? "opacity-50 pointer-events-none" : "";
  return (
    <button
      onClick={onClick}
      disabled={disabled}
      className={`button font-bold p-2 hover:bg-fnbg-accent rounded-none text-fnbg-text duration-300 border-2 border-fnbg-orange ${addClasses} ${disabledClasses}`}
      id={id}
    >
      {children}
    </button>
  );
};

export default Button;
