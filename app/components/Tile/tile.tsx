import React from 'react';

interface TileProps {
    label: string;
    color: string;
}

const Tile: React.FC<TileProps> = ({ label, color }) => {
    return (
        <div className={`text-center ${color} flex items-center justify-center text-fuchsia-900  aspect-square`}>
            {label}
        </div>
    );
};

export default Tile;
