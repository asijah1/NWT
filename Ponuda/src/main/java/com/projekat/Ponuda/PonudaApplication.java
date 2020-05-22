package com.projekat.Ponuda;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
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

import com.projekat.Ponuda.listener.KatalogListener;
import com.projekat.Ponuda.model.Ponuda;
import com.projekat.Ponuda.repository.PonudaRepository;


@EnableDiscoveryClient
@SpringBootApplication
public class PonudaApplication {

  private static final Logger log = LoggerFactory.getLogger(PonudaApplication.class);

  public static void main(String[] args) {
    SpringApplication.run(PonudaApplication.class);
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
  MessageListenerAdapter listenerAdapter(KatalogListener katalogListener) {
	  return new MessageListenerAdapter(katalogListener, "recieveMessage");
  }

  @Bean
  public CommandLineRunner demo(PonudaRepository repository) {
    return (args) -> {
      // save a few customers
      repository.save(new Ponuda(1L, 1L, 15L));
      repository.save(new Ponuda(2L, 3L, 11L));
      repository.save(new Ponuda(2L, 1L, 12L));
      repository.save(new Ponuda(3L, 1L, 12L));
      repository.save(new Ponuda(4L, 1L, 11L));
      repository.save(new Ponuda(5L, 2L, 13L));

      // fetch all customers
      log.info("Customers found with findAll():");
      log.info("-------------------------------");
      for (Ponuda ponuda : repository.findAll()) {
        log.info(ponuda.toString());
      }
      log.info("");

      // fetch an individual customer by ID
      log.info("Customer found with findById(1L):");
      log.info("--------------------------------");
      Ponuda customer = repository.findById(1L);
      log.info(customer.toString());
      log.info("");

      // fetch customers by last name
      log.info("Customer found with findByLastName('Bauer'):");
      log.info("--------------------------------------------");
      repository.findByPonuda(11L).forEach(ponuda -> {
        log.info(ponuda.toString());
      });
      // for (Customer ponuda : repository.findByLastName("Bauer")) {
      //  log.info(bauer.toString());
      // }
      log.info("");
    };
  }

}