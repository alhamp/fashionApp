import React, {Component} from "react"

const NumberField = props => {
  return(
    <div>
      <label>{props.label}</label>
      <input
        name={props.name}
        type='number'
        value={props.content}
        onChange={props.handleInput}
      />
    </div>
  )
}

export default NumberField
