package com.example.RabbitMQ;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

@RabbitListener(queues = "hello")
public class RabbitReceiver {
	
	@RabbitHandler
    public void receive(String in) {
        System.out.println(" [x] Received '" + in + "'");
    }
	
}