import React, { Component } from 'react';
let budget = require('../../resources/images/budget.jpg');

class HomePage extends Component {
    render() {
        return (
            <div>
             <div className="grid-container">
                 <h3>Join our community to find the style that will fit any occasion as well as your needs!</h3>
             </div>
             <div className="grid-x grid-padding-x">
                 <div className="large-4 medium-4 cell primary callout">
                        <div className="style">
                            <a href="/style"><img src={budget} alt="Search by Style"></img></a>
                        </div>
                    </div>
            </div>
             <div className="large-4 medium-4 cell">
                 <p><a href="/budget">Browse by Budget</a><br />Pick Your Price</p>
             </div>
             <div className="large-4 medium-4 cell">
                 <p><a href="/size">Browse Sizes</a><br />What&rsquo;s my size again?</p>
             </div>
             <div className="large-4 medium-4 cell">
                 <p><a href="/addstyle">Add a Style</a><br />I wanna share a style!</p>
             </div>
             <div className="large-4 medium-4 cell">
                 <p><a href="/summerTrends">Summer Trends</a><br />I wanna share something</p>
             </div>
             <div className="large-4 medium-4 cell">
                 <p><a href="/under100">Under 100</a><br />Find me deals under $100!</p>
             </div>
             </div>
        )
    }
}
export default HomePage