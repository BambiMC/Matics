import React from "react";
import Link from "next/link";

interface TileProps {
  children: string;
  to: string;
  newTab?: boolean;
}

const Tile: React.FC<TileProps> = ({ children, to, newTab = false }) => {
  return (
    <Link legacyBehavior href={to}>
      <a
        className={`m-4 relative z-50 ${newTab ? "external-link" : ""}`}
        target={newTab ? "_blank" : "_self"}
      >
        <div className="flex tile-container group h-full bg-fnbg-accent bg-white/30 relative overflow-visible rounded-md">
          <div className="flex bg-fnbg-orange h-full fnbg-orange p-4 rounded-md w-12 duration-300 group-hover:w-6 relative z-5 overflow-visible">
            <div className="bg-fnbg-orange w-16 h-16 flex-shrink-0 rounded-full ml-3 mr-4 border-fnbg-purple border-4 duration-300 group-hover:bg-fnbg-accent group-hover:-translate-x-4 group-hover:border-transparent relative z-0"></div>
          </div>
          <p className="w-auto mt-3 ml-12 relative z-10">{children}</p>
        </div>
      </a>
    </Link>
  );
};

export default Tile;
