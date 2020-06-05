import React, {Component} from 'react';

class Korisnik extends Component{

    render(){
      const {id,firstName,lastName, location, email, phone}= this.props.korisnik;

      return(
        <div className='korisnik' key={id}>
                <p>Ime i prezime: {firstName} {lastName} </p>
                <p>Email: {location}</p>
                <p>Broj telefona: {email}</p>
                <p>Lokacija: {phone}</p>
        </div>
      );
    }
  }
  
export default Korisnik;