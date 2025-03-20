package com.mcarpio.bank.application.ports.in;

import com.mcarpio.bank.application.ports.out.ICustomerRepository;
import com.mcarpio.bank.domain.pojos.CustomerPojo;
import com.mcarpio.bank.infrastructure.exception.CustomerNotFoundException;

import java.util.List;
import java.util.Optional;

public class FindAllCustomerUseCase {

    private final ICustomerRepository customerRepository;

    public FindAllCustomerUseCase(ICustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<CustomerPojo> execute() {
        return Optional.of(customerRepository.findAll())
                .filter(list -> !list.isEmpty())
                .orElseThrow(() -> new CustomerNotFoundException("No customers found"));
    }

}
