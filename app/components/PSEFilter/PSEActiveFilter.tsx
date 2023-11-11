import React from 'react';

type PSEActiveFilterProps = {
  attribute: string;
  operator: string;
  filterValue: string | number;
};

const PSEActiveFilter: React.FC<PSEActiveFilterProps> = ({ attribute, operator, filterValue }) => {
  return (
    <div className="active-filter">
      <span>{attribute}</span>
      <span>{operator}</span>
      <span>{filterValue}</span>
    </div>
  );
};

export default PSEActiveFilter;