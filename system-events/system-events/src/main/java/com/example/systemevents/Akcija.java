package com.example.systemevents;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.systemevents.SystemEventsOuterClass.Request.tipAkcije;
import com.google.protobuf.Timestamp;

@Entity
@Table(name = "akcija")
public class Akcija {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
    private String timestamp;
    private String nazivMikroservisa;
    enum TipAkcije {
		GET,
		UPDATE,
		CREATE,
		DELETE
	};
    private tipAkcije tipAkcije;
    private String nazivResursa;
    
    public Akcija() {}
    
    public Akcija(Timestamp timestamp, String nazivMikroservisa, tipAkcije tipAkcije, String nazivResursa) {
    	
    	this.setTimestamp(timestamp.toString());
    	this.setNazivMikroservisa(nazivMikroservisa);
    	this.setTipAkcije(tipAkcije);
    	this.setNazivResursa(nazivResursa);
    	
    }
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public tipAkcije getTipAkcije() {
		return tipAkcije;
	}
	public void setTipAkcije(tipAkcije tipAkcije) {
		this.tipAkcije = tipAkcije;
	}
	public String getNazivMikroservisa() {
		return nazivMikroservisa;
	}
	public void setNazivMikroservisa(String nazivMikroservisa) {
		this.nazivMikroservisa = nazivMikroservisa;
	}
	public String getNazivResursa() {
		return nazivResursa;
	}
	public void setNazivResursa(String nazivResursa) {
		this.nazivResursa = nazivResursa;
	}
	
	@Override
	public String toString() {
		return "Event(" + 
				"id: " + id +
				", timestamp: " + timestamp +
				", tipAkcije: " + tipAkcije +
				", nazivMikroserivsa: " + nazivMikroservisa +
				", nazivResursa: " + nazivResursa + 
				")";
	}
	
}
