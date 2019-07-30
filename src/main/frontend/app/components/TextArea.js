import React, {Component} from "react"

const TextArea = props => {
  return(
    <div>
      <label>{props.label}</label>
      <textarea name={props.name} onChange={props.handleChange} value={props.value}>
      </textarea>
    </div>
  )
}

export default TextArea