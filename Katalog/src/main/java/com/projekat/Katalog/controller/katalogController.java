package com.projekat.Katalog.controller;



import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.projekat.Katalog.model.Katalog;
import com.projekat.Katalog.service.KatalogService;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RequestMapping("Katalog/katalogs")
@RestController
public class katalogController {
	
	@Autowired
	private KatalogService katalogService;

	
	@GetMapping("/id")
	public Katalog findById(@PathVariable Long id) {
		return katalogService.findById(id);
	}
	
	@PostMapping("/katalog")
    Katalog newKatalog(@RequestBody Katalog katalog) {
        //return katalogService.save(katalog);
		return katalogService.addNewKatalog(katalog.getNazivProizvoda(), katalog.getDodatneInformacije(), katalog.getCijena(), katalog.getDatumObjave(), 
				katalog.getDatumZavrsetka(), katalog.getPodkategorijaId(), katalog.getKorisnikId(), katalog.isZavrseno());
    }
	
    @DeleteMapping("/id")
    public void deleteKatalog(@PathVariable String id) {
        Long katalogId = Long.parseLong(id);
        katalogService.deleteById(katalogId);
    }
 
}	
