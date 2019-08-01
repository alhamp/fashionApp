import React from 'react'

 const SideBar = props => {

    return(
        <div className="columns small-2">
            <h3>Budget</h3>
            <ul className="side-nav">
                <li><a href={window.location.pathname + "?budget=25"}>$25 and under</a></li>
                <li><a href={window.location.pathname + "?budget=50"}>$50</a></li>
                <li><a href={window.location.pathname + "?budget=100"}>$100</a></li>
                <li><a href={window.location.pathname + "?budget=200"}>$200</a></li>
                <li><a href={window.location.pathname + "?budget=300"}>$300</a></li>
                <li><a href={window.location.pathname + "?budget=400"}>$400</a></li>
                <li><a href={window.location.pathname + "?budget=500"}>$500</a></li>
                <li><a href={window.location.pathname + "?budget=600"}>$600 and over</a></li>
            </ul>
            <h3>Style</h3>
            <ul className="side-nav">
                <li><a href={window.location.pathname + "?style=formal-office"}>formal-office</a></li>
                <li><a href={window.location.pathname + "?style=business-casual"}>business-casual</a></li>
                <li><a href={window.location.pathname + "?style=casual-chic"}>casual-chic</a></li>
                <li><a href={window.location.pathname + "?style=sports-wear"}>sports-wear</a></li>
                <li><a href={window.location.pathname + "?style=evening-black-tie"}>evening-black-tie</a></li>
                <li><a href={window.location.pathname + "?style='party/wedding'"}>party/wedding</a></li>
                <li><a href={window.location.pathname + "?style=pool-party"}>pool-party</a></li>
                <li><a href={window.location.pathname + "?style=vocation"}>vocation</a></li>
                <li><a href={window.location.pathname + "?style=maternity"}>maternity</a></li>
                <li><a href={window.location.pathname + "?style=streetWear"}>streetWear</a></li>
                <li><a href={window.location.pathname + "?style=cowGirl"}>cowGirl</a></li>
                <li><a href={window.location.pathname + "?style=hip-hop"}>hip-hop</a></li>
                <li><a href={window.location.pathname + "?style=rocker-chick"}>rocker-chick</a></li>
                <li><a href={window.location.pathname + "?style=military"}>military</a></li>
            </ul>
        </div>
    )
 }

 export default SideBar