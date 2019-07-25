import React from 'react';
import ReactDom from 'react-dom';
import List from './List'
import Show from './Show'

const pageMap = {
  "list": List,
  "show": Show
}

for(const domId in pageMap) {
  if(document.getElementById(domId)) {
    const Component = pageMap[domId]
    ReactDom.render(<Component />,document.getElementById(domId))
  }
}
