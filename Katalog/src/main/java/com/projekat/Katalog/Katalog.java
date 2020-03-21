package com.projekat.Katalog;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Katalog {

@Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Long id;
  private String nazivProizvoda;
  private String dodatneInformacije;
  private int cijena;
  private Date datumObjave; //ovaj tip podatka sadrži i vrijeme i datum
  private Date datumZavrsetka; //analogno prethodnom
  private Long podkategorijaId;
  private Long korisnikId;
  private boolean zavrseno;

  protected Katalog() {}
	
  public Katalog( String nazivProizvoda, String dodatneInformacije, int cijena, Date datumObjave,
			Date datumZavrsetka, Long podkategorijaId, Long korisnikId, boolean zavrseno) {
		super();
		this.nazivProizvoda = nazivProizvoda;
		this.dodatneInformacije = dodatneInformacije;
		this.cijena = cijena;
		this.datumObjave = datumObjave;
		this.datumZavrsetka = datumZavrsetka;
		this.podkategorijaId = podkategorijaId;
		this.korisnikId = korisnikId;
		this.zavrseno = zavrseno;
	}

@Override
	public String toString() {
		return "Katalog [id=" + id + ", nazivProizvoda=" + nazivProizvoda + ", dodatneInformacije=" + dodatneInformacije
				+ ", cijena=" + cijena + ", datumObjave=" + datumObjave + ", datumZavrsetka=" + datumZavrsetka
				+ ", podkategorijaId=" + podkategorijaId + ", korisnikId=" + korisnikId + ", zavrseno=" + zavrseno
				+ "]";
	}

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
	
	public void setZavrseno(boolean zavrseno) {
		this.zavrseno = zavrseno;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
}