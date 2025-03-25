package com.mcarpio.bank.infrastructure.in.dto;

import jakarta.validation.constraints.*;

public record CustomerInputDTO(
        @NotBlank(message = "Name cannot be blank") String name,
        @NotBlank(message = "Surname cannot be blank") String surname,
        @NotBlank(message = "Gender cannot be blank") String gender,
        @Min(value = 0, message = "Age must be a positive number") Integer age,
        @NotBlank(message = "Identification cannot be blank")
        @Pattern(regexp = "^[A-Za-z0-9]+$", message = "Identification must be alphanumeric")
        String identification,
        String address,
        @NotBlank(message = "Email cannot be blank") @Email(message = "Email must be a valid email address") String email,
        @NotBlank(message = "Phone cannot be blank")
        @Pattern(regexp = "^\\+?[0-9]{10,15}$", message = "Phone must be a valid phone number")
        String phone,
        @NotBlank(message = "Password cannot be blank") String password,
        @NotNull(message = "Status cannot be null") Boolean status
) {}
