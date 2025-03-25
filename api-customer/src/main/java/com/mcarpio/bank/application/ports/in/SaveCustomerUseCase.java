package com.mcarpio.bank.application.ports.in;
import com.mcarpio.bank.application.ports.out.ICustomerRepository;
import com.mcarpio.bank.application.ports.out.IPasswordEncoder;
import com.mcarpio.bank.domain.pojos.CustomerPojo;
import com.mcarpio.bank.domain.exception.CustomerAlreadyExistsException;

public class SaveCustomerUseCase {

    private final ICustomerRepository customerRepository;
    private final IPasswordEncoder passwordEncoder;

    public SaveCustomerUseCase(ICustomerRepository customerRepository, IPasswordEncoder passwordEncoder) {
        this.customerRepository = customerRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public CustomerPojo execute(CustomerPojo customerPojo) {

        customerRepository.findByIdentification(customerPojo.getIdentification())
                .ifPresent( customer1 -> {
                    throw new CustomerAlreadyExistsException("The customerPojo with that identification is already registered.");
                });
        customerPojo.setPassword(passwordEncoder.encode(customerPojo.getPassword()));
        return customerRepository.save(customerPojo);
    }
}
