import React, {Component} from 'react';


class List extends Component {
    constructor(props){
        super(props)
        let params = (new URL(document.location)).searchParams
        let budget = params.get("budget")
        let style = params.get("style")
        console.log(budget)
        console.log(style)
        this.state = {
            fashionItems:[],
            budget:budget,
            style: style
        }
    }

    componentDidMount(){
        if(!this.state.style && !this.state.budget){
            fetch("/api/v1/fashion")
            .then(resp => {
                return resp.json()
            })
            .then(body => {
                this.setState({fashionItems:body.indexItemsDTOS}) 
            })
        }
        else if(this.state.budget && this.state.style){
            let path = "/api/v1/fashion/?budget=" + this.state.budget + '&style=' + this.state.style 
            fetch(path)
            .then(resp => {
                return resp.json()
            })
            .then(body => {
                console.log(body)
                this.setState({fashionItems:body.content}) 
            })
        }
        else if(this.state.budget){
            let path = "/api/v1/budget/?budget=" + this.state.budget
            fetch(path)
            .then(resp => {
                return resp.json()
            })
            .then(body => {
                console.log(body)
                this.setState({fashionItems:body.content}) 
            })
        }
        else {
            let path = "/api/v1/style/?style=" + this.state.style 
            fetch(path)
            .then(resp => {
                return resp.json()
            })
            .then(body => {
                console.log(body)
                this.setState({fashionItems:body.content}) 
            })
        }
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
