package com.projekat.Katalog.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
//potrebne za validaciju
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Entity
@Table(name = "katalog")
public class Katalog {

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Long id;
  @NotNull(message = "Unesite naziv proizvoda")
  @Size(min = 3, max = 50, message = "Naziv characters length has to be inbetween (3,50)")
  private String nazivProizvoda;
  //dodatne informacije nisu obavezne
  private String dodatneInformacije;
  @NotNull(message = "Unesite cijenu")
  @Positive(message = "Unesite novu vrijednost cijene")
  private int cijena;
  @PastOrPresent(message = "Neispravan datum objave")
  private Date datumObjave; //ovaj tip podatka sadrži i vrijeme i datum
  @PastOrPresent(message = "Neispravan datum završetka")
  private Date datumZavrsetka; //analogno prethodnom
  //
  private Long podkategorijaId;
  //
  
  
  private Long korisnikId;
  //malo kompleksniji provjera, zavisi da li je aukcija završila ili ne
  private boolean zavrseno;

  //geteri i seteri

  public String getNazivProizvoda() {
	return nazivProizvoda;
 }

public void setNazivProizvoda(String nazivProizvoda) {
	this.nazivProizvoda = nazivProizvoda;
}

public String getDodatneInformacije() {
	return dodatneInformacije;
}

public void setDodatneInformacije(String dodatneInformacije) {
	this.dodatneInformacije = dodatneInformacije;
}

public int getCijena() {
	return cijena;
}

public void setCijena(int cijena) {
	this.cijena = cijena;
}

public Date getDatumObjave() {
	return datumObjave;
}

public void setDatumObjave(Date datumObjave) {
	this.datumObjave = datumObjave;
}

public Date getDatumZavrsetka() {
	return datumZavrsetka;
}

public void setDatumZavrsetka(Date datumZavrsetka) {
	this.datumZavrsetka = datumZavrsetka;
}

public Long getPodkategorijaId() {
	return podkategorijaId;
}

public void setPodkategorijaId(Long podkategorija_id) {
	this.podkategorijaId = podkategorija_id;
}

public Long getKorisnikId() {
	return korisnikId;
}

public void setKorisnikId(Long korisnik_id) {
	this.korisnikId = korisnik_id;
}

public boolean isZavrseno() {
	return zavrseno;
}

public boolean getZavrseno() {
	return this.zavrseno;
}

public void setZavrseno(boolean zavrseno) {
	this.zavrseno = zavrseno;
}
//ovo nam nije potrebno
/*
public void setId(Long id) {
	this.id = id;
}
*/

public Long getId() {
	return id;
}

  protected Katalog() {}
	
  public Katalog(String nazivProizvoda, String dodatneInformacije, int cijena, Date datumObjave,
			Date datumZavrsetka, Long podkategorijaId, Long korisnikId, boolean zavrseno) {
		//super();
		setNazivProizvoda(nazivProizvoda);
		setDodatneInformacije(dodatneInformacije);
		setCijena(cijena);
		setDatumObjave(datumObjave);
		setDatumZavrsetka(datumZavrsetka);
		setPodkategorijaId(podkategorijaId);
		setKorisnikId(korisnikId);
		setZavrseno(zavrseno);
	}

@Override
	public String toString() {
		return "Katalog [id=" + id + ", nazivProizvoda=" + nazivProizvoda + ", dodatneInformacije=" + dodatneInformacije
				+ ", cijena=" + cijena + ", datumObjave=" + datumObjave + ", datumZavrsetka=" + datumZavrsetka
				+ ", podkategorijaId=" + podkategorijaId + ", korisnikId=" + korisnikId + ", zavrseno=" + zavrseno
				+ "]";
	}



}