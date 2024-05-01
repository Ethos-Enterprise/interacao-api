package com.ethos.interacaoapi.api.prestadoradto;

import lombok.Data;

import java.util.UUID;

@Data
public class PrestadoraDTO {
    public UUID idPrestador;
    public String statusAprovacao;
    public UUID fkEmpresa;
}
