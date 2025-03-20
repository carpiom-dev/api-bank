package com.mcarpio.bank.infrastructure.out.mapper;
import com.mcarpio.bank.domain.pojos.CustomerPojo;
import com.mcarpio.bank.infrastructure.out.entity.CustomerEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Primary;

@Primary
@Mapper(componentModel = "spring")
public interface ICustomerMapper {
    
    CustomerPojo toDto(CustomerEntity entity);

    CustomerEntity toEntity(CustomerPojo pojo);
}
