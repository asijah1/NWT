package com.Projekat.APIGateway.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.Projekat.APIGateway.model.Korisnik;
import com.Projekat.APIGateway.model.Ponuda;

@Service
public class APIService {
	
	@Autowired
	RestTemplate restTemplate = new RestTemplate();
	
	public List<Ponuda> dohvatiPonude(Long id) {
		ResponseEntity<Ponuda[]> response = restTemplate.getForEntity("http://ponuda/ponude/katalogSaId?id=" + id, Ponuda[].class);
		Ponuda[] ponude = response.getBody();
		return Arrays.asList(ponude);
	}
	
	public List<Korisnik> dohvatiKorisnike(Long id) {
		ResponseEntity<Ponuda[]> response = restTemplate.getForEntity("http://ponuda/ponude/katalogSaId?id=" + id, Ponuda[].class);
		Ponuda[] ponude = response.getBody();
		return Arrays.asList(ponude).stream().map(ponuda ->{
			Korisnik k = restTemplate.getForObject("http://korisnik/korisnici/korisnikSaId?id=" + ponuda.getId(), Korisnik.class);
			return k;
		}).collect(Collectors.toList());
	}
	
}
