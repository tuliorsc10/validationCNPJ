package com.tulio.validationcnpj.service.impl;

import com.seuprojeto.common.consumer.dto.MessageWrapper;
import com.tulio.validationcnpj.configuration.feign.FeignApiBrasilClient;
import com.tulio.validationcnpj.dto.CompanyResponse;
import com.tulio.validationcnpj.service.ValidationCNPJService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ValidationCNPJServiceImpl implements ValidationCNPJService {

    private final FeignApiBrasilClient feignApiBrasilClient;

    @Override
    public void validation(MessageWrapper<String> message) {
        log.info("Message received: {}", message);
        CompanyResponse response = feignApiBrasilClient.getCNPJ(message.getPayload());
        log.info("Received response of the ApiBrasil: {}", response);
        if ("ATIVA".equalsIgnoreCase(response.descricaoSituacaoCadastral())) {
            System.out.println("Empresa Ativa");
        } else {
            System.out.println("Empresa Inativa");
        }
    }
}
