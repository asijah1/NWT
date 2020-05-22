package com.example.RabbitMQ;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

public class RabbitSender {
	
	@Autowired
    private RabbitTemplate template;
	
	@Autowired
	private FanoutExchange fanout;
	
    @Autowired
    private Queue queue;

    @Scheduled(fixedDelay = 1000, initialDelay = 500)
    public void send() {
        String message = "Hello World!";
        this.template.convertAndSend(queue.getName(), message);
        System.out.println(" [x] Sent '" + message + "'");
    }
    
    //template.convertAndSend(fanout.getName(), "", message);

}
