package com.devsu.client.infrastructure.persistence.repository;


import com.devsu.client.infrastructure.persistence.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<PersonEntity, Long> {
    Optional<PersonEntity> findByIdentification(String identification);
}
