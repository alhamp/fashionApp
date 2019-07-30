import React from "react"

const Review = props => {
  return(
    <div>
        <h3>Rating: {props.review.rating}</h3>
        <p>Quality: {props.review.quality}</p>
        <p>Body Type: {props.review.bodyType}</p>
        <p>Size: {props.review.itemSize}</p>
        <img src={props.review.photo} alt='Review photo uploaded by user.'></img>
        <p>{props.review.comment}</p>
    </div>
  )
}

export default Review