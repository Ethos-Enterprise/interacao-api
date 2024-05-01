package com.ethos.interacaoapi.service;

import com.ethos.interacaoapi.api.EmpresaClient;
import com.ethos.interacaoapi.api.PrestadoraClient;
import com.ethos.interacaoapi.api.ServicoClient;
import com.ethos.interacaoapi.api.empresadto.EmpresaDTO;
import com.ethos.interacaoapi.api.prestadoradto.PrestadoraDTO;
import com.ethos.interacaoapi.api.servicodto.ServicoDTO;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class InteracaoService {
    private final InteracaoRepository repository;
    private final InteracaoMapper mapper;
    private final InteracaoEntityMapper entityMapper;
    private final InteracaoResponseMapper responseMapper;
    private final JavaMailSender mailSender;
    private final ServicoClient servicoClient;
    private final EmpresaClient EmpresaClient;
    private final PrestadoraClient prestadoraClient;


    @Autowired
        public InteracaoService(InteracaoRepository repository, InteracaoMapper mapper, InteracaoEntityMapper entityMapper, InteracaoResponseMapper responseMapper, JavaMailSender mailSender, ServicoClient servicoClient, com.ethos.interacaoapi.api.EmpresaClient empresaClient, PrestadoraClient prestadoraClient) {
        this.repository = repository;
        this.mapper = mapper;
        this.entityMapper = entityMapper;
        this.responseMapper = responseMapper;
        this.mailSender = mailSender;
        this.servicoClient = servicoClient;
        EmpresaClient = empresaClient;
        this.prestadoraClient = prestadoraClient;
    }

    public InteracaoResponse postInteracao(InteracaoRequest request) {
        Interacao resMapper = mapper.from(request);
        InteracaoEntity entity = entityMapper.from(resMapper);
        InteracaoEntity savedEntity = repository.save(entity);
        //fazer verificação se o serviço existe antes de salvar
        ServicoDTO dto = servicoClient.findById(request.fkServico());
        PrestadoraDTO dto1 = prestadoraClient.findById(dto.fkPrestadoraServico);
        EmpresaDTO dto2 = EmpresaClient.findById(dto1.fkEmpresa);

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(dto2.email);
        message.setSubject("Teste de envio de email");
        message.setText("Olá, você tem uma nova interação para o serviço " + dto.nomeServico);

        mailSender.send(message);

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
