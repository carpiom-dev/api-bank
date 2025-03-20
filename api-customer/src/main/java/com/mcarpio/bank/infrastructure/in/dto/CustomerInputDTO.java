package com.mcarpio.bank.infrastructure.in.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerInputDTO {

    @NotBlank(message = "Name cannot be blank")
    private String name;

    @NotBlank(message = "Surname cannot be blank")
    private String surname;

    @NotBlank(message = "Gender cannot be blank")
    private String gender;

    @Min(value = 0, message = "Age must be a positive number")
    private Integer age;

    @NotBlank(message = "Identification cannot be blank")
    @Pattern(regexp = "^[A-Za-z0-9]+$", message = "Identification must be alphanumeric")
    private String identification;

    private String address;

    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Email must be a valid email address")
    private String email;

    @NotBlank(message = "Phone cannot be blank")
    @Pattern(regexp = "^\\+?[0-9]{10,15}$", message = "Phone must be a valid phone number")
    private String phone;

    @NotNull(message = "CustomerPojo ID cannot be null")
    private Integer customerId;

    @NotBlank(message = "Password cannot be blank")
    private String password;

    @NotNull(message = "Status cannot be null")
    private Boolean status;

}
