package com.example.systemevents;

import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import io.grpc.Server;
import io.grpc.ServerBuilder;

@EnableEurekaClient
@SpringBootApplication
public class SystemEventsApplication {
	/*
	public static void main(String[] args) {
		SpringApplication.run(SystemEventsApplication.class, args);
	}
	*/
	
	private static final Logger log = LoggerFactory.getLogger(SystemEventsApplication.class);
	
	@Autowired
	private static AkcijaRepository akcijaRepository;
	
	//grpc server
	public static void main(String[] args) throws IOException, InterruptedException{
		SpringApplication.run(SystemEventsApplication.class, args); //*;
        Server server = ServerBuilder.forPort(8086).addService(new SystemEventsImpl(akcijaRepository)).build();
        server.start();
        System.out.println("Pokrenut gRPC server na portu 8086.\n");
        server.awaitTermination();
    }
}
