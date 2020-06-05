import React, { Component } from 'react';
import './kategorije.css';

export class kategorije extends Component {
  constructor(props){
    super(props);
    this.state = {
    open1: false,
    open2: false,
    open3: false
  }
  this.togglePanel1 = this.togglePanel1.bind(this);
  this.togglePanel2 = this.togglePanel2.bind(this);
  this.togglePanel3 = this.togglePanel3.bind(this);
  }
  togglePanel1(e){
    this.setState({open1: !this.state.open1})
  }
  togglePanel2(e){
    this.setState({open2: !this.state.open2})
  }
  togglePanel3(e){
    this.setState({open3: !this.state.open3})
  }
  
  render() {
    //var kategorije = ['Vozila', 'Nekretnine', 'Tehnika'];
    //var podkategorije = [["Teska vozila", "Laka vozila", "Dvotockasi", "Ostalo"], ["Stanovi", "Kuce", "Zemljiste", "Ostalo"], ["Bijela tehnika", "Racunari", "Mobiteli", "Ostalo"]]
    return (
      <div class="row">
        <div class="col-lg-4">
          <div class="panel-group" id="accordion">
            <div class="panel panel-default">
              <div class="panel-heading">
                <h4 class="panel-title">
                    <a data-toggle="collapse" data-parent="#accordion" onClick={(e)=>this.togglePanel1(e)}>
                        Vozila
                    </a>
                </h4>
              </div>
              {this.state.open1 ? (
                <div id="collapse1" class="panel-collapse collapse in">
                    <ul class="list-group">
                      <li class="list-group-item">Laka vozila</li>
                      <li class="list-group-item">Teretna vozila</li>
                      <li class="list-group-item">Dvotočkaši</li>
                      <li class="list-group-item">Ostalo</li>
                    </ul>
                </div>
              ) : null}
            </div>
          </div>

          <div class="panel-group" id="accordion">
            <div class="panel panel-default">
              <div class="panel-heading">
                <h4 class="panel-title">
                    <a data-toggle="collapse" data-parent="#accordion" onClick={(e)=>this.togglePanel2(e)}>
                        Nekretnine
                    </a>
                </h4>
              </div>
              {this.state.open2 ? (
                <div id="collapse1" class="panel-collapse collapse in">
                    <ul class="list-group">
                      <li class="list-group-item">Stanovi</li>
                      <li class="list-group-item">Kuće</li>
                      <li class="list-group-item">Zemljišta</li>
                      <li class="list-group-item">Ostalo</li>
                    </ul>
                </div>
              ) : null}
            </div>
          </div>

          <div class="panel-group" id="accordion">
            <div class="panel panel-default">
              <div class="panel-heading">
                <h4 class="panel-title">
                    <a data-toggle="collapse" data-parent="#accordion" onClick={(e)=>this.togglePanel3(e)}>
                        Tehnika
                    </a>
                </h4>
              </div>
              {this.state.open3 ? (
                <div id="collapse1" class="panel-collapse collapse in">
                    <ul class="list-group">
                      <li class="list-group-item">Bijela tehnika</li>
                      <li class="list-group-item">Računari</li>
                      <li class="list-group-item">Mobiteli</li>
                      <li class="list-group-item">Ostalo</li>
                    </ul>
                </div>
              ) : null}
            </div>
          </div>
        </div>
      </div> 
    )
  }
}



export default kategorije;