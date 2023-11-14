import React from 'react';
import Button from '../Button/Button';

type PSEActiveFilterProps = {
  onClick: () => void;
  id: string;
};

const PSEActiveFilter: React.FC<PSEActiveFilterProps> = ({ id, onClick }) => {

  return (
    <Button addClasses="active-filter" id={id} onClick={onClick}>
    </Button>
  );
};

export default PSEActiveFilter;