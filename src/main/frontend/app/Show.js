import React, {Component} from 'react';
import ReviewContainer from './containers/ReviewContainer';


class Show extends Component {
    constructor(props){
        super(props)
        this.state = {
            fashionItem:{},
            reviews:[],
            user:{}
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
            this.setState({fashionItem:body}) 
        })

        fetch("/api/v1/reviews/" + id)
        .then(resp => {
            return resp.json()
        })
        .then(body => {
            this.setState({reviews:body}) 
        })

        fetch("/api/v1/user")
        .then(resp => {
          return resp.json()
        })
        .then(body => {
           this.setState({user:body}) 
        })
    }

    addNewReview(review){
        console.log(review)
        fetch("/api/v1/reviews/", {
            method:"POST",
            headers:{'Content-Type':'application/json'},
            credentials: 'same-origin',
            body: JSON.stringify(review)
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
            console.log(object)
            this.setState({reviews: this.state.reviews.concat(object)})
          })
          .catch(error => {
            console.log(error)
          })
    }

    render() {
        let name = this.state.fashionItem.name
        let user = this.state.user
        let fashionItem = this.state.fashionItem
        return (
            <div>
                <p>{name}</p>
                <ReviewContainer addNewReview={this.addNewReview} user={user} fashionItem={fashionItem}/>
            </div>
        )
    }
}
export default Show
