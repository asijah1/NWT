package com.projekat.Ponuda.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.projekat.Ponuda.model.Ponuda;
import com.projekat.Ponuda.repository.PonudaRepository;

@Service
public class PonudaService {
	
	@Autowired
	private PonudaRepository ponudaRepository;
	List<Ponuda> bazaPonuda;

	public Ponuda findById(Long id) {
		return ponudaRepository.findById(id).orElseThrow();
	}
	
	public List<Ponuda> vratiPonude()  {
        List<Ponuda> bazaPonuda = new ArrayList<>();
        ponudaRepository.findAll().forEach(bazaPonuda::add);
        return bazaPonuda;
    }
	
	public Ponuda createPonuda(Long idKatalog, Long idKorisnik, Long ponuda){
        return ponudaRepository.save(new Ponuda(idKatalog, idKorisnik, ponuda));
    }
	
	public Ponuda addNewPonuda(Ponuda ponuda) {
		return ponudaRepository.save(new Ponuda(ponuda.getidKatalog(), ponuda.getidKorisnik(), ponuda.getPonuda()));
	}
	/*
	public Ponuda save(Ponuda novi) {
		return ponudaRepository.save(new Ponuda(1L, 2L, 3L));
	}
	 */
	
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
	
	public void deleteById(Long ponudaId) {
        ponudaRepository.deleteById(ponudaId);
    }
	
}
