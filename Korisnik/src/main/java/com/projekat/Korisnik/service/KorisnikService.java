package com.projekat.Korisnik.service;

import com.projekat.Korisnik.model.Korisnik;
import com.projekat.Korisnik.service.KorisnikService;
import com.projekat.Korisnik.repository.KorisnikRepository;

import java.util.ArrayList;
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
	
	public Korisnik createKorisnik(Korisnik korisnik){
        return korisnikRepository.save(new Korisnik(korisnik.getFirstName(), korisnik.getLastName(), korisnik.getLocation(), korisnik.getEmail(), korisnik.getPhone()));
    }
	/*
	public Korisnik save(Korisnik novi) {
		return korisnikRepository.save(new Korisnik("Amir", "Sijah", "Travnik", "amir.sijah@gmail.com", "06108044"));
	}
	 */
	
	public Korisnik updateKorisnik(Korisnik korisnik) {
		//Long temp = Long.parseLong(id);
		//korisnikRepository.findById(id).orElseThrow(); //ako ne pronadje korisnika sa datim id-em bacit će izuzetak
		return korisnikRepository.save(korisnik);
	}
	
	public void deleteById(Long korisnikId) {
        korisnikRepository.deleteById(korisnikId);
    }
	
}

