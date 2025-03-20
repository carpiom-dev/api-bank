package com.mcarpio.bank.infrastructure.out.mapper;
import com.mcarpio.bank.domain.pojos.CustomerPojo;
import com.mcarpio.bank.infrastructure.out.entity.CustomerEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ICustomerMapper {

    CustomerPojo toDto(CustomerEntity entity);

    CustomerEntity toEntity(CustomerPojo pojo);
}
