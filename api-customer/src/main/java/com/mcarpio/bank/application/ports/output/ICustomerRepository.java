package com.mcarpio.bank.application.ports.output;

import com.mcarpio.bank.domain.pojos.Customer;

import java.util.List;
import java.util.Optional;

public interface ICustomerRepository {
    Customer save(Customer customer);
    Customer update(Customer customer);
    List<Customer> findAll();
    Optional<Customer> findById(Integer id);
    Optional<Customer> findByIdentification(String identification);
}
