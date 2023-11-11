import React from 'react';
import Link from 'next/link';

interface TileProps {
    children: string;
    to: string;
}



const Tile: React.FC<TileProps> = ({ children, to }) => {
    return (
        <Link href={to} className='bg-fnbg-accent m-4'>
            <div className="tile-container group">
                <div className="flex bg-fnbg-orange fnbg-orange p-4 rounded-md w-20 duration-300 group-hover:w-10">
                    <div className="bg-fnbg-orange w-16 h-16 flex-shrink-0 rounded-full ml-6 mr-4 border-fnbg-accent border-4 duration-300 group-hover:opacity-0"></div>
                    <p>{children}</p>
                </div>
            </div>
        </Link>
    );
};

export default Tile;