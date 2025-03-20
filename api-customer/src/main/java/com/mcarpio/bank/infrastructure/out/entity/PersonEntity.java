package com.mcarpio.bank.infrastructure.out.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonEntity {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surname;

    private String gender;

    private Integer age;

    @Column(nullable = false, unique = true)
    private String identification;

    private String address;

    private String email;

    private String phone;

}
