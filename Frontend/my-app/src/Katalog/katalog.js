import React, {Component} from 'react';

class Katalog extends Component{

    render(){
      return(
        <div className='katalog' key={this.props.proizvod.id}>
          <div class="well">
            <p>Naziv proizvoda: {this.props.proizvod.nazivProizvoda} </p>
            <p>Dodatne informacije: {this.props.proizvod.dodatneInformacije}</p>
            <p>Cijena: {this.props.proizvod.cijena}</p>
            <p>Datum objave: {this.props.proizvod.datumObjave}</p>
            <p>Datum zavrsetka: {this.props.proizvod.datumZavrsetka}</p>
            <p>Zavrseno: {this.props.proizvod.zavrseno ? ("Da"): "Ne"}</p>
          </div>
        </div>
      );
    }
  }
  
export default Katalog;