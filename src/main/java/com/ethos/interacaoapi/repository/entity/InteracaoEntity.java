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

    private UUID fkServico;

    private UUID fkEmpresa;

    @Builder(toBuilder = true)
    public InteracaoEntity(UUID id, String status, LocalDate data, UUID fkServico, UUID fkEmpresa) {
        this.id = UUID.randomUUID();
        this.status = status;
        this.data = LocalDate.now();
        this.fkServico = fkServico;
        this.fkEmpresa = fkEmpresa;
    }

}
