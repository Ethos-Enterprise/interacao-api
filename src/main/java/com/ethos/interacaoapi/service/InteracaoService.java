package com.ethos.interacaoapi.service;

import com.ethos.interacaoapi.controller.request.InteracaoRequest;
import com.ethos.interacaoapi.controller.response.InteracaoResponse;
import com.ethos.interacaoapi.mapper.InteracaoEntityMapper;
import com.ethos.interacaoapi.mapper.InteracaoMapper;
import com.ethos.interacaoapi.mapper.InteracaoResponseMapper;
import com.ethos.interacaoapi.model.Interacao;
import com.ethos.interacaoapi.repository.InteracaoRepository;
import com.ethos.interacaoapi.repository.entity.InteracaoEntity;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class InteracaoService {
    private final InteracaoRepository repository;
    private final InteracaoMapper mapper;
    private final InteracaoEntityMapper entityMapper;
    private final InteracaoResponseMapper responseMapper;

    public InteracaoResponse postInteracao(InteracaoRequest request) {
        Interacao resMapper = mapper.from(request);
        InteracaoEntity entity = entityMapper.from(resMapper);
        InteracaoEntity savedEntity = saveEntity(entity);
        return responseMapper.from(savedEntity);
    }


    private InteracaoEntity saveEntity(InteracaoEntity entity) {
        //verificar se empresa existe
    }

}
