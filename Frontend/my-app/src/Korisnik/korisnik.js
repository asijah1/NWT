import React, {Component} from 'react';

class Korisnik extends Component{

    render(){
      const {id,firstName,lastName, location, email, phone}= this.props.korisnik;

      return(
        <div className='korisnik' key={id}>
          <div class="well">
            <p>Ime i prezime: {firstName} {lastName} </p>
            <p>Lokacija: {location}</p>
            <p>Email: {email}</p>
            <p>Broj telefona: {phone}</p>
          </div>
        </div>
      );
    }
  }
  
export default Korisnik;