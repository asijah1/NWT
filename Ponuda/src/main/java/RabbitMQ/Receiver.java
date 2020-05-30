package RabbitMQ;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

@RabbitListener(queues = "brisanjeKorisnika")
public class Receiver {

	@RabbitHandler
    public void receive(Long korisnikId) {
        System.out.println(" Zaprimljeno: " + korisnikId);
    }

}