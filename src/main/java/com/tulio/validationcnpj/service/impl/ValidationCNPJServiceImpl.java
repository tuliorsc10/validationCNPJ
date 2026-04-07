package com.tulio.validationcnpj.service.impl;

import com.tulio.validationcnpj.config.FeignApiBrasilClient;
import com.tulio.validationcnpj.configuration.kafka.dto.MessageWrapper;
import com.tulio.validationcnpj.dto.CompanyResponse;
import com.tulio.validationcnpj.service.ValidationCNPJService;
import feign.FeignException;
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
        log.info("Messag received: {}", message);
        try {
            CompanyResponse response = feignApiBrasilClient.getCNPJ(message.getPayload());
            log.info("Received response of the ApiBrasil: {}", response);
            if ("ATIVA".equalsIgnoreCase(response.descricaoSituacaoCadastral())) {
                System.out.println("Empresa Ativa");
            } else {
                System.out.println("Empresa Inativa");
            }
        } catch (FeignException e) {
            log.error(e.getMessage(), e);
        }
    }
}
