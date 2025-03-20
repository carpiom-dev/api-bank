package com.mcarpio.bank.infrastructure.in.mapper;

import com.mcarpio.bank.domain.pojos.CustomerPojo;
import com.mcarpio.bank.infrastructure.in.dto.CustomerInputDTO;
import com.mcarpio.bank.infrastructure.in.dto.CustomerOutputDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ICustomerMapperDto {

    CustomerPojo toPojo(CustomerInputDTO customerInputDTO);

    CustomerOutputDTO toDTO(CustomerPojo customerPojo);

}
