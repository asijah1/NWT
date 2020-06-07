import React, { Component } from 'react';
import { Link } from 'react-router-dom';
//import './noviKatalog.css';

const katalogAPI = "http://localhost:8087/katalozi"

export class noviKatalog extends Component {

  constructor(props) {
    super(props);

    this.state = {
        nazivProizvoda: '',
        lokacija: '',
        povrsina: '',
        cijena: '',
        datumObjave:'',
        datumZavrsetka:'',
        submitted: false
    };

    this.handleChange = this.handleChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
}

handleChange(e) {
  if (e.target.id === 'nazivProizvoda') {
      this.setState({ nazivProizvoda: e.target.value });
  } else if (e.target.id === 'lokacija') {
      this.setState({ lokacija: e.target.value });
  } else if (e.target.id === 'povrsina') {
      this.setState({ povrsina: e.target.value });
  } else if (e.target.id === 'cijena') {
      this.setState({ cijena: e.target.value});
  } else if (e.target.id === 'datumObjave') {
      this.setState({ datumObjave: e.target.value});
  } else if (e.target.id === 'datumZavrsetka') {
      this.setState({ datumZavrsetka: e.target.value});
  } 
}


handleSubmit(event) {
    event.preventDefault();
  const text = {
    korisnikId: "1",
    nazivProizvoda: this.state.nazivProizvoda,
    lokacija: this.state.lokacija,
    cijena: this.state.cijena,
    datumObjave: this.state.datumObjave,
    datumZavrsetka: this.state.datumZavrsetka
  }
  
  console.log(JSON.stringify(text));
  var xhr = new XMLHttpRequest();
  xhr.open('POST', katalogAPI);
  xhr.setRequestHeader('Content-Type', 'application/json; charset=UTF-8');
  xhr.send(JSON.stringify(text));


}

  render() {
    const { katalog, submitted } = this.state;
    return (
      	<div class="container">
			<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"></link>
          	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
          	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
          	<h2>Objavi katalog</h2>
            <form name="form" onSubmit={this.handleSubmit}>
              <div className={'form-group' + (submitted && !katalog.nazivProizvoda ? ' has-error' : '')}>
                <label for="nazivProizvoda">Naziv proizvoda: </label>
                <input type="text" class="form-control" name="nazivProizvoda" id="nazivProizvoda" onChange={this.handleChange}/>
                {submitted && !katalog.nazivProizvoda &&
                        <div className="help-block">Name of product is required</div>
                    }
              </div>
              <div className={'form-group' + (submitted && !katalog.lokacija ? ' has-error' : '')}>
                <label for="lokacija">Lokacija: </label>
                <select class="form-control" name="lokacija" id="lokacija" onChange={this.handleChange}>
                  <option value="Travnik">Travnik</option>
                  <option value="Sarajevo">Sarajevo</option>
                  <option selected value="Visoko">Visoko</option>
                  <option value="Kakanj">Kakanj</option>
                </select>
                {submitted && !katalog.lokacija &&
                        <div className="help-block">Location of product is required</div>
                    }
              </div>
              <div className={'form-group' + (submitted && !katalog.povrsina ? ' has-error' : '')}>
                <label for="povrsina">Povrsina (m^2): </label>
                <input type="text" class="form-control" id="povrsina" placeholder="unesite povrsinu" name="povrsina" onChange={this.handleChange}/>
                {submitted && !katalog.povrsina &&
                        <div className="help-block">Surface is required</div>
                    }
              </div>
              <div className={'form-group' + (submitted && !katalog.cijena ? ' has-error' : '')}>
                <label for="cijena">Cijena (KM): </label>
                <input type="text" class="form-control" id="cijena" placeholder="unesite cijenu" name="cijena" onChange={this.handleChange}/>
                {submitted && !katalog.cijena &&
                        <div className="help-block">Price of product is required</div>
                    }
              </div>
              <div className={'form-group' + (submitted && !katalog.datumObjave ? ' has-error' : '')}>
                <label for="datumObjave">Datum objave:</label>
                <input type="date" class="form-control" id="datumObjave" placeholder="odaberite aktuelni datum" name="datumObjave" onChange={this.handleChange}/>
                {submitted && !katalog.datumObjave &&
                        <div className="help-block">Date of publication is required</div>
                    }
              </div>
              <div className={'form-group' + (submitted && !katalog.datumZavrsetka ? ' has-error' : '')}>
                <label for="datumZavrsetka">Datum zavrsetka:</label>
                <input type="date" class="form-control" id="datumZavrsetka" placeholder="odaberite datum zavrsetka" name="datumZavrsetka" onChange={this.handleChange}/>
                {submitted && !katalog.datumZavrsetka &&
                        <div className="help-block">End date is required</div>
                    }
              </div>
              <div className="form-group">
                <button type="submit" className="btn btn-primary">Objavi</button>
                <Link to="/pocetna" className="btn btn-link">Cancel</Link>
              </div>
            </form>
        </div>
    )
  }
}



export default noviKatalog;