package com.projekat.Korisnik;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projekat.Korisnik.model.Korisnik;
import com.projekat.Korisnik.repository.KorisnikRepository;

@EnableDiscoveryClient
@SpringBootApplication
public class KorisnikApplication {

  private static final Logger log = LoggerFactory.getLogger(KorisnikApplication.class);

  public static void main(String[] args) {
    SpringApplication.run(KorisnikApplication.class, args);
  }
  
  @RestController
	class ServiceInstanceRestController {

		@Autowired
		private DiscoveryClient discoveryClient;

		@RequestMapping("/service-instances/{applicationName}")
		public List<ServiceInstance> serviceInstancesByApplicationName(@PathVariable String applicationName) {
			return this.discoveryClient.getInstances(applicationName);
		}
	}
  
  @Bean
  public CommandLineRunner demo(KorisnikRepository repository) {
    return (args) -> {
      // save a few customers
      repository.save(new Korisnik("Jack", "Bauer", "Visoko", "Iomanovic1@etf.unsa.ba", "062/111-111"));
      repository.save(new Korisnik("Chloe", "O'Brian", "Visoko", "Iomanovic1@etf.unsa.ba", "062/111-111"));
      repository.save(new Korisnik("Kim", "Bauer", "Visoko", "Iomanovic1@etf.unsa.ba", "062/111-111"));
      repository.save(new Korisnik("David", "Palmer", "Visoko", "Iomanovic1@etf.unsa.ba", "062/111-111"));
      repository.save(new Korisnik("Michelle", "Dessler", "Visoko", "Iomanovic1@etf.unsa.ba", "062/111-111"));

      // fetch all customers
      log.info("Customers found with findAll():");
      log.info("-------------------------------");
      for (Korisnik customer : repository.findAll()) {
        log.info(customer.toString());
      }
      log.info("");

      // fetch an individual customer by ID
      log.info("Customer found with findById(1L):");
      log.info("--------------------------------");
      Korisnik customer = repository.findById(1L);
      log.info(customer.toString());
      log.info("");

      // fetch customers by last name
      log.info("Customer found with findByLastName('Bauer'):");
      log.info("--------------------------------------------");
      repository.findByLastName("Bauer").forEach(bauer -> {
        log.info(bauer.toString());
      });
      // for (Customer bauer : repository.findByLastName("Bauer")) {
      //  log.info(bauer.toString());
      // }
      log.info("");
    };
  }

}