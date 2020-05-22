package com.example.RabbitMQ;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.context.annotation.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;


@Profile({"tut1","hello-world"})
@Configuration
public class RabbitConfig {
	
	public final static String SFG_MESSAGE_QUEUE = "sfg-message-queue";

	@Bean
	Queue queue() {
		return new Queue(SFG_MESSAGE_QUEUE, false);
	}

	@Bean
	TopicExchange exchange() {
		return new TopicExchange("spring-boot-exchange");
	}

	@Bean
	Binding binding(Queue queue, TopicExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with(SFG_MESSAGE_QUEUE);
	}

	@Bean
	SimpleMessageListenerContainer container(ConnectionFactory connectionFactory,
	MessageListenerAdapter listenerAdapter) {
		SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
		container.setConnectionFactory(connectionFactory);
		container.setQueueNames(SFG_MESSAGE_QUEUE);
		container.setMessageListener(listenerAdapter);
		return container;
	}

	@Bean
	MessageListenerAdapter listenerAdapter(RabbitReceiver receiver) {
		return new MessageListenerAdapter(receiver, "receiveMessage");
	}
	
	@Bean
    public FanoutExchange fanout() {
        return new FanoutExchange("tut.fanout");
    }
	
	//svaki mikroservis ima svoj red
    @Bean
    public Queue korisnikQueue() {
        return new Queue("korisnikQueue");
    }
    
    @Bean
    public Queue ponudaQueue() {
        return new Queue("ponudaQueue");
    }

    @Bean
    public Queue katalogQueue() {
        return new Queue("katalogQueue");
    }
    
    //3 mikroservisa -> 3 receivera
    @Profile("receiver")
    private static class ReceiverConfig {
    	
    	@Bean
        public Queue autoDeleteKorisnikQueue() {
            return new AnonymousQueue();
        }

        @Bean
        public Queue autoDeletePonudaQueue() {
            return new AnonymousQueue();
        }
        
        @Bean
        public Queue autoDeleteKatalogQueue() {
            return new AnonymousQueue();
        }
        
        @Bean
        public Binding bindingKorisnik(FanoutExchange fanout, Queue autoDeleteKorisnikQueue) {
            return BindingBuilder.bind(autoDeleteKorisnikQueue).to(fanout);
        }

        @Bean
        public Binding bindingPonuda(FanoutExchange fanout, Queue autoDeletePonudaQueue) {
            return BindingBuilder.bind(autoDeletePonudaQueue).to(fanout);
        }
    	
        @Bean
        public Binding binding3(FanoutExchange fanout, Queue autoDeleteKatalogQueue) {
            return BindingBuilder.bind(autoDeleteKatalogQueue).to(fanout);
        }
        
	    @Bean
	    public RabbitReceiver korisnikReceiver() {
	        return new RabbitReceiver();
	    }
	    
	    @Bean
	    public RabbitReceiver ponudaReceiver() {
	        return new RabbitReceiver();
	    }
	    
	    @Bean
	    public RabbitReceiver katalogReceiver() {
	        return new RabbitReceiver();
	    }
	    
    }
    
    @Profile("sender")
    @Bean
    public RabbitSender sender() {
        return new RabbitSender();
    }
}