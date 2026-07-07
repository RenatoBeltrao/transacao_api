package com.renatobeltrao.transacao_api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.renatobeltrao.transacao_api.Model.Cliente;

import jakarta.persistence.LockModeType;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{


    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("SELECT c FROM Cliente c WHERE c.id = :id")
    Optional<Cliente> findByIdForUpdate(@Param("id") Long id);


}
