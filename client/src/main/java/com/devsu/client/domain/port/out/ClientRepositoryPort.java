package com.devsu.client.domain.port.out;

import com.devsu.client.domain.model.Client;

import java.util.List;
import java.util.Optional;

public interface ClientRepositoryPort {

    Client save(Client client);

    Optional<Client> findById(Long id);

    List<Client> findAll();

    void deleteById(Long id);
}