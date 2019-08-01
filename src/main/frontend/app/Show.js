import React, {Component} from 'react'
import ReviewContainer from './containers/ReviewContainer'
import Review from './components/Review'

class Show extends Component {
  constructor(props){
    super(props)
    this.state = {
      fashionItem:{},
      reviews:[]
    }
    this.addNewReview = this.addNewReview.bind(this)
    this.getId = this.getId.bind(this)
    this.handleDelete = this.handleDelete.bind(this)
  }

  componentDidMount(){
    let id =this.getId()
      fetch("/api/v1/fashion/" + id)
      .then(resp => {
          return resp.json()
      })
      .then(body => {
          this.setState({fashionItem:body.itemDTO, reviews:body.fashionItemReviews.content}) 
      })
  }

  addNewReview(review){
    let id = this.getId()
    fetch("/api/v1/reviews/" + id, {
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
        this.setState({reviews: this.state.reviews.concat(object)})
      })
      .catch(error => {
        console.log(error)
      })
  }

  handleDelete(event){
    fetch("/api/v1/delete/" + this.getId())
    .catch(error => {
      console.log(error)
    })
    document.location.replace("/list")
  }

  getId(){
    let path = window.location.pathname.split('/')
    let id = path[path.length - 1]
    return id
  }

  render() {
    let fashionItem = this.state.fashionItem
    let reviews = this.state.reviews.map(review => {
        return <Review key={review.id} review={review}/>
    })

    let addReview
    if(this.state.fashionItem.loggedIn){
      addReview = <ReviewContainer addNewReview={this.addNewReview} fashionItem={fashionItem}/>
    }
    else {
      addReview = <p><a>Log in</a> to add a review</p>
    }

    let deletebutton 
    if(this.state.fashionItem.myItem){
      deletebutton = <a className="button" onClick={this.handleDelete}>Delete</a>
    }

    return (
      <div>
        <h1>{fashionItem.name}</h1>
        <img src={fashionItem.photo} alt={fashionItem.name} width="30%"></img>
        <p>Quality: {fashionItem.quality}</p>
        <p>Style: {fashionItem.style}</p>
        <p>Measurements: {fashionItem.measurements}</p>
        <p>Brand: {fashionItem.brand}</p>
        <p>Price: {fashionItem.budget}</p>
        {deletebutton}
        {addReview}
        {reviews}
      </div>
    )
  }
}
export default Show