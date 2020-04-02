package com.projekat.Korisnik.controller;

import com.projekat.Korisnik.model.Korisnik;
import com.projekat.Korisnik.service.KorisnikService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RequestMapping("korisnici")
@RestController
public class korisnikController {
	
	@Autowired
	private KorisnikService korisnikService;
	
	@GetMapping("/firstName")
	public ArrayList<Korisnik> findByFirstName(@PathVariable String firstName) {  
		return korisnikService.findByFirstName(firstName);
	}
	
	@GetMapping("/lastName")
	public ArrayList<Korisnik> findByLastName(@PathVariable String lastName) {
		//Long temp = Long.parseLong(lastName); //provjeriti poslije
		return korisnikService.findByLastName(lastName);
	}
	
	@GetMapping("/id")
	public Korisnik findById(@PathVariable Long id) {
		return korisnikService.findById(id);
	}
	
	@PostMapping("/korisnik")
    Korisnik newKorisnik(@RequestBody Korisnik korisnik) {
        //return korisnikService.save(korisnik);
		return korisnikService.createKorisnik(korisnik.getFirstName(), korisnik.getLastName(), korisnik.getLocation(), korisnik.getEmail(), korisnik.getPhone());
    }
	
	@PutMapping("/id")
	Korisnik replaceKorisnik(@RequestBody Korisnik korisnik, @PathVariable Long id) {
		return korisnikService.updateKorisnik(korisnik);
	}

    @DeleteMapping("/id")
    public void deleteKorisnik(@PathVariable String id) {
        Long korisnikId = Long.parseLong(id);
        korisnikService.deleteById(korisnikId);
    }
 
}	