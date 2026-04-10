package com.tulio.validationcnpj.service;

import com.seuprojeto.common.consumer.dto.MessageWrapper;

public interface ValidationCNPJService {
    void validation(MessageWrapper<String> message);
}
