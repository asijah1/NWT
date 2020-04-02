package com.projekat.Korisnik.service;

import com.projekat.Korisnik.model.Korisnik;
import com.projekat.Korisnik.service.KorisnikService;
import com.projekat.Korisnik.repository.KorisnikRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KorisnikService {
	
	@Autowired
	private KorisnikRepository korisnikRepository;

	public Korisnik findById(Long id) {
		return korisnikRepository.findById(id).orElseThrow();
	}

	public ArrayList<Korisnik> findByFirstName(String firstName) {
		return korisnikRepository.findByFirstName(firstName);
	}
	public ArrayList<Korisnik> findByLastName(String lastName) {
		return korisnikRepository.findByLastName(lastName);
	}
	
	public Korisnik createKorisnik(String firstName, String lastName, String location, String email, String phone){
        return korisnikRepository.save(new Korisnik(firstName, lastName, location, email, phone));
    }
	/*
	public Korisnik save(Korisnik novi) {
		return korisnikRepository.save(new Korisnik("Amir", "Sijah", "Travnik", "amir.sijah@gmail.com", "06108044"));
	}
	 */
	
	public Korisnik updateKorisnik(Korisnik korisnik, Long id) {
		//Long temp = Long.parseLong(id);
		korisnikRepository.findById(id).orElseThrow(); //ako ne pronadje korisnika sa datim id-em bacit će izuzetak
		return korisnikRepository.save(korisnik);
	}
	
	public void deleteById(Long korisnikId) {
        korisnikRepository.deleteById(korisnikId);
    }
	
}

