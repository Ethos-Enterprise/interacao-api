package com.ethos.interacaoapi.api;

import com.ethos.interacaoapi.api.empresadto.EmpresaDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@FeignClient(name = "empresa-api", url = "http://localhost:8082/v1.0/empresas")
public interface EmpresaClient {
    @GetMapping("/{id}")
    EmpresaDTO findById(@PathVariable UUID id);
}
