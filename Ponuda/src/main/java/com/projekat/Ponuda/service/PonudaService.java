package com.projekat.Ponuda.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.projekat.Ponuda.Exception.PonudaException;
import com.projekat.Ponuda.model.Ponuda;
import com.projekat.Ponuda.repository.PonudaRepository;

@Service
public class PonudaService {
	
	@Autowired
	private PonudaRepository ponudaRepository;
	List<Ponuda> bazaPonuda;

	public Ponuda findById(Long id) throws PonudaException{
		return ponudaRepository.findById(id).orElseThrow(()->new PonudaException());
	}
	public List<Ponuda> findByKatalogId(Long id) throws PonudaException{
		return ponudaRepository.findByIdKatalog(id);
	}
	
	public List<Ponuda> vratiPonude()  throws PonudaException{
        List<Ponuda> bazaPonuda = new ArrayList<>();
        if(ponudaRepository.count() == 0)
        	throw new PonudaException("izuzetak");
        ponudaRepository.findAll().forEach(bazaPonuda::add);
        return bazaPonuda;
    }
	
	public Ponuda createPonuda(Long idKatalog, Long idKorisnik, Long ponuda){
        return ponudaRepository.save(new Ponuda(idKatalog, idKorisnik, ponuda));
    }
	
	public Ponuda addNewPonuda(Ponuda ponuda) {
		return ponudaRepository.save(new Ponuda(ponuda.getidKatalog(), ponuda.getidKorisnik(), ponuda.getPonuda()));
	}
	
	public Ponuda updatePonuda(Ponuda novaPonuda, Long id) {
		return ponudaRepository.findById(id).map(ponuda -> {
			ponuda.setIdKatalog(novaPonuda.getidKatalog());
			ponuda.setIdKorisnik(novaPonuda.getidKorisnik());
			ponuda.setPonuda(novaPonuda.getPonuda());
			return ponudaRepository.save(ponuda);
	      })
	      .orElseGet(() -> {
	        return ponudaRepository.save(novaPonuda);
	      });
	}
	
	public void deleteById(Long id) throws PonudaException {
		if (!ponudaRepository.existsById(id)) {
            throw new PonudaException();
        }
        ponudaRepository.deleteById(id);
    }
	
	public void recieveMessage(Map<String, String> poruka) {
		Long idKataloga = Long.valueOf(poruka.get("idKataloga"));
		Long cijena = Long.valueOf(poruka.get("cijena"));
		Long idKorisinka = Long.valueOf(poruka.get("idKorisnika"));
		ponudaRepository.save(new Ponuda(idKataloga, idKorisinka, cijena));
	}
}
