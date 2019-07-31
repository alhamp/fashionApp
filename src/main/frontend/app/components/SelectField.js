import React from 'react';

const SelectField = props => {
  let optionElements = props.optionElements

  return (
    <label>{props.label}
      <select name={props.name} value={props.value} onChange={props.handleChange}>
        <option value=""></option>
        {optionElements}
      </select>
    </label>
  );
}

export default SelectField;