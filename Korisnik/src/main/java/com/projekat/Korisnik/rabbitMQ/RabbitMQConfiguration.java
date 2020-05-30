package com.projekat.Korisnik.rabbitMQ;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.core.Queue;


@Configuration
public class RabbitMQConfiguration {

	@Bean
    public Queue hello() {
        return new Queue("brisanjeKorisnika");
    }
}