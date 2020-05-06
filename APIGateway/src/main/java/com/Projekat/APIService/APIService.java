package com.Projekat.APIService;

import org.springframework.http.ResponseEntity;

import com.projekat.Katalog.model.Ponuda;

public class APIService {
	
	public List dohvatiPonude(Long id) {
		ResponseEntity<Ponuda[]> response = restTemplate.getForEntity("http://ponuda/ponude/katalogSaId?id=" + id, Ponuda[].class);
	}
}
