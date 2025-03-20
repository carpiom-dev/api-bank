package com.mcarpio.bank.infrastructure.in.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerOutputDTO {

    private Integer customerId;
    private String name;
    private String surname;
    private String gender;
    private Integer age;
    private String identification;
    private String address;
    private String email;
    private String phone;
    private Boolean status;
    private String password;

}
