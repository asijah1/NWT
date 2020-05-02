package com.example.systemevents;

import java.util.Date;

public class Akcija {
	
	enum TipOdgovora {
		USPJESNA,
		GRESKA
	}
	
	enum TipAkcije {
		GET,
		UPDATE,
		CREATE,
		DELETE
	};
	
	private Date timestampAkcije;
	private String mikroservis;
	private String korisnik;
	private TipAkcije akcija;
	private String resurs;
	private TipOdgovora odgovor;
	
	
	public Akcija(Date timestampAkcije, String mikroservis, String korisnik, TipAkcije akcija, String resurs,
			TipOdgovora odgovor) {
		super();
		this.timestampAkcije = timestampAkcije;
		this.mikroservis = mikroservis;
		this.korisnik = korisnik;
		this.akcija = akcija;
		this.resurs = resurs;
		this.odgovor = odgovor;
	}
	
	
	public Date getTimestampAkcije() {
		return timestampAkcije;
	}
	public void setTimestampAkcije(Date timestampAkcije) {
		this.timestampAkcije = timestampAkcije;
	}
	
	
	public String getMikroservis() {
		return mikroservis;
	}
	public void setMikroservis(String mikroservis) {
		this.mikroservis = mikroservis;
	}
	
	
	public String getKorisnik() {
		return korisnik;
	}
	public void setKorisnik(String korisnik) {
		this.korisnik = korisnik;
	}
	
	
	public TipAkcije getAkcija() {
		return akcija;
	}
	public void setAkcija(TipAkcije akcija) {
		this.akcija = akcija;
	}
	
	
	public String getResurs() {
		return resurs;
	}
	public void setResurs(String resurs) {
		this.resurs = resurs;
	}
	
	
	public TipOdgovora getOdgovor() {
		return odgovor;
	}
	public void setOdgovor(TipOdgovora odgovor) {
		this.odgovor = odgovor;
	}
	
}
