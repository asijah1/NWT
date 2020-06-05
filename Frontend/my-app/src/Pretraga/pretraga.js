import React, { Component } from 'react';
import './pretraga.css';
import Korisnik from '../Korisnik/korisnik.js'
const korisniciApi= "http://localhost:8081/korisnici";
const katalogApi = '';
const proxyurl = "https://cors-anywhere.herokuapp.com/";


export class Pretraga extends Component {
  constructor(props) {
    super(props);
    console.log(props)
    this.state = {
      error: null,
      isLoaded: false,
      korisnici: [],
      proizvodi: [],
      korisniciPrikaz: false, //stanje za prikazivanje korisnika
      proizvodiPrikaz: false //stanje za prikazivanje proizvoda
    };
  }
  
  prikaziKorisnike(e){
    this.setState({
      korisniciPrikaz: true, 
      proizvodiPrikaz: false
    })
  }
  prikaziProizvode(e){
      this.setState({
        korisniciPrikaz: false, 
        proizvodiPrikaz: true
      })
  }
  
  componentDidMount() {
    fetch("http://localhost:8081/korisnici/korisnikSaNazivom?name=" + this.props.inputText)
      .then(res => res.json())
      .then(
        (result) => {
          console.log(this.props.inputText);
          this.setState({
            isLoaded: true,
            korisnici: result
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
      /*fetch("http://localhost:8080/katalozi/nazivProizvoda?naziv=" + this.props.inputText)
      .then(res => res.json())
      .then(
        (result) => {
          console.log(result)
          this.setState({
            isLoaded: true,
            proizvodi: result
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
      )*/
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
                <div class="col-lg-4">
                    <ul class="list-group">
                        <li class="list-group-item">Produkti</li>
                        <li class="list-group-item">Korisnici</li>
                    </ul> 
                </div>

                <div class="col-lg-8">
                  <div class="well">
                    <ul>
                      {this.state.korisnici.map(korisnik => (
                        <li key={korisnik.id}>
                          <Korisnik korisnik={korisnik}></Korisnik>
                        </li>
                      ))}
                      
                    </ul>
                  </div>
                </div>
            </div>
        )
      }
  }
}

export default Pretraga;