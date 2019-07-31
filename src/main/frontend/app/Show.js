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
  }

  componentDidMount(){
    let id =this.getId()
      fetch("/api/v1/fashion/" + id)
      .then(resp => {
          console.log(resp)
          return resp.json()
      })
      .then(body => {
        console.log(body)
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

    return (
      <div>
        <h1>{fashionItem.name}</h1>
        <img src={fashionItem.photo} alt={fashionItem.name}></img>
        <p>Quality: {fashionItem.quality}</p>
        <p>Style: {fashionItem.style}</p>
        <p>Measurements: {fashionItem.measurements}</p>
        <p>Brand: {fashionItem.brand}</p>
        <p>Budget: {fashionItem.budget}</p>
        <ReviewContainer addNewReview={this.addNewReview} fashionItem={fashionItem}/>
        {reviews}
      </div>
    )
  }
}
export default Show
