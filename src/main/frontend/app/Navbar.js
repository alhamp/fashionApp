import React, { Component } from 'react';

class Navbar extends Component {
render() {
return (
<div className="breadcrumbs row">
<nav className="columns small-8" data-topbar role="navigation">
 <ul className="breadcrumbs">
   <li><a href="/">Home Page</a></li>
   <li><a href="/fashion/new">Share Your Style</a></li>
   <li><a href="/list">Style Voices</a></li>
   <li><a href="/login">Login</a></li>
   <li><a href="/about">About</a></li>
 </ul>
</nav>
</div>
        )
    }
}
export default Navbar