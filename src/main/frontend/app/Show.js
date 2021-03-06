import React, {Component} from 'react'
import ReviewContainer from './containers/ReviewContainer'
import Review from './components/Review'
import Navbar from './Navbar';
import FashionItemFormContainer from './containers/FashionItemFormContainer'

class Show extends Component {
  constructor(props){
    super(props)
    this.state = {
      fashionItem:{},
      reviews:[],
      edit:false
    }
    this.addNewReview = this.addNewReview.bind(this)
    this.getId = this.getId.bind(this)
    this.handleDelete = this.handleDelete.bind(this)
    this.handleEditButton = this.handleEditButton.bind(this)
    this.editFashionItem = this.editFashionItem.bind(this)
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

  editFashionItem(fashionItem){
    fetch("/api/v1/edit/", {
      method:"POST",
      headers:{'Content-Type':'application/json'},
      credentials: 'same-origin',
      body: JSON.stringify(fashionItem)
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
      this.setState({fashionItem: object})
    })
    .catch(error => {
      console.log(error)
    })
  }

  handleEditButton(event){
    if(this.state.edit){
      this.setState({edit:false})
    }
    else{
      this.setState({edit:true})
    }
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
      addReview =<div><ReviewContainer addNewReview={this.addNewReview} fashionItem={fashionItem}/></div> 
    }
    else {
      addReview = <p><a href="/login">Log in</a> to add a review</p>
    }

    let deletebutton 
    let editbutton
    if(this.state.fashionItem.myItem){
      deletebutton = <a className="button" onClick={this.handleDelete}>Delete</a>
      editbutton = <a className="button" onClick={this.handleEditButton}>Edit</a>
    }

    let editform
    if(this.state.fashionItem.myItem && this.state.edit){
      let id = this.getId()
      editform = <FashionItemFormContainer handleItem={this.editFashionItem} number={id} />
    }

    return (
     <div className="row">
        <div className="extradivpadding">
        <Navbar/>
        </div>
        <div>
          <h2>{fashionItem.name}</h2>
          <div className="row">
          <img className="columns small-4" src={fashionItem.photo} alt={fashionItem.name} width="100%"></img>
            <div className="columns small-6">
              <p>Quality: {fashionItem.quality}</p>
              <p>Style: {fashionItem.style}</p>
              <p>Measurements: {fashionItem.measurements}</p>
              <p>Brand: {fashionItem.brand}</p>
              <p>Price: {fashionItem.budget}</p>
            </div>
          </div>

          <div className="row">
            <div className="small-6 columns">
            {editbutton}
            </div>
            <div className="small-12 columns">
            {editform}
            </div>
            <div className="small-6 columns">
            {deletebutton}
            </div>
          </div>
          
          <div className="row">
            <div className="small-12 columns">
            {addReview}
            </div>
            {reviews}
          </div>
        </div>
      </div>
    )
  }
}
export default Show