    import React, {Component} from 'react'
    import FashionItemFormContainer from './containers/FashionItemFormContainer'
    import Navbar from './Navbar';

class App extends Component {
  constructor(props) {
    super(props);
    this.state = {
      fashionItems : []
    }
    this.addNewFashionItem = this.addNewFashionItem.bind(this)
  }

  addNewFashionItem(fashionItem){
    fetch("/api/v1/fashion/", {
      method:"POST",
      headers:{'Content-Type':'application/json'},
      credentials: 'same-origin',
      body: JSON.stringify(fashionItem)
    })
    .then(response => {
      if(response.ok){
        return response
    }
      else{
        throw new Error(response.text())
      }
    })
    .then(response => {
      return response.json()
    })
    .then(object => {
      this.setState({fashionItems: this.state.fashionItems.concat(object)})
      let path = "/show/" + object.id
      document.location.replace(path)
    })
    .catch(error => {
      console.log(error)
    })
  }

  render(){
    return (
    <div>
        <div>
        <Navbar/>
        </div>
      <div>
        <FashionItemFormContainer handleItem={this.addNewFashionItem} number="0"/>
      </div>
      </div>
    )
  }
}

export default App;