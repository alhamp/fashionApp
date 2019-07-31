    import React, {Component} from 'react'
    import FashionItemFormContainer from './containers/FashionItemFormContainer'

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
        })
        .catch(error => {
          console.log(error)
        })
  }

  render(){
    return (
      <div>
        <h1>Add a new item:</h1>
        <FashionItemFormContainer addNewFashionItem={this.addNewFashionItem} />
      </div>
    )
  }
}

export default App;