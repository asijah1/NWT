import React, { Component } from 'react';
//import './noviKatalog.css';

export class noviKatalog extends Component {
  render() {
    return (
      	<div class="container">
			<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"></link>
          	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
          	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
          	<h2>Objavi katalog</h2>
            <form>
                <div class="form-group">
                    <label for="lokacija">Lokacija: </label>
                    <select class="form-control">
						<option value="Travnik">Travnik</option>
						<option value="Sarajevo">Sarajevo</option>
						<option selected value="Visoko">Visoko</option>
						<option value="Kakanj">Kakanj</option>
					</select>
                </div>
				<div class="form-group">
					<label for="povrsina">Povrsina (m^2): </label>
                  <input type="text" class="form-control" id="povrsina" placeholder="Enter povrsina" name="povrsina" onChange={this.onChange}/>
				</div>
				<div class="form-group">
					<label for="cijena">Cijena (KM): </label>
                  <input type="text" class="form-control" id="cijena" placeholder="Enter cijena" name="cijena" onChange={this.onChange}/>
				</div>
            </form>
			<button type="button" class="btn btn-default">Objavi</button>
        </div>
    )
  }
}



export default noviKatalog;