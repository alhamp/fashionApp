import React from "react"

const NumberField = props => {
  return(
    <div>
      <label>{props.label}</label>
      <input
        name={props.name}
        type='number'
        value={props.value}
        onChange={props.handleChange}
      />
    </div>
  )
}

export default NumberField
