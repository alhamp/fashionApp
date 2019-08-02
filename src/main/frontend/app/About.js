import React, { Component } from 'react';
import Navbar from './Navbar';

class About extends Component {
render() {
return (
    <div>
        <Navbar />
    <div className="callout row">
    <h4 className="about">We know that sizing is capricious and unreliable. We know firsthand how hard it is to find clothing for specific occasions (what does tech casual even mean?). We know that there are many more factors going into a decision than online shopping currently offers (how long will this last?).
        We believe that each person should be able to express themselves through their clothing, and that finding items that fit should be a breeze.
        These problems have a simple solution - more information. Sizes can be measured. Clothing can be categorized into styles. Pockets can be counted. Quality can be rated.
        There is only one way we can hold this industry accountable - together. We need your voice to help! Add an item or write a review now. Unlike most companies in fashion, we exist to listen to you.</h4>
    </div>
    </div>
        )
    }
}
export default About