import React, { Component } from 'react';
import {NavLink} from 'react-router-dom';
import Pretraga from '../Pretraga/pretraga.js'
import './pocetna.css';

export class pocetna extends Component {
    constructor(props){
        super(props);
        this.state = {
        pretraga: false, //prikazivanje pretrage
        inputValue: '',
        loggedIn: false
      }
      this.pikaziPretragu = this.pikaziPretragu.bind(this);
      this.updateInputValue = this.updateInputValue.bind(this);
      this.updateUser= this.updateUser.bind(this);
    }
    pikaziPretragu(e){
        this.setState({pretraga: true});
    }
    updateInputValue(evt){
        this.setState({
            inputValue: evt.target.value
          });
    }
    updateUser(e){
        localStorage.setItem("loggedIn","Ne");
        this.setState({loggedIn: false})
    }

    componentDidMount() {
        {
            if(localStorage.getItem("loggedIn") == "Da") 
                this.setState({loggedIn: true})
            else   
                this.setState({loggedIn: false})
        } 
    }

  render() {
    return (
        <div>
            <div class="row">
                <div class="col-lg-5">
                    <form>
                        <div class="input-group">
                            <span class="input-group-addon">Pretraga</span>
                            <input id="msg" type="text" class="form-control" name="msg" placeholder="Tekst za pretragu..." value={this.state.inputValue} onChange={this.updateInputValue}></input>
                        </div>
                    </form>
                </div>
                
                <div class="col-lg-1">
                    <button type="button" class="btn btn-default" onClick={this.pikaziPretragu}>Pretraži</button>
                </div>

                <div class="col-lg-6">
                    {!this.state.loggedIn  ? (
                    <div class="btn-group">
                        <NavLink to="/login"><button type="button"  class="btn btn-default">Login</button></NavLink>
                        <NavLink to="/registracija"><button type="button" class="btn btn-default">Registracija</button></NavLink>
                    </div>
                    ) : (
                    <div class="btn-group">
                        <NavLink to="/profil"><button type="button"  class="btn btn-default">Moj profil</button></NavLink>
                        <NavLink to="/"><button type="button"  class="btn btn-default" onClick={this.updateUser}>Odjava</button></NavLink>
                    </div>
                    )
                    }
                </div>
            </div>
            {this.state.pretraga ? (
                <Pretraga inputText = {this.state.inputValue}></Pretraga>
            ) : null}
        </div>
    )
  }
}



export default pocetna;
