package com.ethos.interacaoapi.controller.response;

import java.time.LocalDate;
import java.util.UUID;

public record InteracaoResponse (
        UUID id,
        String status,
        LocalDate data,
        UUID fkServico,
        UUID fkEmpresa

) {

}
