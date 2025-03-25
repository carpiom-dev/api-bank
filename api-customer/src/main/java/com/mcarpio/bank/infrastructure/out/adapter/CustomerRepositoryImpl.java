package com.mcarpio.bank.infrastructure.out.adapter;

import com.mcarpio.bank.application.ports.out.ICustomerRepository;
import com.mcarpio.bank.domain.pojos.CustomerPojo;
import com.mcarpio.bank.infrastructure.out.mapper.ICustomerMapperImpl;
import com.mcarpio.bank.infrastructure.out.repository.IJpaCustomerRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public class CustomerRepositoryImpl implements ICustomerRepository {

    private final IJpaCustomerRepository jpaCustomerRepository;
    private final ICustomerMapperImpl customerMapper;

    public CustomerRepositoryImpl(IJpaCustomerRepository jpaCustomerRepository, ICustomerMapperImpl customerMapper) {
        this.jpaCustomerRepository = jpaCustomerRepository;
        this.customerMapper = customerMapper;
    }

    @Override
    public CustomerPojo save(CustomerPojo customerPojo) {
        return customerMapper.toDto(
                jpaCustomerRepository.save(customerMapper.toEntity(customerPojo))
        );
    }

    @Override
    public int disableCustomer(Integer customerId) {
        return jpaCustomerRepository.disableCustomer(customerId);
    }

    @Override
    public List<CustomerPojo> findAll() {
        return jpaCustomerRepository.findAll().stream()
                .map(customerMapper::toDto)
                .toList();
    }

    @Override
    public List<CustomerPojo> findByStatusTrue() {
        return jpaCustomerRepository.findByStatusTrue().stream()
                .map(customerMapper::toDto)
                .toList();
    }

    @Override
    public Optional<CustomerPojo> findById(Integer id) {
        return jpaCustomerRepository.findById(id)
                .map(customerMapper::toDto);
    }

    @Override
    public Optional<CustomerPojo> findByIdentification(String identification) {
        return jpaCustomerRepository.findByIdentification(identification).map(customerMapper::toDto);
    }
}
