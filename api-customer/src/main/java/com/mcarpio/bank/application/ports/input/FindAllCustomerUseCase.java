package com.mcarpio.bank.application.ports.input;

import com.mcarpio.bank.application.ports.output.ICustomerRepository;
import com.mcarpio.bank.domain.pojos.Customer;

import java.util.List;

public class FindAllCustomerUseCase {

    private final ICustomerRepository customerRepository;

    public FindAllCustomerUseCase(ICustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> execute() {
        return customerRepository.findAll();
    }

}
