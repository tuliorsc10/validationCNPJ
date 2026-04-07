package com.tulio.validationcnpj.dto;

import java.io.Serializable;

public record CnaeSecundario(
        Integer codigo,
        String descricao
) implements Serializable {
}
