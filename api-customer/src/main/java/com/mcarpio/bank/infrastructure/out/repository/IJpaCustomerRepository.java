package com.mcarpio.bank.infrastructure.out.repository;

import com.mcarpio.bank.infrastructure.out.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IJpaCustomerRepository extends JpaRepository<CustomerEntity, Integer> {
    Optional<CustomerEntity> findByIdentification(String identification);
}
