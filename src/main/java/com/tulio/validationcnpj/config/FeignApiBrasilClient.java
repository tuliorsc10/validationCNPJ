package com.tulio.validationcnpj.config;

import com.tulio.validationcnpj.dto.CompanyResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "api-exemplo", url = "https://brasilapi.com.br/api/cnpj/")
public interface FeignApiBrasilClient {

    @GetMapping(value = "v1/{cnpj}")
    CompanyResponse getCNPJ(@PathVariable String cnpj);
}
