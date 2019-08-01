import React, { Component } from 'react';

class HomePage extends Component {
    render() {
        return (
            <div>
            <div className="grid-container">
                 <h3>Join our community to find the style that will fit any occasion as well as your needs!</h3>
            </div>
            <div className="grid-x grid-padding-x">
                <div className="large-4 cell medium-4 columns primary callout">
                        <div className="style">
                            <a href="/style">
                              <img src='/images/shopbystyle.jpg' alt="Search by Style"></img>
                            </a>
                        </div>
                </div>
            </div>
            <div className="grid-x grid-padding-x">
                <div className="large-4 cell medium-4 columns primary callout">
                    <div className="budget">
                        <a href="/budget">
                            <img src='/images/budget.jpg' alt="Browse By Budget"></img>
                        </a>
                  </div>
                </div>
            </div>
            <div className="grid-x grid-padding-x">
                <div className="large-4 medium-4 cell primary callout">
                    <div className="size">
                        <a href="/size">Search Sizes</a>
                    </div>
                </div>
            </div>
            <div className="grid-x grid-padding-x">
                <div className="large-4 medium-4 cell primary callout">
                    <div className="addStyle">
                        <a href="/addStyle">Add your Style</a>
                    </div>
                </div>
            </div>
            <div className="grid-x grid-padding-x">
                <div className="large-4 medium-4 cell primary callout">
                    <div className="summerTrends">
                        <a href="/summerTrends">
                            <img src='/images/summer.jpg' alt="Seek Summer Chic"></img>
                        </a>
                  </div>
                </div>
            </div>
            <div className="grid-x grid-padding-x">
                <div className="large-4 medium-4 cell primary callout">
                    <div className="under100">
                        <a href="/under100">Deals Under 100</a>
                    </div>
                </div>
            </div>
            </div>
        )
    }
}
export default HomePage