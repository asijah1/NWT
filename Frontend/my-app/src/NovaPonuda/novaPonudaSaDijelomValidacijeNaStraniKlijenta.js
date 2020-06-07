import React, { Component } from 'react';
import { Link } from 'react-router-dom';
//import './novaPonuda.css';

const ponudaAPI = "http://localhost:8083/ponude"

export class novaPonuda extends Component {

  constructor(props) {
    super(props);

    this.state = {
        ponuda: {
            ponuda: ''
        },
        submitted: false
    };

    this.handleChange = this.handleChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
}

handleChange(event) {
    const { name, value } = event.target;
    const { ponuda } = this.state;
    this.setState({
        ponuda: {
            ...ponuda,
            [name]: value
        }
    });
}

handleSubmit(event) {
    event.preventDefault();

    this.setState({ submitted: true });
    const { ponuda } = this.state;

    const text = {
      ponuda: this.state.ponuda
  }
  
  console.log(JSON.stringify(text));

    if (ponuda.ponuda) {
        //ovdje ide dio sa rgistracijom kataloga
        var xhr = new XMLHttpRequest();
        xhr.open('POST', ponudaAPI);
        xhr.setRequestHeader('Content-Type', 'application/json; charset=UTF-8');
        xhr.send(JSON.stringify(text));
    }

}

  render() {
    const { ponuda, submitted } = this.state;
    return (
        <div class="container">
		      <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"></link>
          <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
          <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
          <h2>Napravi ponudu</h2>
          <form name="form" onSubmit={this.handleSubmit}>
            <div class="form-group">
              <label for="lokacija">Aktuelna cijena: </label>
              <input type="text" class="form-control" id="aktuelnaCijena" placeholder="80 000" name="aktuelnaCijena"/>
            </div>
				    <div className={'form-group' + (submitted && !ponuda.ponuda ? ' has-error' : '')}>
					    <label for="ponuda">Ponudi: </label>
              <input type="text" class="form-control" id="ponuda" placeholder="unesite svoju ponudu" name="ponuda" onChange={this.handleChange}/>
              {submitted && !ponuda.ponuda &&
                <div className="help-block">Ponuda is required</div>
              }
				    </div>
            <div className="form-group">
                <button type="submit" className="btn btn-primary">Ponudi</button>
                <Link to="/pocetna" className="btn btn-link">Cancel</Link>
              </div>
          </form>
        </div>
    )
  }
}



export default novaPonuda;