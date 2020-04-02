package com.projekat.Ponuda.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.projekat.Ponuda.model.Ponuda;
import com.projekat.Ponuda.repository.PonudaRepository;

@Service
public class PonudaService {
	
	@Autowired
	private PonudaRepository ponudaRepository;

	public Ponuda findById(Long id) {
		return ponudaRepository.findById(id).orElseThrow();
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
	
	public Ponuda updateKatalog(Ponuda ponuda) {
		return ponudaRepository.save(ponuda);
	}
	
	public void deleteById(Long ponudaId) {
        ponudaRepository.deleteById(ponudaId);
    }
	
}
