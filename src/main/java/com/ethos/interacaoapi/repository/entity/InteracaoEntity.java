package com.ethos.interacaoapi.repository.entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Table(name= "INTERACAO")
@Entity

public class InteracaoEntity {
    @Id
    private UUID id;

    private String status;

    private LocalDate data;

    private UUID fkPrestadoraServico;

    @Builder(toBuilder = true)
    public InteracaoEntity(UUID id, String status, LocalDate data, UUID fkPrestadoraServico) {
        this.id = UUID.randomUUID();
        this.status = status;
        this.data = LocalDate.now();
        this.fkPrestadoraServico = fkPrestadoraServico;
    }

}
