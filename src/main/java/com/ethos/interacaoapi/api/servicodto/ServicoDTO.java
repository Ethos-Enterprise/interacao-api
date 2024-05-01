package com.ethos.interacaoapi.api.servicodto;

import lombok.Data;

import java.util.UUID;
@Data
public class ServicoDTO {

    public UUID id;
    public String nomeServico;
    public String descricao;
    public Double valor;
    public String AreaAtuacaoEsg;
    public UUID fkPrestadoraServico;
}
