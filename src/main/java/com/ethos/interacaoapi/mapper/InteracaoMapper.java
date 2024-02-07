package com.ethos.interacaoapi.mapper;


import com.ethos.interacaoapi.controller.request.InteracaoRequest;
import com.ethos.interacaoapi.model.Interacao;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;

@Mapper
public interface InteracaoMapper {

    Interacao from(InteracaoRequest interacaoRequest);

}
