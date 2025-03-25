package com.mcarpio.bank.application.ports.in;

import com.mcarpio.bank.application.ports.out.ICustomerRepository;
import com.mcarpio.bank.domain.exception.CustomerAlreadyExistsException;
import com.mcarpio.bank.domain.pojos.CustomerPojo;

public class UpdateCustomerUseCase {

    private final ICustomerRepository customerRepository;

    public UpdateCustomerUseCase(ICustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public CustomerPojo execute(CustomerPojo pojo) {
        customerRepository.findById(pojo.getCustomerId())
                .orElseThrow(() -> new CustomerAlreadyExistsException("Customer with ID %d not exists.".formatted(pojo.getCustomerId())));

        return customerRepository.save(pojo);
    }
}
