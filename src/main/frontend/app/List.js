import React, {Component} from 'react';
import SideBar from './components/SideBar';


class List extends Component {
    constructor(props){
        super(props)
        let params = (new URL(document.location)).searchParams
        let budget = params.get("budget")
        let style = params.get("style")
        this.state = {
            fashionItems:[],
            budget:budget,
            style: style
        }
    }

    componentDidMount(){
        let path
        if(!this.state.style && !this.state.budget){
            path = "/api/v1/fashion"
        }
        else if(this.state.budget && this.state.style){
            path = "/api/v1/fashion/?budget=" + this.state.budget + '&style=' + this.state.style 
        }
        else if(this.state.budget){
            path = "/api/v1/budget/?budget=" + this.state.budget
        }
        else {
            path = "/api/v1/style/?style=" + this.state.style
        }
        fetch(path)
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
            <div key={item.id} className="columns small-3">
                <img src={item.photo} alt={item.name} width="100%" ></img>
                <p><a href={path}>{item.name}</a></p>
            </div>)
        })

        return (
            <div className="row">
                <SideBar/>
                <div className="columns small-10">
                    <h2 className="columns small-12 ">Find your style:</h2>
                    <div className="row">
                        {fashionItems}
                    </div>
                    <a href="/fashion/new" className="button">Add a new item</a>
                </div>
            </div>
        )
    }
}
export default List