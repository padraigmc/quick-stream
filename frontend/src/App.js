import { Routes, Route } from 'react-router-dom';
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
    <div className='content'>
      <Routes>
        <Route exact path='/' element={<Home />}></Route>
        <Route exact path='/browse' element={<Browse />}></Route>
        <Route exact path='/upload' element={<Upload />}></Route>
        <Route exact path='/watch/:id' element={<Watch />}></Route>
      </Routes>
    </div>
  </div>
);

export default App;