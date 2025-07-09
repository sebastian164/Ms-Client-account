package com.devsu.client.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "client")
@Data
public class ClientEntity {

    @Id
    private Long id;

    private String password;
    private Boolean state;

    @OneToOne(cascade = CascadeType.ALL)
    @MapsId
    @JoinColumn(name = "id")
    private PersonEntity person;

}