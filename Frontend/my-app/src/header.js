import React from 'react'
import {Link, Redirect} from 'react-router-dom'

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
            
                <div className="Sve">
                    <div style={{backgroundColor: "#00203f", paddingTop:"5px", paddingBottom:"5px", textAlign:"center" }}>
                        {timovi.map(t => <div style={{display: "inline"}}> <Link style={{color: "#adefd1"}} to={`/${t}`}> {t} </Link> </div>)}
                        {this.JeLiLogiran()}
                    </div>
                </div>
    
            )
        }
        return null;
        
    }
}