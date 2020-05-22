package com.projekat.Ponuda.listener;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.projekat.Ponuda.model.Ponuda;
import com.projekat.Ponuda.repository.PonudaRepository;

@Component
public class KatalogListener {
	
	@Autowired
	private PonudaRepository ponudaRepository;
	
	public void recieveMessage(Map<String, String> mssg) {
		Long idKataloga = Long.valueOf(mssg.get("idKataloga"));
		Long cijena = Long.valueOf(mssg.get("cijena"));
		Long idKorisnika = Long.valueOf(mssg.get("idKorisnika"));
		ponudaRepository.save(new Ponuda(idKataloga, idKorisnika, cijena));
	}
}
