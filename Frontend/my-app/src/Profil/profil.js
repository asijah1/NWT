import React, { Component } from 'react';
import Katalog from '../Katalog/katalog.js'
import {NavLink} from 'react-router-dom';
import './profil.css';
const ponudeApi= "http://localhost:8087/katalozi"; //svi katalozi na kojima korisnik ima neke ponude
const kataloziApi = 'http://localhost:8087/katalozi'; // svi korisnikovi katalozi


export class Profil extends Component {
  constructor(props) {
    super(props);
    this.state = {
      error: null,
      isLoaded: false,
      ponude: [],
      katalozi: [],
      ponudePrikaz: false, //stanje za prikazivanje korisnika
      kataloziPrikaz: false //stanje za prikazivanje proizvoda
    };
    this.prikaziponude = this.prikaziponude.bind(this);
    this.prikazikataloge = this.prikazikataloge.bind(this);
  }
  
  prikaziponude(e){
    this.setState({
      ponudePrikaz: true, 
      kataloziPrikaz: false
    })
  }
  prikazikataloge(e){
      this.setState({
        ponudePrikaz: false, 
        kataloziPrikaz: true
      })
  }
  
  componentDidMount() {
    fetch(ponudeApi)
      .then(res => res.json())
      .then(
        (result) => {
          this.setState({
            isLoaded: true,
            ponude: result
          });
        },
        // Note: it's important to handle errors here
        // instead of a catch() block so that we don't swallow
        // exceptions from actual bugs in components.
        (error) => {
          this.setState({
            isLoaded: true,
            error
          });
        }
      )
    fetch(kataloziApi)
    .then(res => res.json())
    .then(
      (result) => {
        this.setState({
          isLoaded: true,
          katalozi: result
        });
      },
      // Note: it's important to handle errors here
      // instead of a catch() block so that we don't swallow
      // exceptions from actual bugs in components.
      (error) => {
        this.setState({
          isLoaded: true,
          error
        });
      }
    )
  }
  render() {
    //var kategorije = ['Vozila', 'Nekretnine', 'Tehnika'];
    //var podkategorije = [["Teska vozila", "Laka vozila", "Dvotockasi", "Ostalo"], ["Stanovi", "Kuce", "Zemljiste", "Ostalo"], ["Bijela tehnika", "Racunari", "Mobiteli", "Ostalo"]]

      if (this.state.error) {
        return <div>Error: {this.state.error.message}</div>;
      } else if (!this.state.isLoaded) {
        return <div>Loading...</div>;
      } else {
        return (
          <div class="row">
            <div class="row" >
            <div class="col-lg-11"></div>
              <div class="col-lg-1">
                <div class="btn-group">
                  <NavLink to="/noviKatalog"><button type="button"  class="btn btn-default">Dodaj katalog</button></NavLink>
                </div>
              </div>
            </div>
            <div class="col-lg-4">
                <ul class="list-group">
                    <li class="list-group-item" ><a onClick={this.prikaziponude}>Ponude (ovo je trebalo da prikazuje samo korisnikove ponude)</a></li>
                    <li class="list-group-item"><a onClick={this.prikazikataloge}>Katalozi(ovo je trebalo da prikazuje samo korisnikove kataloge)</a></li>
                </ul> 
            </div>

            <div class="col-lg-8">
            {this.state.ponudePrikaz ? (
              <div class="well">
                <ul>
                  {this.state.ponude.map(katalog => (
                    <li>
                      <Katalog proizvod={katalog}></Katalog>
                    </li>
                  ))}
                  
                </ul>
              </div>
            ) : null}
            {this.state.kataloziPrikaz ? (
              <div class="well">
                <ul>
                  {this.state.katalozi.map(katalog => (
                    <li >
                      <Katalog proizvod={katalog}></Katalog>
                    </li>
                  ))}
                  
                </ul>
              </div>
            ) : null}
          </div>
        </div>
      )
    }
  }
}

export default Profil;