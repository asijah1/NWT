package com.projekat.Katalog.controller;


import java.util.List;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projekat.Katalog.model.Katalog;
import com.projekat.Katalog.service.KatalogService;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;

@CrossOrigin
@RequestMapping("/katalozi")
@RestController
public class katalogController {
	
	@Autowired
	private KatalogService katalogService;

	@GetMapping("/katalogSaId")
	public Katalog findById(@RequestParam Long id) throws Exception {
		return katalogService.findById(id);
	}
	
	
	@GetMapping("")
	public List<Katalog> getAllKatalozi() {
		return katalogService.vratiKataloge();
	}
	
	@GetMapping("/nazivProizvoda")
	public List<Katalog> getKatalogSaNazivom(@RequestParam String naziv) {
		return katalogService.vratiKatalogeSaNazivom(naziv);
	}
	
	@GetMapping("/pretragaProizvoda")
	public List<Katalog> pretragaKataloga(@RequestParam String naziv) {
		return katalogService.findByName(naziv);
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
