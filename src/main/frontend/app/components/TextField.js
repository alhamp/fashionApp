import React, {Component} from "react"

const TextField = props => {
  return(
    <div>
      <label>{props.label}</label>
      <input
        name={props.name}
        type='text'
        value={props.value}
        onChange={props.handleChange}
      />
    </div>
  )
}

export default TextField
