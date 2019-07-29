import React, {Component} from 'react'
import FashionItemDisplay from './components/FashionItemDisplay'


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
            this.setState({fashionItems:body.content}) 
        })
    }

    render() {
        let fashionItems = this.state.fashionItems.map(item => {
            return <FashionItemDisplay key={item.id} item={item} />
        })

        return (
            <div>
                <h2>Find your style:</h2>
                {fashionItems}
            </div>
        )
    }
}
export default List
