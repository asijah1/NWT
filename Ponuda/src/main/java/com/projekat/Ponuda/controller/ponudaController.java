package com.projekat.Ponuda.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.projekat.Ponuda.Exception.PonudaException;
import com.projekat.Ponuda.model.Ponuda;
import com.projekat.Ponuda.service.PonudaService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RequestMapping("ponude")
@RestController
public class ponudaController {
	
	@Autowired
	private PonudaService ponudaService;

	
	@GetMapping("/ponudaSaId")
	public Ponuda findById(@RequestParam Long id) throws PonudaException {
		return ponudaService.findById(id);
	}
	
	@GetMapping("/katalogSaId")
	public List<Ponuda> findKatalogById(@RequestParam Long id) throws PonudaException {
		return ponudaService.findByKatalogId(id);
	}
	
	@GetMapping("")
	public List<Ponuda> vratiPonude() {
		return ponudaService.vratiPonude();
	}
	
	@PostMapping("")
    Ponuda newPonuda(@RequestBody Ponuda ponuda) {
        //return ponudaService.save(ponuda);
		return ponudaService.addNewPonuda(ponuda);
    }
	
	@PutMapping("")
	Ponuda replaceKatalog(@RequestBody Ponuda ponuda, @RequestParam Long id) {
		return ponudaService.updatePonuda(ponuda, id);
	}

    @DeleteMapping("")
    public void deletePonuda(@RequestBody Ponuda ponuda) throws PonudaException{
        ponudaService.deleteById(ponuda.getId());
    }
 
}	
