import React from 'react';
import ReactDom from 'react-dom';
import List from './List'
import Show from './Show'
import HomePage from './HomePage'
import FashionItemFormContainer from './containers/FashionItemFormContainer'
import App from './App'

const pageMap = {
  "list": List,
  "show": Show,
  "homePage": HomePage,
  "app":App
}

for(const domId in pageMap) {
  if(document.getElementById(domId)) {
    const Component = pageMap[domId]
    ReactDom.render(<Component />,document.getElementById(domId))
  }
}

