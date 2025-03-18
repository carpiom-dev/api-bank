package com.mcarpio.bank.application.ports.input;
import com.mcarpio.bank.application.ports.output.ICustomerRepository;
import com.mcarpio.bank.application.ports.output.IPasswordEncoder;
import com.mcarpio.bank.domain.exception.CustomerAlreadyExistsException;
import com.mcarpio.bank.domain.pojos.Customer;

public class SaveCustomerUseCase {

    private final ICustomerRepository customerRepository;
    private final IPasswordEncoder passwordEncoder;

    public SaveCustomerUseCase(ICustomerRepository customerRepository, IPasswordEncoder passwordEncoder) {
        this.customerRepository = customerRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Customer execute(Customer customer) {

        customerRepository.findByIdentification(customer.getIdentification())
                .ifPresent( customer1 -> {
                    throw new CustomerAlreadyExistsException("The customer with that identification is already registered.");
                });

        customer.setPassword(passwordEncoder.encode(customer.getPassword()));
        return customerRepository.save(customer);
    }
}
