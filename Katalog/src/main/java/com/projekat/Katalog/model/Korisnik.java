package com.projekat.Katalog.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.validation.constraints.Email;

@Entity
@Table(name = "korisnik")
public class Korisnik {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    public void setId(Long id) {
		this.id = id;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
    
    private String firstName;
    private String lastName;
	
	@Size(min = 3, max = 50, message = "Location characters length has to be inbetween (3,50)")
    private String location;
    
    @Email(message = "Email should be valid")
    private String email;
    
    @Size(min = 9, max = 12, message = "Phone has to be 9-12 characters length")
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


    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Korisnik(String firstName, String lastName, String location, String email, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.setLocation(location);
        this.setEmail(email);
        this.setPhone(phone);
  }

  @Override
  public String toString() {
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