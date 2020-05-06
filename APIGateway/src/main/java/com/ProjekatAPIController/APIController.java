package com.ProjekatAPIController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Projekat.APIService.APIService;

@Controller
@RequestMapping(path="/")
public class APIController {
	
	@Autowired
	APIService apiService;
	
	@GetMapping(path="/dohvatiPonude")
	public @ResponseBody String dohvatiPonude(@RequestParam Long id){
		return "";
	}
	
	@GetMapping(path="/dohvatiKorisnike")
	public @ResponseBody String dohvatiKorisnike(@RequestParam Long id){
		return "";
	}
}
