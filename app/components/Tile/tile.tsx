import React from 'react';
import Link from 'next/link';

interface TileProps {
    children: string;
    to: string;
    newTab?: boolean;
}

const Tile: React.FC<TileProps> = ({ children, to, newTab = false }) => {
    return (
        <Link legacyBehavior href={to}>
            <a className={`bg-fnbg-accent m-4 ${newTab ? 'external-link' : ''}`} target={newTab ? '_blank' : '_self'}>
                <div className="flex tile-container group h-full">
                    <div className="flex bg-fnbg-orange h-full fnbg-orange p-4 rounded-md w-20 duration-300 group-hover:w-10">
                        <div className="bg-fnbg-orange w-16 h-16 flex-shrink-0 rounded-full ml-6 mr-4 border-fnbg-accent border-4 duration-300 group-hover:opacity-0"></div>
                    </div>
                    <p className='w-32 mt-3 ml-8'>{children}</p>
                </div>
            </a>
        </Link>
    );
};

export default Tile;