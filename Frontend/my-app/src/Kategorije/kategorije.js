import React, { Component } from 'react';
import {Link} from 'react-router-dom';

import './kategorije.css';

export class kategorije extends Component {
  render() {
    return (
        <div class="row">

            <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"></link>

            <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

            <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
            
        <div class="col-lg-4">
            <div class="panel-group" id="accordion">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4 class="panel-title">
                            <a data-toggle="collapse" data-parent="#accordion" href="#collapse1">
                                Vozila
                            </a>
                        </h4>
                    </div>
                    <div id="collapse1" class="panel-collapse collapse in">
                        <ul class="list-group">
                            <li class="list-group-item">Laka vozila</li>
                            <li class="list-group-item">Teretna vozila</li>
                            <li class="list-group-item">Dvotočkaši</li>
                            <li class="list-group-item">Ostalo</li>
                        </ul>
                    </div>
                </div>
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4 class="panel-title">
                            <a data-toggle="collapse" data-parent="#accordion" href="#collapse2">
                                Nekretnine
                            </a>
                        </h4>
                    </div>
                    <div id="collapse2" class="panel-collapse collapse">
                        <ul class="list-group">
                            <li class="list-group-item">Stanovi</li>
                            <li class="list-group-item">Kuće</li>
                            <li class="list-group-item">Zemljišta</li>
                            <li class="list-group-item">Ostalo</li>
                        </ul>
                    </div>
                </div>
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4 class="panel-title">
                            <a data-toggle="collapse" data-parent="#accordion" href="#collapse3">
                                Tehnika
                            </a>
                        </h4>
                    </div>
                    <div id="collapse3" class="panel-collapse collapse">
                        <ul class="list-group">
                            <li class="list-group-item">Bijela tehnika</li>
                            <li class="list-group-item">Računari</li>
                            <li class="list-group-item">Mobiteli</li>
                            <li class="list-group-item">Ostalo</li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>

        <div class="col-lg-8">
            
        </div>
    </div>
    )
  }
}



export default kategorije;
