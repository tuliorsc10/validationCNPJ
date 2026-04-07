package com.tulio.validationcnpj.configuration.kafka;

import com.tulio.validationcnpj.configuration.kafka.dto.MessageWrapper;
import com.tulio.validationcnpj.service.ValidationCNPJService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.context.annotation.Profile;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Profile("kafka")
@Slf4j
@RequiredArgsConstructor
public class KafkaConsumer implements MessageConsumer {

    private final ValidationCNPJService validationCNPJService;
    @Override
    @KafkaListener(topics = "VALIDATE_CNPJ_RECEITA_FEDERAL", containerFactory = "kafkaListenerContainerFactory")
    public void consumer(ConsumerRecord<String, String> message) {
        log.info("Received message {}", message);
        MessageWrapper<String> msg = new MessageWrapper<>();
        msg.setPayload(message.value());
        msg.setKey(message.key());
        validationCNPJService.validation(msg);
    }
}
