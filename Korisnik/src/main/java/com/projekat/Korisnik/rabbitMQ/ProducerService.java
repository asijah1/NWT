package com.projekat.Korisnik.rabbitMQ;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.amqp.core.Queue;



@Service
public class ProducerService {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private Queue queue;

    public void send(Long userId) {
    	 this.rabbitTemplate.convertAndSend(queue.getName(), userId);
    }
}