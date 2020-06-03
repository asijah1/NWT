import React from 'react'
import {Link, NavLink} from 'react-router-dom'

export default class App extends React.Component {

    Odjavi = (e) => {
        localStorage.removeItem("token");
        localStorage.removeItem("username");
        localStorage.removeItem("id");
        
       
        window.location.reload();
    }

    PrikaziLog = (e) => {
        this.refs.modal.show()
    }

    PrikaziHeader() {
        var logiran = localStorage.getItem("token");
        if((window.location.pathname.includes("login") || window.location.pathname.includes("Login")) && logiran == null) {
            return false;
        }
        return true;
    }

    JeLiLogiran() {
        var logiran = localStorage.getItem("token");
        if(logiran) return ([
            <div style={{marginLeft:"1%", display:"inline", width:"50px" }} className="dugmad">
            <button type="button" className="btn btn-primary" onClick={this.PrikaziLog} >Prikazi log</button>
            <button type="button" className="btn btn-primary" data-placement="right" margin-left="70%" text-align="center" onClick={this.Odjavi} >Odjavi se</button>
            </div>
        ]);
        return;
    }

    render() {

        let timovi = ["Kategorije", "Shopovi", "Vozila", "Nekretnine"];

        if(this.PrikaziHeader()) {
            return (
            
                
                <nav class="navbar navbar-default">
                    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"></link>
                    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
                    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
                    <div class="container-fluid">
                        <div class="navbar-header">
                            <a class="navbar-brand" href="#">Dobro došli!</a>
                        </div>
                        <ul class="nav navbar-nav">
                            <li class="active"><NavLink to="/pocetna">Početna</NavLink></li>
                            <li><a>Moje ponude</a></li>
                            <li><a>Moji katalozi</a></li>
                        </ul>
                    </div>
                </nav>
    
            )
        }
        return null;
        
    }
}