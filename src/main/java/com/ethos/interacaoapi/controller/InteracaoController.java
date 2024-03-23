package com.ethos.interacaoapi.controller;

import com.ethos.interacaoapi.controller.request.InteracaoRequest;
import com.ethos.interacaoapi.controller.response.InteracaoResponse;
import com.ethos.interacaoapi.repository.entity.statusenum.StatusInteracaoEnum;
import com.ethos.interacaoapi.service.InteracaoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/v1.0/interacoes")
@RequiredArgsConstructor

public class InteracaoController {
    private final InteracaoService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public InteracaoResponse postInteracao(@RequestBody @Valid InteracaoRequest request) {
    return service.postInteracao(request);
    }

    @PutMapping("/{id}")
    public InteracaoResponse putInteracaostatus(@PathVariable UUID id, @PathVariable StatusInteracaoEnum status) {
        return service.putInteracaoStatus(id, status);
    }

    @GetMapping
    public List<InteracaoResponse> getAllInteracoes() {
        return service.getAllInteracoes();
    }

    @GetMapping("/empresa/{fkEmpresa}")
    public List<InteracaoResponse> getInteracaoByFkEmpresa(@PathVariable UUID fkEmpresa){
        return service.getInteracaoByFkEmpresa(fkEmpresa);
    }

    @GetMapping("/servico/{fkServico}")
    public List<InteracaoResponse> getInteracaoByFkServico(@PathVariable UUID fkServico){
        return service.getInteracaoByFkServico(fkServico);
    }


    @DeleteMapping("/{id}")
    public void deleteInteracao(@PathVariable UUID id) {
        service.deleteInteracao(id);
    }

}
