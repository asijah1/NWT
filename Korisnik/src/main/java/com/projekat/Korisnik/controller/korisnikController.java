package com.projekat.Korisnik.controller;

import com.projekat.Korisnik.model.Korisnik;
import com.projekat.Korisnik.rabbitMQ.ProducerService;
import com.projekat.Korisnik.service.KorisnikService;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;

@CrossOrigin
@RestController
@RequestMapping("/korisnici")
public class korisnikController {
	
	@Autowired
	private KorisnikService korisnikService;
	
	@Autowired
    ProducerService producerService;
	
	@RequestMapping(value = "id", method = RequestMethod.GET)
	@ResponseBody
	public Korisnik vratiKorisnika(@RequestParam String id) {
		Long korisnikId = Long.parseLong(id);
		return korisnikService.findById(korisnikId);
	}
	
	@RequestMapping(value = "/korisnikSaId", method = RequestMethod.GET)
	public Korisnik findByLastName(@RequestParam Long id) {
		//Long temp = Long.parseLong(lastName); //provjeriti poslije
		return korisnikService.findById(id);
	}
	
	@RequestMapping(value = "/email", method = RequestMethod.GET)
	public Korisnik findByEmail(@RequestParam String email) {
		//Long temp = Long.parseLong(lastName); //provjeriti poslije
		return korisnikService.findByEmail(email);
	}
	
	@RequestMapping(value = "/korisnikSaNazivom", method = RequestMethod.GET)
	public List<Korisnik> findByName(@RequestParam String name) {
		//Long temp = Long.parseLong(lastName); //provjeriti poslije
		return korisnikService.findByName(name);
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
    Korisnik newKorisnik(@Valid @RequestBody Korisnik korisnik) {
        //return korisnikService.save(korisnik);
		return korisnikService.createKorisnik(korisnik);
    }
	
	@PostMapping("/logovanje")
    Korisnik logovanje(@RequestBody String ime, @RequestBody String sifra) {
        //return korisnikService.save(korisnik);
		Korisnik k = korisnikService.findByFirstName(ime);
		if(k.getPassword() == sifra)
			return k;
		return null;
    }
	
	@PutMapping("")
	Korisnik replaceKorisnik(@Valid @RequestBody Korisnik korisnik, @RequestParam Long id) {
		return korisnikService.updateKorisnik(korisnik, id);
	}
	
	@RequestMapping(value = "", method = RequestMethod.DELETE)
    public void deleteKorisnik(@Valid @RequestBody Korisnik korisnik) {
        korisnikService.deleteKorisnikWithId(korisnik.getId());
        producerService.send(korisnik.getId());
    }
 
}	