import React, {Component} from 'react';


class Show extends Component {
    constructor(props){
        super(props)
        this.state = {
            fashionItem:{}
        }
    }

    componentDidMount(){
        fetch("/api/v1/fashion/1")
        .then(resp => {
            return resp.json()
        })
        .then(body => {
            this.setState({fashionItem:body.content}) 
        })
    }

    render() {
        return (
            <div>
                <p>{this.state.fashionItem.name}</p>
            </div>
        )
    }
}
export default Show
