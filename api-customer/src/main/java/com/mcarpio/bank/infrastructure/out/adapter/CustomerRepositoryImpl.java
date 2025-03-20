package com.mcarpio.bank.infrastructure.out.adapter;

import com.mcarpio.bank.application.ports.out.ICustomerRepository;
import com.mcarpio.bank.domain.pojos.CustomerPojo;
import com.mcarpio.bank.infrastructure.out.entity.CustomerEntity;
import com.mcarpio.bank.infrastructure.out.mapper.ICustomerMapper;
import com.mcarpio.bank.infrastructure.out.repository.IJpaCustomerRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public class CustomerRepositoryImpl implements ICustomerRepository {

    private final IJpaCustomerRepository jpaCustomerRepository;
    private final ICustomerMapper customerMapper;

    public CustomerRepositoryImpl(ICustomerMapper customerMapper,IJpaCustomerRepository jpaCustomerRepository) {
        this.customerMapper = customerMapper;
        this.jpaCustomerRepository = jpaCustomerRepository;
    }

    @Override
    public CustomerPojo save(CustomerPojo customerPojo) {
        //Objects.requireNonNull(customerPojo, "CustomerPojo cannot be null");
        return customerMapper.toDto(
                jpaCustomerRepository.save(customerMapper.toEntity(customerPojo))
        );
    }

    @Override
    public CustomerPojo update(CustomerPojo customerPojo) {
        return null;
    }

    @Override
    public List<CustomerPojo> findAll() {
        return jpaCustomerRepository.findAll().stream()
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
