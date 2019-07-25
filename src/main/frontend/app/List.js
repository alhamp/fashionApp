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
            this.setState({fashionItems:body.content}) 
        })
    }

    render() {
        let fashionItems = this.state.fashionItems.map(item => {
            return <p>{item.name}</p>
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
