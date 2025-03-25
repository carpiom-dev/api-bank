package com.mcarpio.bank.infrastructure.in.dto;

public record CustomerOutputDTO(
        Integer customerId,
        String name,
        String surname,
        String gender,
        Integer age,
        String identification,
        String address,
        String email,
        String phone,
        Boolean status,
        String password
) {}
