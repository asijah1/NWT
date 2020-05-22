package com.example.RabbitMQ;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

public class RabbitReceiver {
	
	@RabbitListener(queues = "#{autoDeleteKorisnikQueue.name}")
    public void korisnikReceiver(String in) throws InterruptedException {
        receive(in);
    }

    @RabbitListener(queues = "#{autoDeletePonudaQueue.name}")
    public void ponudaReceiver(String in) throws InterruptedException {
        receive(in);
    }
	
    @RabbitListener(queues = "#{autoDeleteKatalogQueue.name}")
    public void katalogReceiver(String in) throws InterruptedException {
        receive(in);
    }
    
	@RabbitHandler
    public void receive(String in) throws InterruptedException{
		
        System.out.println(" [x] Received '" + in + "'");
    
	}
	
}
