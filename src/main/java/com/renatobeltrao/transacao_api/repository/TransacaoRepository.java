package com.renatobeltrao.transacao_api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.renatobeltrao.transacao_api.Model.Transacao;

public interface TransacaoRepository extends JpaRepository<Transacao, Long>{
    List<Transacao> findTop10ByClienteIdOrderByRealizadaEmDesc(Long clienteId);
    
}
