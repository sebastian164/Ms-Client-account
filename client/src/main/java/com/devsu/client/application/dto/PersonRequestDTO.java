package com.devsu.client.application.dto;

import com.devsu.client.common.util.ValidationMessages;
import jakarta.validation.constraints.*;

import lombok.Data;

@Data
public class PersonRequestDTO {

    @NotBlank(message = ValidationMessages.REQUIRED_FIELD)
    private String name;

    @NotBlank(message = ValidationMessages.REQUIRED_FIELD)
    private String gender;

    @NotNull(message = ValidationMessages.REQUIRED_FIELD)
    @Min(value = 0, message = ValidationMessages.INVALID_AGE)
    private Integer age;

    @NotBlank(message = ValidationMessages.REQUIRED_FIELD)
    private String identification;

    @NotBlank(message = ValidationMessages.REQUIRED_FIELD)
    private String address;

    @NotBlank(message = ValidationMessages.REQUIRED_FIELD)
    private String phone;
}