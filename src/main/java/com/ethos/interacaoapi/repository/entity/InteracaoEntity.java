package com.ethos.interacaoapi.repository.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name= "INTERACAO")
public class InteracaoEntity {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(updatable = false, nullable = false)
    private UUID id;

    private String status;

    private LocalDate data;

    private UUID fkServico;

    private UUID fkEmpresa;

    @Builder(toBuilder = true)
    public InteracaoEntity(String status, LocalDate data, UUID fkServico, UUID fkEmpresa) {
        this.status = status;
        this.data = data != null ? data : LocalDate.now();
        this.fkServico = fkServico;
        this.fkEmpresa = fkEmpresa;
    }
}
