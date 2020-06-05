package com.projekat.Korisnik.service;

import com.projekat.Korisnik.exception.KorisnikException;
import com.projekat.Korisnik.model.Korisnik;
import com.projekat.Korisnik.service.KorisnikService;
import com.projekat.Korisnik.repository.KorisnikRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KorisnikService {
	
	@Autowired
	private KorisnikRepository korisnikRepository;
	List<Korisnik> bazaKorisnika;

	public Korisnik findById(Long id) throws KorisnikException{
		return korisnikRepository.findById(id).orElseThrow(() -> new KorisnikException(id));
	}
	
	public List<Korisnik> vratiKorisnike() throws KorisnikException {
        if (korisnikRepository.count() == 0) {
            throw new KorisnikException("Nema korisnika u bazi", 1);
        }
        List<Korisnik> bazaKorisnika = new ArrayList<>();
        korisnikRepository.findAll().forEach(bazaKorisnika::add);
        return bazaKorisnika;
    }

	public Korisnik findByFirstName(String firstName) throws KorisnikException{
		bazaKorisnika = vratiKorisnike();
		List<Korisnik> temp;
        for (Korisnik korisnik : bazaKorisnika) {
            if (korisnik.getFirstName() != null && korisnik.getFirstName().equals(firstName)) {
                return korisnik;
            }
        }
        throw new KorisnikException("Traženi korisnik ne postoji");
	}
	public Korisnik findByLastName(String lastName) throws KorisnikException{
		bazaKorisnika = vratiKorisnike();
        for (Korisnik korisnik : bazaKorisnika) {
            if (korisnik.getLastName() != null && korisnik.getLastName().equals(lastName)) {
                return korisnik;
            }
        }
        throw new KorisnikException("Traženi korisnik ne postoji");
	}
	
	public Korisnik createKorisnik(Korisnik korisnik){
        return korisnikRepository.save(new Korisnik(korisnik.getFirstName(), korisnik.getLastName(), korisnik.getLocation(), korisnik.getEmail(), korisnik.getPhone()));
    }
	/*
	public Korisnik save(Korisnik novi) {
		return korisnikRepository.save(new Korisnik("Amir", "Sijah", "Travnik", "amir.sijah@gmail.com", "06108044"));
	}
	 */
	
	public Korisnik updateKorisnik(Korisnik novioKrisnik, Long id) {
		return korisnikRepository.findById(id).map(korisnik -> {
			korisnik.setEmail(novioKrisnik.getEmail());
			korisnik.setFirstName(novioKrisnik.getFirstName());
			korisnik.setLastName(novioKrisnik.getLastName());
			korisnik.setLocation(novioKrisnik.getLocation());
			korisnik.setPhone(novioKrisnik.getPhone());
			return korisnikRepository.save(korisnik);
	      })
	      .orElseGet(() -> {
	        return korisnikRepository.save(novioKrisnik);
	      });
	}
	
	public Korisnik deleteKorisnikWithId(Long korisnikId) throws KorisnikException{
		if (!korisnikRepository.existsById(korisnikId)) {
            throw new KorisnikException("Traženi korisnik ne postoji");
        }
		Korisnik temp = korisnikRepository.findById(korisnikId).orElseThrow();
        korisnikRepository.deleteById(korisnikId);
        return temp;
    }

	public List<Korisnik> findByName(String name) {
		List<Korisnik> bazaKorisnika = new ArrayList<>();
        korisnikRepository.findAll().forEach((korisnik) -> {
        	boolean isFoundIme = korisnik.getFirstName().indexOf(name) !=-1? true: false;
        	boolean isFoundprezime = korisnik.getLastName().indexOf(name) !=-1? true: false;
        	if(isFoundIme || isFoundprezime)
        		bazaKorisnika.add(korisnik);
        });
        
        return bazaKorisnika;
	}
	
}

