import React, {Component} from "react"

const TextField = props => {
  return(
    <div>
      <label>{props.label}</label>
      <textarea name={props.name} onChange={props.handleChange} value={props.value}>
      </textarea>
    </div>
  )
}

export default TextField
