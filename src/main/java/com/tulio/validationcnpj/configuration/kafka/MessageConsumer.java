package com.tulio.validationcnpj.configuration.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;

public interface MessageConsumer {
    void consumer(ConsumerRecord<String, String> message);
}
