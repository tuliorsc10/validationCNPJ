package com.tulio.validationcnpj.configuration.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

    @KafkaListener(topics = "VALIDATE_CNPJ_RECEITA_FEDERAL", containerFactory = "kafkaListenerContainerFactory")
    public void consumirTopico1(String mensagem) {
        System.out.println("Topico1: " + mensagem);
    }
}
