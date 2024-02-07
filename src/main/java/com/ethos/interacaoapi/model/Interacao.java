package com.ethos.interacaoapi.model;

import lombok.Builder;

import java.time.LocalDate;
import java.util.UUID;

public record Interacao(String status, LocalDate data, UUID fkPrestadoraServico) {

    @Builder(toBuilder = true)
    public Interacao( String status, LocalDate data, UUID fkPrestadoraServico) {
        this.status = status;
        this.data = LocalDate.now();
        this.fkPrestadoraServico = fkPrestadoraServico;
    }

}
