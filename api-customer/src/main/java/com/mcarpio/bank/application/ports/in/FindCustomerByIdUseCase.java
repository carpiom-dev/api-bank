package com.mcarpio.bank.application.ports.in;

import com.mcarpio.bank.application.ports.out.ICustomerRepository;
import com.mcarpio.bank.domain.pojos.CustomerPojo;

import java.util.Optional;

public class FindCustomerByIdUseCase {

    private final ICustomerRepository customerRepository;
    public FindCustomerByIdUseCase(ICustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Optional<CustomerPojo> execute(Integer id) {
        return customerRepository.findById(id);
    }
}
