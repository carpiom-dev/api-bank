package com.mcarpio.bank.infrastructure.out.repository;

import com.mcarpio.bank.infrastructure.out.entity.CustomerEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface IJpaCustomerRepository extends JpaRepository<CustomerEntity, Integer> {

    List<CustomerEntity> findByStatusTrue();

    Optional<CustomerEntity> findByIdentification(String identification);

    @Transactional
    @Modifying
    @Query("UPDATE CustomerEntity c SET c.status = false WHERE c.customerId = :customerId")
    int disableCustomer(Integer customerId);
}
