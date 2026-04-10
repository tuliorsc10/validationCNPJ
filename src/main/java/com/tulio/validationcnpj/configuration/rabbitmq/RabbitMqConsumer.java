package com.tulio.validationcnpj.configuration.rabbitmq;

import com.seuprojeto.common.consumer.MessageConsumer;
import com.seuprojeto.common.consumer.dto.MessageWrapper;
import com.tulio.validationcnpj.service.ValidationCNPJService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name = "messaging.type", havingValue = "rabbitmq")
@Slf4j
@RequiredArgsConstructor
public class RabbitMqConsumer implements MessageConsumer<String> {

    private final ValidationCNPJService validationCNPJService;

    @Override
    @RabbitListener(queues = "VALIDATE_CNPJ_RECEITA_FEDERAL")
    public void consumer(MessageWrapper<String> message) {
        log.info("Received payload {}", message);
        validationCNPJService.validation(message);
    }
}
