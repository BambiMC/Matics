import { useState } from "react";
import Button from "../Button/Button";

type ToggleButtonProps = {
    onClick: any;
    addClasses?: string;
    id?: string;
    offText: string;
    onText: string;
};

const ToggleButton: React.FC<ToggleButtonProps> = ({ onClick, addClasses, id, offText, onText }) => {
    const [isOn, setIsOn] = useState<boolean>(false);

    const handleToggle = () => {
        setIsOn((prev) => !prev);
        onClick;
    };

    return (
        <Button
            onClick={handleToggle}
            addClasses={`flex ${addClasses}`} id={id}>
            <p className={`${isOn ? 'text-white' : 'text-black'}`}>{onText}</p>
            <p className="px-2">|</p>
            <p className={`${!isOn ? 'text-white' : 'text-black'}`}>{offText}</p>
        </Button>
    );
};

export default ToggleButton;