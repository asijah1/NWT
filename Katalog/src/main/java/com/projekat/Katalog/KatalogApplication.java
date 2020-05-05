package com.projekat.Katalog;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.metrics.MetricsProperties.Web;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.reactive.function.client.WebClientAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import com.example.Katalog.SystemEventsGrpc;
import com.example.Katalog.SystemEventsOuterClass;
import com.example.Katalog.SystemEventsOuterClass.Request;
import com.example.Katalog.SystemEventsOuterClass.Response;
import com.google.protobuf.Timestamp;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.ribbon.RequestTemplate;
import com.projekat.Katalog.KatalogApplication;
import com.projekat.Katalog.model.Katalog;
import com.projekat.Katalog.repository.KatalogRepository;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

@EnableDiscoveryClient
@SpringBootApplication
@EnableEurekaClient
public class KatalogApplication {

	private static final Logger log = LoggerFactory.getLogger(KatalogApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(KatalogApplication.class, args);
		
		/*
		//dio ispod se odnosi na grpc server
		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8083)
		          .usePlaintext()
		          .build();
		 
		        SystemEventsGrpc.SystemEventsBlockingStub stub = SystemEventsGrpc.newBlockingStub(channel);
		 
		        Response response = stub.start(Request.newBuilder()
		          .setNazivMikroservisa("Katalog")
		          .setNazivResursa("resurs")
		          .build());
		 
		        channel.shutdown();
		*/
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
	@LoadBalanced
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	
	@Bean
	public CommandLineRunner demo(KatalogRepository repository) {
		return (args) -> {
	      // save a few catalogs
	      repository.save(new Katalog("mobitel", "dodatneInformacije", 250, null, null, 1L, 2L, true));
	      repository.save(new Katalog("auto", "dodatneInformacije", 5500, null, null, 3L, 4L, true));
	      repository.save(new Katalog("avion", "dodatneInformacije", 1000000, null, null, 5L, 6L, true));
	      repository.save(new Katalog("kamion", "dodatneInformacije", 20000, null, null, 7L, 8L, true));
	      repository.save(new Katalog("jahta", "dodatneInformacije", 1000000, null, null, 9L, 10L, true));
	      repository.save(new Katalog("voz", "dodatneInformacije", 50000, null, null, 11L, 12L, true));

	      // fetch all catalogs
	      log.info("Katalogs found with findAll():");
	      log.info("-------------------------------");
	      for (Katalog catalog : repository.findAll()) {
	        log.info(catalog.toString());
	      }
	      log.info("");

	      // fetch an individual catalog by ID
	      log.info("Katalog found with findById(1L):");
	      log.info("--------------------------------");
	      Katalog catalog = repository.findById(1L);
	      log.info(catalog.toString());
	      log.info("");
	    };
	  }
}
