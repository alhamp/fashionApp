import React, {Component} from 'react';


class Show extends Component {
    constructor(props){
        super(props)
        console.log(this.props.id)
        this.state = {
            fashionItem:{}
        }
    }

    componentDidMount(){
        let path = window.location.pathname.split('/')
        let id = path[path.length - 1];
        fetch("/api/v1/fashion/" + id)
        .then(resp => {
            return resp.json()
        })
        .then(body => {
            console.log(body)
            this.setState({fashionItem:body}) 
        })
    }

    render() {
        let name = this.state.fashionItem.name
        return (
            <div>
                <p>{name}</p>
            </div>
        )
    }
}
export default Show
