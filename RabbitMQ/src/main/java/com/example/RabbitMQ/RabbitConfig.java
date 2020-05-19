package com.example.RabbitMQ;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile({"tut1","hello-world"})
@Configuration
public class RabbitConfig {

    @Bean
    public Queue hello() {
        return new Queue("hello");
    }

    @Profile("receiver")
    @Bean
    public RabbitReceiver receiver() {
        return new RabbitReceiver();
    }

    @Profile("sender")
    @Bean
    public RabbitSender sender() {
        return new RabbitSender();
    }
}