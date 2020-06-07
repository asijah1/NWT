import React, { Component, useState  } from 'react';
import './App.css';

import { BrowserRouter as Router, Route } from 'react-router-dom'
import Registracija from './Registracija/registracija.js'
import Login from './Login/login.js'
import Header from './header'
import Footer from './footer'
import Pocetna from './Početna/pocetna.js'
import Kategorije from './Kategorije/kategorije'
import NovaPonuda from './NovaPonuda/novaPonuda.js'
import Profil from './Profil/profil.js'
import NoviKatalog from './NoviKatalog/noviKatalogSaValidacijomNaFrontendu.js'
export class App extends Component {
  
  render(){
    
    return (
      <Router>
          <Header />
          <div>
            <Route path="/kategorije" component={Kategorije} />
            <Route path="/pocetna" component={Pocetna} />
            <Route path="/login" component={Login} />
            <Route path="/registracija" component={Registracija} />
            <Route path="/dodajPonudu" component={NovaPonuda} />
            <Route path="/profil" component={Profil} />
            <Route path="/noviKatalog" component={NoviKatalog} />
          </div>
          <Footer />
      </Router>
    ) ;
  }
}

export default App;