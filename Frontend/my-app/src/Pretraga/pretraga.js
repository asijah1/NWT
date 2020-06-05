import React, { Component } from 'react';
import './pretraga.css';
import Korisnik from '../Korisnik/korisnik.js'
const korisniciApi= "http://localhost:8081/korisnici";
const katalogApi = '';
const proxyurl = "https://cors-anywhere.herokuapp.com/";


export class Pretraga extends Component {
  constructor(props) {
    super(props);
    this.state = {
      error: null,
      isLoaded: false,
      korisnici: []
    };
  }

  componentDidMount() {
    fetch("http://localhost:8081/korisnici")
      .then(res => res.json())
      .then(
        (result) => {
          console.log(result)
          this.setState({
            isLoaded: true,
            korisnici: result
          });
        },
        // Note: it's important to handle errors here
        // instead of a catch() block so that we don't swallow
        // exceptions from actual bugs in components.
        (error) => {
          console.log("ovdje sam")
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
    const { error, isLoaded, korisnici } = this.state;
    console.log(this.state.korisnici);
      if (error) {
        return <div>Error: {error.message}</div>;
      } else if (!isLoaded) {
        return <div>Loading...</div>;
      } else {
        return (
          
            <div class="row">
                <div class="col-lg-4">
                    <ul class="list-group">
                        <li class="list-group-item">Produkti</li>
                        <li class="list-group-item">Korisnici</li>
                    </ul> 
                </div>

                <div class="col-lg-8">
                  <ul>
                    {korisnici.map(korisnik => (
                      <li key={korisnik.id}>
                        <Korisnik korisnik={korisnik}></Korisnik>
                      </li>
                    ))}
                  </ul>
                </div>
            </div>
        )
      }
  }
}

export default Pretraga;