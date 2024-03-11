package com.ethos.interacaoapi.mapper;


import com.ethos.interacaoapi.controller.request.InteracaoRequest;
import com.ethos.interacaoapi.model.Interacao;
import org.mapstruct.Mapper;

@Mapper(
        componentModel = "spring",
        nullValueMappingStrategy = org.mapstruct.NullValueMappingStrategy.RETURN_DEFAULT)
public interface InteracaoMapper {

    Interacao from(InteracaoRequest interacaoRequest);

}
