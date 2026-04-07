package com.tulio.validationcnpj.configuration.kafka.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageWrapper<T> {
    private T payload;
    private String key;
    private Map<String, Object> headers;
}
