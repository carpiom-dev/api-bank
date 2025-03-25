package com.mcarpio.bank.application.ports.in;

import com.mcarpio.bank.application.ports.out.ICustomerRepository;
import com.mcarpio.bank.domain.exception.CustomerNotFoundException;
import com.mcarpio.bank.domain.pojos.CustomerPojo;

import java.util.List;
import java.util.Optional;

public class FindByStatusTrueCustomerUseCase {

    private final ICustomerRepository customerRepository;

    public FindByStatusTrueCustomerUseCase(ICustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<CustomerPojo> execute() {
        return Optional.of(customerRepository.findByStatusTrue())
                .filter(list -> !list.isEmpty())
                .orElseThrow(() -> new CustomerNotFoundException("No customers found"));
    }
}
