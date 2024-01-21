package com.ethos.interacaoapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class InteracaoService {
    private final InteracaoRepository repository;

}
