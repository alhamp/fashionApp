import React from 'react';
import ReactDom from 'react-dom';
import List from './List'
import Show from './Show'
import FashionItemFormContainer from './containers/FashionItemFormContainer'
import App from './App'
import HomePage from './HomePage'

const pageMap = {
  "list": List,
  "show": Show,
  "app":App,
  "homepage": HomePage
}

for(const domId in pageMap) {
  if(document.getElementById(domId)) {
    const Component = pageMap[domId]
    ReactDom.render(<Component />,document.getElementById(domId))
  }
}

