package com.example.systemevents;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.grpc.Server;
import io.grpc.ServerBuilder;

@SpringBootApplication
public class SystemEventsApplication {
	/*
	public static void main(String[] args) {
		SpringApplication.run(SystemEventsApplication.class, args);
	}
	*/
	private static final Logger log = LoggerFactory.getLogger(SystemEventsApplication.class);
	//grpc server
	public static void main(String[] args) throws IOException, InterruptedException{
		SpringApplication.run(SystemEventsApplication.class, args); //*;
        Server server = ServerBuilder.forPort(8083).addService(new SystemEventsImpl()).build();
        server.start();
        System.out.println("Pokrenut gRPC server na portu 8083.\n");
        server.awaitTermination();
    }
}
