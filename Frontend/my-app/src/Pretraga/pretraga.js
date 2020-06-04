import React, { Component } from 'react';
import './pretraga.css';

export class Pretraga extends Component {
  
  render() {
    //var kategorije = ['Vozila', 'Nekretnine', 'Tehnika'];
    //var podkategorije = [["Teska vozila", "Laka vozila", "Dvotockasi", "Ostalo"], ["Stanovi", "Kuce", "Zemljiste", "Ostalo"], ["Bijela tehnika", "Racunari", "Mobiteli", "Ostalo"]]
    return (
        <div class="row">
            <div class="col-lg-4">
                <ul class="list-group">
                    <li class="list-group-item">Produkti</li>
                    <li class="list-group-item">Korisnici</li>
                </ul> 
            </div>
        </div>
    )
  }
}

export default Pretraga;