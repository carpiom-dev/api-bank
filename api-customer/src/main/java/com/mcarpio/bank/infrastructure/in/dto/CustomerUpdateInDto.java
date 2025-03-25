package com.mcarpio.bank.infrastructure.in.dto;

import jakarta.validation.constraints.*;

public record CustomerUpdateInDto(@NotNull(message = "customer id cannot be null")   Integer customerId,
                                  String name,
                                  String surname,
                                  String gender,
                                  Integer age,
                                  String identification,
                                  String address,
                                  String email,
                                  String phone,
                                  Boolean status,
                                  String password) { }
