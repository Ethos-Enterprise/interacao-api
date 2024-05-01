package com.ethos.interacaoapi.api;

import com.ethos.interacaoapi.api.servicodto.ServicoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;
@FeignClient(name = "servico-api", url = "http://localhost:8089/v1.0/servicos")
public interface ServicoClient {
        @GetMapping("/{id}")
        ServicoDTO findById(@PathVariable UUID id);

}
