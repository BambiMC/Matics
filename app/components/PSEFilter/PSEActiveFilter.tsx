import React from 'react';
import Button from '../Button/Button';

type PSEActiveFilterProps = {
  onClick: () => void;
  id: string;
};

const PSEActiveFilter: React.FC<PSEActiveFilterProps> = ({ id, onClick }) => {

  document.addEventListener("addedFilter", ((e: CustomEvent) => {
    if (e.detail === id) {

      const filter: HTMLElement = document.getElementById(id)!;
      filter!.innerText = filter!.getAttribute('attribute') + ' ' + filter!.getAttribute('toggleOperator') + ' ' + filter!.getAttribute('filterValue');
      filter.style.display = 'block';
    }

  }) as EventListener);

  return (
    <Button addClasses="active-filter" id={id} onClick={onClick}>
    </Button>
  );
};

export default PSEActiveFilter;