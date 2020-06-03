import React, { Component } from 'react';
import {NavLink} from 'react-router-dom';

import './pocetna.css';

export class pocetna extends Component {
  render() {
    return (
        <div class="row">
            <div class="col-lg-5">
                <form>
                    <div class="input-group">
                        <span class="input-group-addon">Pretraga</span>
                        <input id="msg" type="text" class="form-control" name="msg" placeholder="Tekst za pretragu..."></input>
                    </div>
                </form>
            </div>
            
            <div class="col-lg-1">
                <button type="button" class="btn btn-default">Pretraži</button>
            </div>

            <div class="col-lg-6">
                <div class="btn-group">
                <NavLink to="/login"><button type="button" class="btn btn-default">Login</button></NavLink>
                <NavLink to="/registracija"><button type="button" class="btn btn-default">Registracija</button></NavLink>
                </div>
            </div>
        </div>
    )
  }
}



export default pocetna;
