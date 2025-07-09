package com.devsu.client.application.mapper;

import com.devsu.client.application.dto.*;
import com.devsu.client.domain.model.Client;
import com.devsu.client.domain.model.Person;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
public class ClientMapper {

    public ClientResponseDTO toResponse(Client model) {
        if (model == null) return null;

        Person person = model.getPerson();
        PersonResponseDTO personDto = null;
        if (person != null) {
            personDto = PersonResponseDTO.builder()
                    .id(person.getId())
                    .name(person.getName())
                    .gender(person.getGender())
                    .age(person.getAge())
                    .identification(person.getIdentification())
                    .address(person.getAddress())
                    .phone(person.getPhone())
                    .build();
        }

        return ClientResponseDTO.builder()
                .id(model.getId())
                .state(model.getState())
                .person(personDto)
                .build();
    }

    public Client toModel(ClientRequestDTO dto) {
        if (dto == null) return null;

        PersonRequestDTO personDto = dto.getPerson();
        Person person = null;
        if (personDto != null) {
            person = Person.builder()
                    .name(personDto.getName())
                    .gender(personDto.getGender())
                    .age(personDto.getAge())
                    .identification(personDto.getIdentification())
                    .address(personDto.getAddress())
                    .phone(personDto.getPhone())
                    .build();
        }

        return Client.builder()
                .state(dto.getState())
                .password(dto.getPassword())
                .person(person)
                .build();
    }
}