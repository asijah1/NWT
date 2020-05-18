package com.Projekat.APIGateway.security;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.InMemoryUserDetailsManagerConfigurer;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.client.RestTemplate;
import com.Projekat.APIGateway.model.Korisnik;
import com.Projekat.APIGateway.service.APIService;

//Imports removed for conciseness
@Configuration
public class WebSecurityConfigurer extends WebSecurityConfigurerAdapter {
	
	@Autowired
	APIService apiService;
	
	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() 
	    throws Exception{
	  return super.authenticationManagerBean();
	}
	
	@Override
	@Bean
	public UserDetailsService userDetailsServiceBean() throws Exception {
	  return super.userDetailsServiceBean();
	}
	
	@Override
	protected void configure(
	    AuthenticationManagerBuilder auth) throws Exception {
		
		InMemoryUserDetailsManagerConfigurer<AuthenticationManagerBuilder> imudmc = auth.inMemoryAuthentication();
		
		List<Korisnik> users = apiService.dohvatiKorisnike();
		
        for (Korisnik user : users) {
            String theUsername = user.getFirstName();
            String password = "{noop}SIFRA"; 
            imudmc.withUser(theUsername).password(password).roles("user");
        }
	}
}
