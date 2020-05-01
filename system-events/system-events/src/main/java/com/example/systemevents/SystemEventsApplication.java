package com.example.systemevents;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.grpc.Server;
import io.grpc.ServerBuilder;

@SpringBootApplication
public class SystemEventsApplication {
	//grpc server
	public static void main(String[] args) throws IOException, InterruptedException{
        Server server = ServerBuilder
          .forPort(8083)
          .addService(new SystemEventsImpl()).build();
		
        server.start();
        server.awaitTermination();
    }
}
