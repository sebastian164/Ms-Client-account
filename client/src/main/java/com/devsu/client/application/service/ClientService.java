package com.devsu.client.application.service;

import com.devsu.client.application.dto.ClientRequestDTO;
import com.devsu.client.application.dto.ClientResponseDTO;
import com.devsu.client.application.mapper.ClientMapper;
import com.devsu.client.domain.exception.NotFoundException;
import com.devsu.client.domain.model.Client;
import com.devsu.client.domain.model.Person;
import com.devsu.client.domain.port.in.ClientUseCase;
import com.devsu.client.domain.port.out.ClientRepositoryPort;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ClientService implements ClientUseCase {

    private final ClientRepositoryPort clientRepository;
    private final ClientMapper clientMapper;
    private final PasswordEncoder passwordEncoder;

    public ClientResponseDTO create(ClientRequestDTO request) {
        Client client = clientMapper.toModel(request);
        Client saved = clientRepository.save(client);
        return clientMapper.toResponse(saved);
    }

    @Transactional
    @Override
    public ClientResponseDTO update(Long id, ClientRequestDTO request) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Cliente no encontrado con id: " + id));

        client.setPassword(passwordEncoder.encode(request.getPassword()));
        client.setState(request.getState());

        Person person = client.getPerson();
        person.setName(request.getPerson().getName());
        person.setGender(request.getPerson().getGender());
        person.setAge(request.getPerson().getAge());
        person.setIdentification(request.getPerson().getIdentification());
        person.setAddress(request.getPerson().getAddress());
        person.setPhone(request.getPerson().getPhone());

        client.setPerson(person);

        Client updated = clientRepository.save(client);

        return clientMapper.toResponse(updated);
    }

    public Optional<ClientResponseDTO> getById(Long id) {
        return clientRepository.findById(id)
                .map(clientMapper::toResponse);
    }

    public List<ClientResponseDTO> getAll() {
        return clientRepository.findAll().stream()
                .map(clientMapper::toResponse)
                .collect(Collectors.toList());
    }

    public void delete(Long id) {
        clientRepository.deleteById(id);
    }
}
