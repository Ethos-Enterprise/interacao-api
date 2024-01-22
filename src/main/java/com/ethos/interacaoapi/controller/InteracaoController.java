package com.ethos.interacaoapi.controller;

import com.ethos.interacaoapi.controller.request.InteracaoRequest;
import com.ethos.interacaoapi.controller.response.InteracaoResponse;
import com.ethos.interacaoapi.service.InteracaoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
}
