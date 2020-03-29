package com.projekat.Ponuda.controller;

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

import com.projekat.Ponuda.model.Ponuda;
import com.projekat.Ponuda.service.PonudaService;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RequestMapping("Korisnik/korisniks")
@RestController
public class ponudaController {
	
	@Autowired
	private PonudaService ponudaService;

	
	@GetMapping("/id")
	public Ponuda findById(@PathVariable Long id) {
		return ponudaService.findById(id);
	}
	
	@PostMapping("/ponuda")
    Ponuda newPonuda(@RequestBody Ponuda ponuda) {
        //return ponudaService.save(ponuda);
		return ponudaService.addNewPonuda(ponuda.getidKatalog(), ponuda.getidKorisnik(), ponuda.getPonuda());
    }
	

    @DeleteMapping("/id")
    public void deletePonuda(@PathVariable String id) {
        Long ponudaId = Long.parseLong(id);
        ponudaService.deleteById(ponudaId);
    }
 
}	
