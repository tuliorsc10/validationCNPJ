package com.tulio.validationcnpj.configuration.kafka;

import com.seuprojeto.common.consumer.MessageConsumer;
import com.seuprojeto.common.consumer.dto.MessageWrapper;
import com.tulio.validationcnpj.service.ValidationCNPJService;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.RetryableTopic;
import org.springframework.retry.annotation.Backoff;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name = "messaging.type", havingValue = "kafka")
@Slf4j
@RequiredArgsConstructor
public class KafkaConsumer implements MessageConsumer<String> {

    private final ValidationCNPJService validationCNPJService;

    @Override
    @KafkaListener(topics = "VALIDATE_CNPJ_RECEITA_FEDERAL", containerFactory = "kafkaListenerContainerFactory")
    @RetryableTopic(
            attempts = "3",
            backoff = @Backoff(delay = 2000),
            dltTopicSuffix = "-dead",
            include = {FeignException.class}
    )
    public void consumer(MessageWrapper<String> message) {
        log.info("Received message {}", message);
        validationCNPJService.validation(message);
    }

    @KafkaListener(topics = "VALIDATE_CNPJ_RECEITA_FEDERAL-dead", containerFactory = "kafkaListenerContainerFactory")
    public void consumerDLQ(MessageWrapper<String> message) {
        log.error("Received message DLQ {}", message);
    }
}
