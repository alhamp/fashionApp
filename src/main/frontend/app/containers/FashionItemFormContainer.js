import React, {Component} from 'react';

class FashionItemFormContainer extends Component {
constructor(props){
    super(props);
    this.state = {
        name: " ",
        clothingType:" ",
        styles: " ",
        bodyType: " " ,
        measurements:" ",
        brand:" ",
        fabricWeight: " ",
        quality: " ",
        itemSize:" ",
        photo: " ",
        budget:" ",
        user:" "
    };
    this.handleSubmit = this.handleSubmit.bind(this)
    this.clearForm = this.clearForm.bind(this)
    this.handleChange = this.handleChange.bind(this)
}

handleChange(event) {
    this.setState({ [event.target.name]: event.target.value})
  }
handleSubmit(event) {
    event.preventDefault()
    this.props.addNewItem(this.state)
    this.clearForm()
}

clearForm(){
    this.setState({
        name: " ",
        clothingType:" ",
        styles: " ",
        bodyType: " " ,
        measurements:" ",
        brand:" ",
        fabricWeight: " ",
        quality: " ",
        itemSize:" ",
        photo: " ",
        budget:" ",
        user:" "
    })
}

render() {
    return (
        <div>
        <form onSubmit={this.handleSubmit}>
        <InputField
        label="Your item name"
        name="name"
        value={this.state.name}
        handleChange={this.handleChange}
      />
      <div>
      <select name="clothingType">
        <option value="dress">Dress</option>
        <option value="blazers">Blazers</option>
        <option value="coats">Coats</option>
        <option value="dresses">Dresses</option>
        <option value="jumpsuits">Jumpsuits</option>
        <option value="knitwear">Knitwear</option>
        <option value="shirts|blouses">Shirts|Blouses</option>
        <option value="tops">Tops</option>
        <option value="t-shirts">T-Shirt</option>
        <option value="pants">Pants</option>
        <option value="jeans">Jeans</option>
        <option value="shorts">Shorts</option>
        <option value="skirts">Skirts</option>
        <option value="swimwear">Swimwear</option>
        <option value="shoes">shoes</option> 
    </select>
    </div>
        </form> 
        </div>
    )
  } 
}

export default FashionItemFormContainer;