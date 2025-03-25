package com.mcarpio.bank.infrastructure.out.config;

import com.mcarpio.bank.application.ports.in.*;
import com.mcarpio.bank.application.ports.out.ICustomerRepository;
import com.mcarpio.bank.application.ports.out.IPasswordEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {

        @Bean
        public FindAllCustomerUseCase findAllCustomerUseCase(ICustomerRepository customerRepository) {
                return new FindAllCustomerUseCase(customerRepository);
        }

        @Bean
        public FindByStatusTrueCustomerUseCase findByStatusTrueCustomerUseCase(ICustomerRepository customerRepository) {
                return new FindByStatusTrueCustomerUseCase(customerRepository);
        }

        @Bean
        public FindCustomerByIdUseCase findCustomerByIdUseCase(ICustomerRepository customerRepository) {
                return new FindCustomerByIdUseCase(customerRepository);
        }

        @Bean
        public SaveCustomerUseCase saveCustomerUseCase(ICustomerRepository customerRepository, IPasswordEncoder passwordEncoder) {
                return new SaveCustomerUseCase(customerRepository, passwordEncoder);
        }

        @Bean
        public DeleteCustomerByIdUseCase DeleteCustomerByIdUseCase(ICustomerRepository customerRepository) {
                return new DeleteCustomerByIdUseCase(customerRepository);
        }

        @Bean
        public UpdateCustomerUseCase updateCustomerUseCase(ICustomerRepository customerRepository) {
                return new UpdateCustomerUseCase(customerRepository);
        }
}
