package com.example.systemevents;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SystemEventsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SystemEventsApplication.class, args);
	}
	
	/*
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
	 */

}
