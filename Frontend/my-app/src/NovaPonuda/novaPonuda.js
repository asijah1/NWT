import React, { Component } from 'react';
//import './novaPonuda.css';

export class novaPonuda extends Component {
  render() {
    return (
        <div class="container">
		    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"></link>
          	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
          	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
          	<h2>Napravi ponudu</h2>
            <form>
                <div class="form-group">
                    <label for="lokacija">Aktuelna cijena: </label>
                    <input type="text" class="form-control" id="aktuelnaCijena" placeholder="80 000" name="aktuelnaCijena" onChange={this.onChange}/>
                </div>
				<div class="form-group">
					<label for="povrsina">Ponudi: </label>
                  <input type="text" class="form-control" id="ponuda" placeholder="unesite svoju ponudu" name="ponuda" onChange={this.onChange}/>
				</div>
            </form>
			<button type="button" class="btn btn-default">Ponudi</button>
        </div>
    )
  }
}



export default novaPonuda;