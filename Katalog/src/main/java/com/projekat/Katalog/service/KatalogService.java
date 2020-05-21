package com.projekat.Katalog.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projekat.Katalog.exception.KatalogException;
import com.projekat.Katalog.model.Katalog;
import com.projekat.Katalog.repository.KatalogRepository;

@Service
public class KatalogService {
	
	@Autowired
	private KatalogRepository katalogRepository;
	
	private RabbitTemplate rabbitTemplate; 

	public List<Katalog> vratiKataloge()  {
        List<Katalog> bazaKataloga = new ArrayList<>();
        katalogRepository.findAll().forEach(bazaKataloga::add);
        return bazaKataloga;
    }
	
	public Katalog findById(Long katalogId) throws Exception {
		if(!katalogRepository.existsById(katalogId)) {
			throw new EntityNotFoundException("Trazeni katalog ne postoji");
		}
		return katalogRepository.findById(katalogId).orElseThrow();
	}
	
	public Katalog createKatalog(String nazivProizvoda, String dodatneInformacije, int cijena, Date datumObjave, 
			Date datumZavrsetka, Long podkategorijaId, Long korisnikId, boolean zavrseno){
        return katalogRepository.save(new Katalog(nazivProizvoda, dodatneInformacije, cijena, datumObjave, datumZavrsetka, podkategorijaId, korisnikId, zavrseno));
    }
	
	public Katalog addNewKatalog(Katalog katalog) {
		return katalogRepository.save(new Katalog(katalog.getNazivProizvoda(), katalog.getDodatneInformacije(), katalog.getCijena(), katalog.getDatumObjave(), katalog.getDatumZavrsetka(), katalog.getPodkategorijaId(), katalog.getKorisnikId(), katalog.isZavrseno()));
	}
	
	public Katalog updateKatalog(Katalog noviKatalog, Long id) {
		return katalogRepository.findById(id).map(katalog -> {
	        katalog.setCijena(noviKatalog.getCijena());
	        katalog.setDatumObjave(noviKatalog.getDatumObjave());
	        katalog.setDatumZavrsetka(noviKatalog.getDatumZavrsetka());
	        katalog.setDodatneInformacije(noviKatalog.getDodatneInformacije());
	        katalog.setNazivProizvoda(noviKatalog.getNazivProizvoda());
	        katalog.setKorisnikId(noviKatalog.getKorisnikId());
	        katalog.setPodkategorijaId(noviKatalog.getPodkategorijaId());
	        katalog.setZavrseno(noviKatalog.getZavrseno());
	        return katalogRepository.save(katalog);
	      })
	      .orElseGet(() -> {
	        return katalogRepository.save(noviKatalog);
	      });
	}
	
	public String deleteById(Long katalogId) throws Exception {
		if(!katalogRepository.existsById(katalogId)) {
			throw new EntityNotFoundException("Trazeni katalog ne postoji");
		}
        katalogRepository.deleteById(katalogId);
        return "Katalog obrisan";
    }
	
	public void sendKatalogId(String idKataloga, String cijena, String idKorisnika) {
		Map<String, String> actionmap = new HashMap<>();
		actionmap.put("idKataloga", idKataloga);
		actionmap.put("cijena", cijena);
		actionmap.put("idKorisnika", idKorisnika);
		rabbitTemplate.convertAndSend("sfg-message-queue", actionmap);
	}
	
}