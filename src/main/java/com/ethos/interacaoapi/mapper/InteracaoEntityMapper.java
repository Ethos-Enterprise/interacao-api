package com.ethos.interacaoapi.mapper;

import com.ethos.interacaoapi.model.Interacao;
import com.ethos.interacaoapi.repository.entity.InteracaoEntity;
import org.mapstruct.Mapper;

@Mapper
public interface InteracaoEntityMapper {
    InteracaoEntity from(Interacao interacao);

}
