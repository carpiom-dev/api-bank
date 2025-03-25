package com.mcarpio.bank.application.ports.in;

import com.mcarpio.bank.application.ports.out.ICustomerRepository;
import com.mcarpio.bank.domain.exception.CustomerAlreadyExistsException;

import java.util.Objects;

public class DeleteCustomerByIdUseCase {

    private final ICustomerRepository customerRepository;

    public DeleteCustomerByIdUseCase(ICustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void execute(Integer customerId) {

        Objects.requireNonNull(customerId, "Customer ID cannot be null.");

        var customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new CustomerAlreadyExistsException("Customer with ID %d not exists.".formatted(customerId)));

        if (customerRepository.disableCustomer(customer.getCustomerId()) == 0) {
            throw new IllegalStateException("Customer with ID %d is already disabled.".formatted(customerId));
        }
    }
}
