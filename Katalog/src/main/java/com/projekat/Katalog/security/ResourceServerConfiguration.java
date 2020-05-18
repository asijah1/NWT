/*package com.projekat.Katalog.security;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

public class ResourceServerConfiguration extends  ResourceServerConfigurerAdapter {
	@Override
	public void configure(HttpSecurity http) throws Exception{
		http.authorizeRequests().anyRequest().authenticated();
		
		//ovo nam nije potrebno jer nemamo delete zahtjeva ovdje
		/*http.authorizeRequests()
		   .antMatchers(HttpMethod.DELETE, "/v1/organizations/**")
		   .hasRole("ADMIN")
		   .anyRequest()
		   .authenticated();
		   
	}
}
*/