package com.mcarpio.bank.application.ports.in;

import com.mcarpio.bank.application.ports.out.ICustomerRepository;
import com.mcarpio.bank.domain.pojos.CustomerPojo;
import com.mcarpio.bank.domain.exception.CustomerNotFoundException;

import java.util.Optional;

public class FindCustomerByIdUseCase {

    private final ICustomerRepository customerRepository;
    public FindCustomerByIdUseCase(ICustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Optional<CustomerPojo> execute(Integer id) {
        return Optional.ofNullable(customerRepository.findById(id))
                .orElseThrow(() -> new CustomerNotFoundException("Customer with id " + id + " not found"));
    }
}
