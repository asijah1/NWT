package com.projekat.Katalog.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.projekat.Katalog.model.Katalog;
import com.projekat.Katalog.model.Korisnik;
import com.projekat.Katalog.model.Ponuda;
import com.projekat.Katalog.service.KatalogService;


import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RequestMapping("/katalozi")
@RestController
public class katalogController {
	
	@Autowired
	private KatalogService katalogService;

	@Autowired
	private RestTemplate restTemplate;
	
	
	
	@GetMapping("/katalogSaId")
	public Katalog findById(@RequestParam Long id) throws Exception {
		return katalogService.findById(id);
	}
	
	@GetMapping("/dohvatiPonude") // sve ponude vezane za neki katalog
	public List<Ponuda> findByIdPonude(@RequestParam Long id) throws Exception {
		ResponseEntity<Ponuda[]> response = restTemplate.getForEntity("http://ponuda/ponude/katalogSaId?id=" + id, Ponuda[].class);
		Ponuda[] ponude = response.getBody();
		return Arrays.asList(ponude);
	}
	
	@GetMapping("/dohvatiKorisnike") //svi korisnici koji imaju aktivne ponude na katalogu
	public List<Korisnik> findByIdKataloge(@RequestParam Long id) throws Exception {
		ResponseEntity<Ponuda[]> response = restTemplate.getForEntity("http://localhost:8084/ponude/katalogSaId?id=" + id, Ponuda[].class);
		Ponuda[] ponude = response.getBody();
		return Arrays.asList(ponude).stream().map(ponuda ->{
			Korisnik k = restTemplate.getForObject("http://localhost:8084/korisnici/korisnikSaId?id=" + ponuda.getId(), Korisnik.class);
			return k;
		}).collect(Collectors.toList());
	}
	
	@GetMapping("")
	public List<Katalog> getAllKatalozi() {
		return katalogService.vratiKataloge();
	}
	/*
	@GetMapping("/id")
	public Katalog findById(@PathVariable Long id) {
		return katalogService.findById(id);
	}
	*/
	
	@PostMapping("")
    Katalog newKatalog(@Valid @RequestBody Katalog katalog) {
        //return katalogService.save(katalog);
		return katalogService.addNewKatalog(katalog);
    }
	
	@PutMapping("")
	Katalog replaceKatalog(@Valid @RequestBody Katalog katalog, @RequestParam Long id) {
		return katalogService.updateKatalog(katalog, id);
	}
	
    @DeleteMapping("")
    public void deleteKatalog(@RequestBody Katalog katalog) throws Exception {
        katalogService.deleteById(katalog.getId());
    }
    
}	
