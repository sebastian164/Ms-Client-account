package com.devsu.client.domain.port.in;

import com.devsu.client.application.dto.ClientRequestDTO;
import com.devsu.client.application.dto.ClientResponseDTO;

import java.util.List;
import java.util.Optional;

public interface ClientUseCase {
    ClientResponseDTO create(ClientRequestDTO request);
    ClientResponseDTO update(Long id, ClientRequestDTO request);
    Optional<ClientResponseDTO> getById(Long id);
    List<ClientResponseDTO> getAll();
    void delete(Long id);
}