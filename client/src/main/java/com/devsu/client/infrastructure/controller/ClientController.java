package com.devsu.client.infrastructure.controller;

import com.devsu.client.application.dto.ClientRequestDTO;
import com.devsu.client.application.dto.ClientResponseDTO;
import com.devsu.client.domain.port.in.ClientUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
@RequiredArgsConstructor
public class ClientController {

    private final ClientUseCase clientService;

    @PostMapping
    public ResponseEntity<ClientResponseDTO> create(@RequestBody @Valid ClientRequestDTO request) {
        return ResponseEntity.ok(clientService.create(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientResponseDTO> update(@PathVariable Long id, @RequestBody @Valid ClientRequestDTO request) {
        return ResponseEntity.ok(clientService.update(id, request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientResponseDTO> getById(@PathVariable Long id) {
        return clientService.getById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new com.devsu.client.domain.exception.NotFoundException("Cliente no encontrado con id: " + id));
    }

    @GetMapping
    public ResponseEntity<List<ClientResponseDTO>> getAll() {
        return ResponseEntity.ok(clientService.getAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        clientService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
