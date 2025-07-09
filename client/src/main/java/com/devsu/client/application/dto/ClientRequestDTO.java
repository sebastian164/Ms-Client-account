package com.devsu.client.application.dto;

import com.devsu.client.common.util.ValidationMessages;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ClientRequestDTO {

    @NotBlank(message = ValidationMessages.PASSWORD_REQUIRED)
    private String password;

    @NotNull(message = ValidationMessages.STATE_REQUIRED)
    private Boolean state;

    @NotNull(message = ValidationMessages.PERSON_REQUIRED)
    @Valid
    private PersonRequestDTO person;
}
