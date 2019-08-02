import React from "react"

const Review = props => {
  return(
    <div className="small-12 columns">
        <div className="row">
        <h3>Rating: {props.review.rating}</h3>
        <img className="small-6 columns" width="100%" src={props.review.photo} alt='Review photo uploaded by user.'></img>
        <div className="small-6 columns">
        <p>Quality: {props.review.quality}</p>
        <p>Body Type: {props.review.bodyType}</p>
        <p>Size: {props.review.itemSize}</p>
        <p>{props.review.comment}</p>
        </div>
        </div>
    </div>
  )
}

export default Review