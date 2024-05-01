package com.ethos.interacaoapi.api;


import com.ethos.interacaoapi.api.prestadoradto.PrestadoraDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@FeignClient(name = "prestadora-api", url = "http://localhost:8085/v1.0/prestadoras")
public interface PrestadoraClient {
    @GetMapping("/{id}")
    PrestadoraDTO findById(@PathVariable UUID id);
}
