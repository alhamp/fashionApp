import React, { Component } from 'react';

class Navbar extends Component {
render() {
return (
<div className="breadcrumbs">
<nav class="top-bar" data-topbar role="navigation">
 <ul className="breadcrumbs">
   <li><a href="/">Home Page</a></li>
   <li><a href="/fashion/new">Share Your Style</a></li>
   <li><a href="/list">Style Voices</a></li>
 </ul>
</nav>
</div>
        )
    }
}
export default Navbar