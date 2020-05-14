package com.Projekat.APIGateway;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@EnableZuulProxy
@SpringBootApplication
@RestController
@EnableResourceServer
@EnableAuthorizationServer
@EnableDiscoveryClient
@EnableEurekaClient
public class ApiGatewayApplication {
	
	@RequestMapping(value = { "/user" }, produces = "application/json")
	public Map<String, Object> user(OAuth2Authentication user) {
	    Map<String, Object> userInfo = new HashMap<>();
	    userInfo.put(
	           "user", 
	            user.getUserAuthentication().getPrincipal());
	    userInfo.put("authorities",
	       AuthorityUtils.authorityListToSet(
	       user.getUserAuthentication()
	           .getAuthorities()));
	    return userInfo;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}
	
	@LoadBalanced
	@Bean
	RestTemplate restTemplate(){
		return new RestTemplate();
	}
	
}
