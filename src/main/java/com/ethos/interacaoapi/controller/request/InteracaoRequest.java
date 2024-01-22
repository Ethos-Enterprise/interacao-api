package com.ethos.interacaoapi.controller.request;

import jakarta.validation.constraints.*;

import java.time.LocalDate;
import java.util.UUID;

public record InteracaoRequest (
        @NotBlank
        String status,

        @PastOrPresent
        LocalDate data,

        @NotNull
        UUID fkPrestadoraServico){

}
