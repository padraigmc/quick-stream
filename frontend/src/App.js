import { Switch, Route } from 'react-router-dom';
import React from 'react';
import './styles.css';

import NavBar from "./components/nav-bar";
import Home from './pages/home/home';
import Browse from './pages/browse/browse';
import Upload from './pages/upload/upload';
import Watch from './pages/watch/watch';

const App = () => (
  <div className="app">
    <NavBar />
    <Switch>
      <Route exact path='/' component={Home}></Route>
      <Route exact path='/browse' component={Browse}></Route>
      <Route exact path='/upload' component={Upload}></Route>
      <Route exact path='/watch/:id' component={Watch}></Route>
    </Switch>
  </div>
);

export default App;