import React, {Component} from 'react'
import FashionItemFormContainer from './containers/FashionItemFormContainer'

class App extends Component {
constructor(props) {
super(props);
this.state = {
fashionItems : []
}
this.addNewItem = this.addNewItem.bind(this)
}

        addNewItem(fashionItem){
            console.log(fashionItem)
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
                console.log(item)
                this.setState({fashionItems: this.state.fashionItems.concat(item)})
              })
              .catch(error => {
                console.log(error)
              })
        }

        render(){
    return (
    <div>
    <h1>Helooooooo from added item</h1>
    <FashionItemFormContainer addNewItem={this.addNewItem} fashionItem={fashionItem}/>
    </div>
    )
}
}


export default App;