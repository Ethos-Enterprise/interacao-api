package com.ethos.interacaoapi.service;

import com.ethos.interacaoapi.controller.request.InteracaoRequest;
import com.ethos.interacaoapi.controller.response.InteracaoResponse;
import com.ethos.interacaoapi.exception.InteracaoNaoExisteException;
import com.ethos.interacaoapi.mapper.InteracaoEntityMapper;
import com.ethos.interacaoapi.mapper.InteracaoMapper;
import com.ethos.interacaoapi.mapper.InteracaoResponseMapper;
import com.ethos.interacaoapi.model.Interacao;
import com.ethos.interacaoapi.repository.InteracaoRepository;
import com.ethos.interacaoapi.repository.entity.InteracaoEntity;
import com.ethos.interacaoapi.repository.entity.statusenum.StatusInteracaoEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

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
        InteracaoEntity savedEntity = repository.save(entity);

        //fazer verificação se o serviço existe antes de salvar

        return responseMapper.from(savedEntity);
    }

    public InteracaoResponse putInteracaoStatus(UUID id, StatusInteracaoEnum novoStatus) {
        InteracaoEntity entity = repository.findById(id)
                .orElseThrow(() -> new InteracaoNaoExisteException("Interacao com o id " + id + " não existe"));

        String statusString = novoStatus.toString();
        entity.setStatus(statusString);

        InteracaoEntity interacaoAtualizada = repository.save(entity);

        return responseMapper.from(interacaoAtualizada);
    }

    //mostra todas as interações da empresa
    public List<InteracaoResponse> getAllInteracoes() {
        return repository.findAll().stream().map(responseMapper::from).toList();
    }

    //mostra as interações por status atual
    public List<InteracaoResponse> getInteracaoByStatus(StatusInteracaoEnum status) {
        String statusString = status.toString();
        List<InteracaoEntity> interacaoEntityList = repository.findByStatus(statusString);
        return interacaoEntityList.stream().map(responseMapper::from).collect(Collectors.toList());
    }

    public List<InteracaoResponse> getInteracaoByFkEmpresa(UUID fkEmpresa) {
        List<InteracaoEntity> interacoes = repository.findByFkEmpresa(fkEmpresa);

        return interacoes.stream().map(responseMapper::from).collect(Collectors.toList());
    }

    public List<InteracaoResponse> getInteracaoByFkServico(UUID fkServico) {
        List<InteracaoEntity> interacoes = repository.findByFkServico(fkServico);
        return interacoes.stream().map(responseMapper::from).collect(Collectors.toList());
    }

    public void deleteInteracao(UUID id) {
        InteracaoEntity entity = repository.findById(id)
                .orElseThrow(() -> new InteracaoNaoExisteException("Interacao com o id " + id + " não existe"));

        repository.delete(entity);
        return ;
    }

}
