package com.ethos.interacaoapi.repository;

import com.ethos.interacaoapi.repository.entity.InteracaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface InteracaoRepository extends JpaRepository<InteracaoEntity, UUID> {

//criar os coiso dynamic finder aqui
List<InteracaoEntity> findByStatus(String statusAprovacao);

    List<InteracaoEntity> findByFkEmpresa(UUID fkEmpresa);

    List<InteracaoEntity> findByFkServico(UUID fkServico);

}
