import React, { Component } from 'react';
import {Link} from 'react-router-dom';

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
                <div class="btn-group btn-group-justified">
                    <a href="#" class="btn btn-primary">Login</a>
                    <a href="#" class="btn btn-primary">Registracija</a>
                </div>
            </div>
        </div>
    )
  }
}



export default pocetna;
