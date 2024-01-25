import React from 'react';
import Button from '@app/components/Button/Button';

type PSEActiveFilterProps = {
  onClick: () => void;
  id: string;
};

const PSEActiveFilter: React.FC<PSEActiveFilterProps> = ({ id, onClick }) => {

  return (
    <Button addClasses="active-filter pointer-events-none outline hidden mx-2 hover:bg-red-500 hover:text-fnbg-accent" id={id} onClick={onClick}>
    </Button>
  );
};

export default PSEActiveFilter;