package com.devsu.client.infrastructure.persistence.mapper;

import com.devsu.client.domain.model.Person;
import com.devsu.client.infrastructure.persistence.entity.PersonEntity;
import org.springframework.stereotype.Component;

@Component
public class PersonEntityMapper {

    public Person toModel(PersonEntity e) {
        if (e == null) return null;
        Person p = new Person();
        p.setId(e.getId());
        p.setName(e.getName());
        p.setGender(e.getGender());
        p.setAge(e.getAge());
        p.setIdentification(e.getIdentification());
        p.setAddress(e.getAddress());
        p.setPhone(e.getPhone());
        return p;
    }

    public PersonEntity toEntity(Person m) {
        if (m == null) return null;
        PersonEntity e = new PersonEntity();
        e.setId(m.getId());
        e.setName(m.getName());
        e.setGender(m.getGender());
        e.setAge(m.getAge());
        e.setIdentification(m.getIdentification());
        e.setAddress(m.getAddress());
        e.setPhone(m.getPhone());
        return e;
    }
}
