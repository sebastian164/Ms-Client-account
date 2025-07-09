package com.devsu.client.infrastructure.adapter;

import com.devsu.client.domain.model.Client;
import com.devsu.client.domain.port.out.ClientRepositoryPort;
import com.devsu.client.infrastructure.persistence.entity.ClientEntity;
import com.devsu.client.infrastructure.persistence.mapper.ClientEntityMapper;
import com.devsu.client.infrastructure.persistence.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ClientRepositoryAdapter implements ClientRepositoryPort {

    private final ClientRepository clientRepository;
    private final ClientEntityMapper mapper;
    @Override
    public Client save(Client client) {
        return mapper.toModel(clientRepository.save(mapper.toEntity(client)));
    }

    @Override
    public Optional<Client> findById(Long id) {
        return clientRepository.findById(id).map(mapper::toModel);
    }

    @Override
    public List<Client> findAll() {
        return mapper.toModelList(clientRepository.findAll());
    }

    @Override
    public void deleteById(Long id) {
        clientRepository.deleteById(id);
    }
}
