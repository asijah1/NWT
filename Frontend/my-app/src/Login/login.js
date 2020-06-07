import React, { Component } from 'react';
import { Redirect } from "react-router-dom";
import './login.css';

const tokenApi = "http://localhost:8084/auth/oauth/token"

export class login extends Component {
  constructor(props){
    super(props);
    this.state = {
      isLoggedIn : false,
      isError: false,
      ime: '',
      sifra: ''
    }
    this.onChange = this.onChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
  };
  
  /*handleLogin(){
    var xhr = new XMLHttpRequest();
    xhr.open('POST', tokenApi);
    xhr.setRequestHeader('Content-Type', 'application/json; charset=UTF-8');
    let text = {
      grant_type: "password",
      scope: "webclient",
      username: this.state.ime,
      password: this.state.sifra
    }
    xhr.send(JSON.stringify(text));

    xhr.onreadystatechange = function() {
      if (xhr.readyState == XMLHttpRequest.DONE) {
        xhr.responseText
      }
  }*/

  handleSubmit(event){ 
    /*event.preventDefault();  // ovaj dio koda je trebao da bude orginalni dio koda,
    fetch(tokenApi, {          //ali zbog toga što ne možemo da ostvarimo komunikaciju 
      method: 'post',          // sa apiGatewayom, moramo hardkodirati usera
      headers: {'Content-Type':'application/json'},
      body: {
        grant_type: "password",
        scope: "webclient",
        username: this.state.ime,
        password: this.state.sifra
      }
     }).then(res => res.json())
     .then(
       (result) => {
        localStorage.setItem("token", result.token);
        
         this.setState({
           isLoggedIn: true,
         });
       },
       // Note: it's important to handle errors here
       // instead of a catch() block so that we don't swallow
       // exceptions from actual bugs in components.
       (error) => {
         this.setState({
           isError: true,
           isLoggedIn: false
         });
       }
     );*/
     let user = {
       firstName: "Jack",
       secondName: "Bauer",
       location: "Visoko", 
       email:"io1@etf.unsa.ba",
       telephone: "062/111-111",
       password: "sifra"
      }
     localStorage.setItem("user",JSON.stringify(user));
     localStorage.setItem("loggedIn","Da");
     
  };
  
  /*handleSubmit(event){ 
    event.preventDefault();
    fetch(tokenApi + this.props.inputText)
      .then(res => res.json())
      .then(
        (result) => {
          if(result.password == this.state.sifra){
            localStorage.setItem("user", {user: {ime: this.state.ime, token: result.password}});
            this.setState({
              isError: false,
              isLoggedIn: true
            });
            
          }
          else
          this.setState({
            isError: true,
            isLoggedIn: false
          });
        },
        // Note: it's important to handle errors here
        // instead of a catch() block so that we don't swallow
        // exceptions from actual bugs in components.
        (error) => {
          this.setState({
            isError: true,
            error
          });
        }
      
    );
  };
  */
  onChange(e) {
    if (e.target.id === 'email') {
        this.setState({ ime: e.target.value });
    } else if (e.target.id === 'pwd') {
        this.setState({ sifra: e.target.value });
    } 
  };

  /*
  if (isLoggedIn) {
    return <Redirect to="/" />;
  }
  */

  render() {
    return (
        <div class="container">
          
          <h2>Login</h2>
          <form class="formLogin" action="/action_page.php" onSubmit={this.handleSubmit}>
              <div class="form-group">
                  <label for="email">Email:</label>
                  <input type="email" class="form-control" id="email" placeholder="Enter email" name="email" onChange={this.onChange}/>
              </div>
              <div class="form-group">
                  <label for="pwd">Password:</label>
                  <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="pwd" onChange={this.onChange}/>
              </div>
              <div class="checkbox">
                  <label><input type="checkbox" name="remember"/> Remember me</label>
              </div>
              <button type="submit" class="btn btn-default">Submit</button>
          </form>
      </div>
    )
  }
}



export default login;
