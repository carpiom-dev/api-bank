package com.mcarpio.bank.customers.application.ports.output;

import com.mcarpio.bank.customers.domain.pojos.Customer;

import java.util.List;
import java.util.Optional;

public interface ICustomerRepository {
    Customer save(Customer customer);
    Customer update(Customer customer);
    List<Customer> findAll();
    Optional<Customer> findById(Integer id);
    Optional<Customer> findByIdentification(String identification);
}
