package com.projekat.Korisnik.controller;

import com.projekat.Korisnik.model.Korisnik;
import com.projekat.Korisnik.service.KorisnikService;

import java.util.List;

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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/korisnici")
public class korisnikController {
	
	@Autowired
	private KorisnikService korisnikService;
	
	@RequestMapping(value = "id", method = RequestMethod.GET)
	@ResponseBody
	public Korisnik vratiKorisnika(@RequestParam String id) {
		Long korisnikId = Long.parseLong(id);
		return korisnikService.findById(korisnikId);
	}
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	@ResponseBody
	public List<Korisnik> vratiSveKorisnike() {  
		return korisnikService.vratiKorisnike();
	}
	
	@RequestMapping(value = "/ime", method = RequestMethod.GET)
	@ResponseBody
	public Korisnik findByFirstName(@RequestParam String firstName) {  
		return korisnikService.findByFirstName(firstName);
	}
	
	
	@RequestMapping(value = "/prezime", method = RequestMethod.GET)
	@ResponseBody
	public Korisnik findByLastName(@RequestParam String lastName) {
		//Long temp = Long.parseLong(lastName); //provjeriti poslije
		return korisnikService.findByLastName(lastName);
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
	
	@RequestMapping(value = "/id", method = RequestMethod.DELETE)
    public void deleteKorisnik(@PathVariable String id) {
        Long korisnikId = Long.parseLong(id);
        korisnikService.deleteKorisnikWithId(korisnikId);
    }
 
}	