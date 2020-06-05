import React, { Component } from 'react';
import './registracija.css';

const korisniciApi = "http://localhost:8081/korisnici"

class registracija extends Component {
    constructor(props) {
        super(props)
        this.state = {
            ime: '',
            prezime: '',
            datumRodjenja: '',
            spol: 'false',
            email: '',
            password: ''
        };
        this.onChange = this.onChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    };
    onChange(e) {
        if (e.target.id === 'ime') {
            this.setState({ ime: e.target.value });
        } else if (e.target.id === 'prezime') {
            this.setState({ prezime: e.target.value });
        } else if (e.target.id === 'datum') {
            this.setState({ datum: e.target.value });
        } else if (e.target.id === 'spol') {
            this.setState({ sopl: false});
        } else if (e.target.id === 'email') {
            this.setState({ email: e.target.value});
        } else if (e.target.id === 'pwd') {
            this.setState({ password: e.target.value});
        } 
    }

    handleSubmit() {
        const text = {
            firstName: this.state.ime,
            lastName: this.state.prezime,
            location: "Visoko",
            email: this.state.email,
            phone: "062/111-111"
        }
        console.log(JSON.stringify(text));

        var xhr = new XMLHttpRequest();
        xhr.open('POST', korisniciApi);
        xhr.setRequestHeader('Content-Type', 'application/json; charset=UTF-8');
        xhr.send(JSON.stringify(text));

        /*fetch(korisniciApi, {
            method: 'POST',
            body: JSON.stringify(text),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(response => {
            if (response.status >= 200 && response.status < 300) {
                return response;
                console.log(response);
                
              } else {
               console.log('Somthing happened wrong');
              }
        }).catch(err => err);*/
    };
  render() {
    return (
      <div class="container">
          <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"></link>
          <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
          <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
          <h2>Registracija</h2>
          <form class="formRegistracija" action="/action_page.php" onSubmit={this.handleSubmit}>
              <div class="form-group">
                  <label for="ime">Ime:</label>
                  <input type="text" class="form-control" id="ime" placeholder="Enter First Name" name="ime" onChange={this.onChange}/>
              </div>
              <div class="form-group">
                  <label for="prezime">Prezime:</label>
                  <input type="text" class="form-control" id="prezime" placeholder="Enter Last Name" name="prezime" onChange={this.onChange}/>
              </div>
              <div class="form-group">
                  <label for="datum">Datum rođenja:</label>
                  <input type="date" class="form-control" id="datum" placeholder="Enter Last Name" name="datum" onChange={this.onChange}/>
              </div>
              <label>Spol:</label>
              <div class="form-group">
                  <label class="radio-inline"><input type="radio" name="spol" checked />Muško</label>
                  <label class="radio-inline"><input type="radio" name="spol" />Žensko</label>
              </div>
              <div class="form-group">
                  <label for="email">Email:</label>
                  <input type="email" class="form-control" id="email" placeholder="Enter email" name="email" onChange={this.onChange}/>
              </div>
              <div class="form-group">
                  <label for="pwd">Password:</label>
                  <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="pwd" onChange={this.onChange}/>
              </div>

              <button type="submit" class="btn btn-default" >Submit</button>
          </form>
      </div>
    );
  }
}



export default registracija;
