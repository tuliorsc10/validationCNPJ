package com.tulio.validationcnpj.service;

import com.tulio.validationcnpj.configuration.kafka.dto.MessageWrapper;

public interface ValidationCNPJService {
    void validation(MessageWrapper<String> message);
}
