import React from 'react';
import Link from 'next/link';

interface TileProps {
    label: string;
    color: string;
    to: string;
}



const Tile: React.FC<TileProps> = ({ label, color, to }) => {
    return (
        <Link href={to}>
            <div className={`text-center flex items-center justify-center aspect-square bg-fnbg-accent`}>
                {label}
            </div>
        </Link>
    );
};

export default Tile;