package com.ethos.interacaoapi.api.empresadto;

import lombok.Data;

import java.util.UUID;

@Data
public class EmpresaDTO {

    public UUID id;
    public String razaoSocial;
    public String cnpj;
    public String telefone;
    public String email;
    public String setor;
    public Integer qtdFuncionarios;
    public Boolean assinanteNewsletter;
    public int fkPlano;
}
