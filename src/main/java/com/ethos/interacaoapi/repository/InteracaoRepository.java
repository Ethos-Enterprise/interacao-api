package com.ethos.interacaoapi.repository;

import com.ethos.interacaoapi.repository.entity.InteracaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface InteracaoRepository extends JpaRepository<InteracaoEntity, UUID> {

//criar os coiso dynamic finder aqui
}
