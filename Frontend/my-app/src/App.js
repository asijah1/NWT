import React, { Component } from 'react';
import './App.css';

import { BrowserRouter as Router, Route } from 'react-router-dom'
import Registracija from './Registracija/registracija.js'
import Login from './Login/login.js'
import Header from './header'
import Footer from './footer'
import Pocetna from './Početna/pocetna.js'
import Kategorije from './Kategorije/kategorije'

class App extends Component {
  render() {
    return (
      <Router>
        
          <Header />
          <div>
            <Route path="/kategorije" component={Kategorije} />
            <Route path="/pocetna" component={Pocetna} />
            <Route path="/login" component={Login} />
            <Route path="/registracija" component={Registracija} />
          </div>
          <Footer />
      </Router>
    );
  }
}

export default App;
