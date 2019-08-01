import React from 'react'

 const DeleteButton = props => {
    handleDelete(event){
        this.preventDefault()
        this.props.deleteItem(this.props.fashionItem)
    }

    return (
        <a className="button" onClick={this.handleDelete}>Delete</a>
    )
 }

 export default DeleteButton