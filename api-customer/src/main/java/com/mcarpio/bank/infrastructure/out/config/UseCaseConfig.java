package com.mcarpio.bank.infrastructure.out.config;

import com.mcarpio.bank.application.ports.in.FindAllCustomerUseCase;
import com.mcarpio.bank.application.ports.in.FindCustomerByIdUseCase;
import com.mcarpio.bank.application.ports.in.SaveCustomerUseCase;
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
        public FindCustomerByIdUseCase findCustomerByIdUseCase(ICustomerRepository customerRepository) {
                return new FindCustomerByIdUseCase(customerRepository);
        }

        @Bean
        public SaveCustomerUseCase saveCustomerUseCase(ICustomerRepository customerRepository, IPasswordEncoder passwordEncoder) {
                return new SaveCustomerUseCase(customerRepository, passwordEncoder);
        }
}
