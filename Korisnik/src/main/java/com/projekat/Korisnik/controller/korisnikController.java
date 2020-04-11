package com.projekat.Korisnik.controller;

import com.projekat.Korisnik.model.Korisnik;
import com.projekat.Korisnik.service.KorisnikService;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
public class korisnikController {
	
	@Autowired
	private KorisnikService korisnikService;
	
	@RequestMapping(path = "/korisnici/ime", method = RequestMethod.GET)
	@ResponseBody
	public ArrayList<Korisnik> findByFirstName(@RequestParam String firstName) {  
		return korisnikService.findByFirstName(firstName);
	}
	
	@RequestMapping(path = "/korisnici/prezime", method = RequestMethod.GET)
	public ArrayList<Korisnik> findByLastName(@PathVariable String lastName) {
		//Long temp = Long.parseLong(lastName); //provjeriti poslije
		return korisnikService.findByLastName(lastName);
	}
	
	@RequestMapping(path = "/korisnici/id", method = RequestMethod.GET)
	public Korisnik findById(@PathVariable Long id) {
		return korisnikService.findById(id);
	}
	
	@PostMapping("")
    Korisnik newKorisnik(@RequestBody Korisnik korisnik) {
        //return korisnikService.save(korisnik);
		return korisnikService.createKorisnik(korisnik);
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