import React from 'react';
import ReactDom from 'react-dom';
import List from './List'
import Show from './Show'
import App from './App'
import HomePage from './HomePage'
import About from './About'

const pageMap = {
  "list": List,
  "show": Show,
  "homepage": HomePage,
  "app":App,
  "about":About
}

for(const domId in pageMap) {
  if(document.getElementById(domId)) {
    const Component = pageMap[domId]
    ReactDom.render(<Component />,document.getElementById(domId))
  }
}

