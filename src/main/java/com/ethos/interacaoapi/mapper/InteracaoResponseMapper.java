package com.ethos.interacaoapi.mapper;

import com.ethos.interacaoapi.controller.response.InteracaoResponse;
import com.ethos.interacaoapi.repository.entity.InteracaoEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", nullValueMappingStrategy = org.mapstruct.NullValueMappingStrategy.RETURN_DEFAULT)
public interface InteracaoResponseMapper {

    InteracaoResponse from(InteracaoEntity interacaoEntity);

}
