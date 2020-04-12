package com.projekat.Katalog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.projekat.Katalog.model.Katalog;
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
	
	
	@GetMapping("/katalogSaId")
	public Katalog findById(@RequestParam Long id) throws Exception {
		return katalogService.findById(id);
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
    Katalog newKatalog(@RequestBody Katalog katalog, @PathVariable Long id) {
        //return katalogService.save(katalog);
		return katalogService.addNewKatalog(katalog);
    }
	
	@PutMapping("/id")
	Katalog replaceKatalog(@RequestBody Katalog katalog, @PathVariable Long id) {
		return katalogService.updateKatalog(katalog);
	}
	
    @DeleteMapping("/id")
    public void deleteKatalog(@PathVariable Long katalogSaId) throws Exception {
        //Long katalogId = Long.parseLong(id);
        katalogService.deleteById(katalogSaId);
    }
 
}	
