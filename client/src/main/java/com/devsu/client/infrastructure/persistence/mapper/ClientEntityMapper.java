package com.devsu.client.infrastructure.persistence.mapper;

import com.devsu.client.domain.model.Client;
import com.devsu.client.infrastructure.persistence.entity.ClientEntity;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ClientEntityMapper {

    private final PersonEntityMapper personMapper;

    public ClientEntityMapper(PersonEntityMapper personMapper) {
        this.personMapper = personMapper;
    }

    public Client toModel(ClientEntity e) {
        if (e == null) return null;
        Client c = new Client();
        c.setId(e.getId());
        c.setPassword(e.getPassword());
        c.setState(e.getState());
        c.setPerson(personMapper.toModel(e.getPerson()));
        return c;
    }

    public ClientEntity toEntity(Client m) {
        if (m == null) return null;
        ClientEntity e = new ClientEntity();
        e.setId(m.getId());
        e.setPassword(m.getPassword());
        e.setState(m.getState());
        e.setPerson(personMapper.toEntity(m.getPerson()));
        return e;
    }

    public List<Client> toModelList(List<ClientEntity> list) {
        if (list == null) return Collections.emptyList();
        return list.stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }
}
