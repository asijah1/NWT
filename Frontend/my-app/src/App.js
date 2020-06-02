import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';

import { BrowserRouter as Router, Route } from 'react-router-dom'
import Registracija from './Registracija/registracija.js'
import Login from './Login/login.js'
import Header from './header'
import Footer from './footer'


class App extends Component {
  render() {
    return (
      <Router>
          <Header />
          <p>
            <code>Elhamdulillah</code>.
          </p>
          <div>
            <Route path="/login" component={Login} />
            <Route path="/registracija" component={Registracija} />
          </div>
          <Footer />
      </Router>
    );
  }
}

export default App;
