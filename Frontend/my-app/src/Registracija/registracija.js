import React, { Component } from 'react';

import { BrowserRouter as Router, Route } from 'react-router-dom'
import './registracija.css';

class registracija extends Component {
  render() {
    return (
      <div class="container">
          <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"></link>
          <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
          <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
          <h2>Registracija</h2>
          <form class="formRegistracija" action="/action_page.php">
              <div class="form-group">
                  <label for="ime">Ime:</label>
                  <input type="text" class="form-control" id="ime" placeholder="Enter First Name" name="ime"/>
              </div>
              <div class="form-group">
                  <label for="prezime">Prezime:</label>
                  <input type="text" class="form-control" id="prezime" placeholder="Enter Last Name" name="prezime"/>
              </div>
              <div class="form-group">
                  <label for="datum">Datum rođenja:</label>
                  <input type="date" class="form-control" id="datum" placeholder="Enter Last Name" name="datum"/>
              </div>
              <label>Spol:</label>
              <div class="form-group">
                  <label class="radio-inline"><input type="radio" name="spol" checked />Muško</label>
                  <label class="radio-inline"><input type="radio" name="spol" />Žensko</label>
              </div>
              <div class="form-group">
                  <label for="email">Email:</label>
                  <input type="email" class="form-control" id="email" placeholder="Enter email" name="email"/>
              </div>
              <div class="form-group">
                  <label for="pwd">Password:</label>
                  <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="pwd"/>
              </div>

              <button type="submit" class="btn btn-default">Submit</button>
          </form>
      </div>
    );
  }
}



export default registracija;
