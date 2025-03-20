package com.mcarpio.bank.application.ports.out;

import com.mcarpio.bank.domain.pojos.CustomerPojo;

import java.util.List;
import java.util.Optional;

public interface ICustomerRepository {
    CustomerPojo save(CustomerPojo customerPojo);
    CustomerPojo update(CustomerPojo customerPojo);
    List<CustomerPojo> findAll();
    Optional<CustomerPojo> findById(Integer id);
    Optional<CustomerPojo> findByIdentification(String identification);
}
