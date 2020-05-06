package com.Projekat.APIGateway.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;


@Entity
@Table(name = "ponuda")
public class Ponuda {

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Long id;
  private Long idKatalog;
  private Long idKorisnik;
  //@NotNull(message = "Unesite ponudu")
  @Min(value = 0, message = "Ponuda mora biti veća od aktuelne") //poslije doraditi tako da umjesto "0" bude aktuelna ponuda
  private Long ponuda;

  //seteri
  public void setIdKatalog(Long idKatalog) {
    this.idKatalog = idKatalog;
  }
 
  public void setIdKorisnik(Long idKorisnik) {
    this.idKorisnik = idKorisnik;
  }
  
  public void setPonuda(Long ponuda) {
    this.ponuda = ponuda;
  }


  protected Ponuda() {}

  public Ponuda(Long idKatalog, Long idKorisnik, Long ponuda) {
    setIdKatalog(idKatalog);
    setIdKorisnik(idKorisnik);
    setPonuda(ponuda);
  }

  @Override
  public String toString() {
    return String.format(
        "Customer[id=%d, idKatalog=%d, idKorisnik=%d, ponuda=%d]",
        id, idKatalog, idKorisnik, ponuda);
  }

  //geteri
  public Long getId() {
    return id;
  }

  public Long getidKatalog() {
    return idKatalog;
  }

  public Long getidKorisnik() {
    return idKorisnik;
  }
  
  public Long getPonuda() {
	    return ponuda;
	  }
}