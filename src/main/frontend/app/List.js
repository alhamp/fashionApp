import React, {Component} from 'react';


class List extends Component {
    constructor(props){
        super(props)
        this.state = {
            fashionItems:[]
        }
    }

    componentDidMount(){
        fetch("/api/v1/fashion")
        .then(resp => {
            return resp.json()
        })
        .then(body => {
            this.setState({fashionItems:body.indexItemsDTOS}) 
        })
    }

    render() {
        let fashionItems = this.state.fashionItems.map(item => {
            let path = "/show/" + item.id
            return (
            <div key={item.id}>
                <img src={item.photo} alt={item.name} width="30%"></img>
                <p><a href={path}>{item.name}</a></p>
            </div>)
        })

        return (
            <div>
                <h2>Find your style:</h2>
                {fashionItems}
                <a href="/fashion/new">Add a new item</a>
            </div>
        )
    }
}
export default List
