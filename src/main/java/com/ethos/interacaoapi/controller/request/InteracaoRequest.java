package com.ethos.interacaoapi.controller.request;

import com.ethos.interacaoapi.repository.entity.statusenum.StatusInteracaoEnum;
import jakarta.validation.constraints.*;

import java.time.LocalDate;
import java.util.UUID;

public record InteracaoRequest (
        StatusInteracaoEnum status,
        UUID fkServico,
        UUID fkEmpresa
){
}
