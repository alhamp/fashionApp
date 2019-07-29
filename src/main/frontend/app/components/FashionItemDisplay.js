import React from "react"

const FashionItemDisplay = props => {
    let item = props.item
    let path = "/show/" + item.id
  return(
    <div>
        <img src={item.photo} alt={item.name}/>
        <p key={item.id}><a href={path}>{item.name}</a></p>
    </div>
  )
}

export default FashionItemDisplay