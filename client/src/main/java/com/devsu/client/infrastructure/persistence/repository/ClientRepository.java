package com.devsu.client.infrastructure.persistence.repository;

import com.devsu.client.infrastructure.persistence.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<ClientEntity, Long> {
    Optional<ClientEntity> findByPersonIdentification(String identification);
}
