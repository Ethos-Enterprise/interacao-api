package com.ethos.interacaoapi.model;

import com.ethos.interacaoapi.repository.entity.statusenum.StatusInteracaoEnum;
import lombok.Builder;

import java.time.LocalDate;
import java.util.UUID;

public record Interacao(
        StatusInteracaoEnum status,
        LocalDate data,
        UUID fkServico,
        UUID fkEmpresa) {

    @Builder(toBuilder = true)
    public Interacao( StatusInteracaoEnum status, LocalDate data, UUID fkServico, UUID fkEmpresa ) {
        this.status = status;
        this.data = LocalDate.now();
        this.fkServico = fkServico;
        this.fkEmpresa = fkEmpresa;
    }

}
