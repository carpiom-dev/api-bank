package com.mcarpio.bank.infrastructure.out.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "customer", uniqueConstraints = @UniqueConstraint(columnNames = "customer_id"))
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerEntity extends PersonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Integer customerId;

    @NotBlank
    @Size(min = 8)
    @Column(name = "password", nullable = false)
    private String password;

    @NotNull
    @Column(name = "status", nullable = false)
    private Boolean status;

    public CustomerEntity(String name, String surname, String gender, Integer age, String identification, String address, String email, String phone,
                          String password, Boolean status) {
        super(name, surname, gender, age, identification, address, email, phone);
        this.password = password;
        this.status = status;
    }

    public CustomerEntity(Integer customerId, String name, String surname, String gender, Integer age, String identification, String address, String email, String phone,
                          String password, Boolean status) {
        super(name, surname, gender, age, identification, address, email,phone);
        this.password = password;
        this.status = status;
        this.customerId = customerId;
    }

}
