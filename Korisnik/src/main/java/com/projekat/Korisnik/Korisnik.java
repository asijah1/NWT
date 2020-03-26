package com.projekat.Korisnik;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Korisnik {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    //ovo nam ne treba, stringboot će ga automatski generirati i postaviti 
    /*public void setId(Long id) { 
		this.id = id;
	}
    */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
    
    private String firstName;
    private String lastName;
    private String location;
    private Date birthDate;
    private String email;
    private String phone;

    protected Korisnik() {
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Korisnik(String firstName, String lastName, String location, String email, String phone) {
        setFirstName(firstName);
        setLastName(lastName);
        setLocation(location);
        setEmail(email);
        setPhone(phone);

  }

  @Override
  public String toString() {
      //treba dodati datum
      return String.format("Customer[id=%d, firstName='%s', lastName='%s', location='%s', email='%s', phone='%s']", id, firstName, lastName, location, email, phone);
  }

  public Long getId() {
      return id;
  }

  public String getFirstName() {
      return firstName;
  }

  public String getLastName() {
      return lastName;
  }
}