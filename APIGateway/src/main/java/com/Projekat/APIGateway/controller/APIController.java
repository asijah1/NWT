package com.Projekat.APIGateway.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Projekat.APIGateway.model.Korisnik;
import com.Projekat.APIGateway.model.Ponuda;
import com.Projekat.APIGateway.service.APIService;

@Controller
@RequestMapping(path="/")
public class APIController {
	
	@Autowired
	APIService apiService;
	
	@GetMapping(path="/dohvatiPonude")
	public @ResponseBody List<Ponuda> dohvatiPonude(@RequestParam Long id){
		return apiService.dohvatiPonude(id);
	}
	
	@GetMapping(path="/dohvatiKorisnike")
	public @ResponseBody List<Korisnik> dohvatiKorisnike(@RequestParam Long id){
		return apiService.dohvatiKorisnike(id);
	}
}
