package school.sptech.spring_rabbittmq_exemplo.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import school.sptech.spring_rabbittmq_exemplo.Entitite.Musica;
import school.sptech.spring_rabbittmq_exemplo.RabbitTemplateConfiguration;

@Service
public class MusicaService {

    private final RabbitTemplate rabbitTemplate;

    @Value("${broker.exchange.name}")
    private String exchangeName;

    @RabbitListener(queues = "${broker.queue.name}")
    public void receive(String message) {
        System.out.println("Received message: " + message);
    }

    public MusicaService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public String enviarMusica(Musica musica) {
        rabbitTemplate.convertAndSend(exchangeName, "", musica);
        return "Música " + musica.getTitulo() + " enviada para a fila com sucesso!";
    }
}
