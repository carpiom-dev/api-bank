package com.mcarpio.bank.infrastructure.in.mapper;

import com.mcarpio.bank.domain.pojos.CustomerPojo;
import com.mcarpio.bank.infrastructure.in.dto.CustomerInDTO;
import com.mcarpio.bank.infrastructure.in.dto.CustomerOutDTO;
import com.mcarpio.bank.infrastructure.in.dto.CustomerUpdateInDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ICustomerMapperDto {

    CustomerPojo toPojo(CustomerUpdateInDto customerUpdateInDto);

    CustomerPojo toPojo(CustomerInDTO customerInDTO);

    CustomerOutDTO toDTO(CustomerPojo customerPojo);

}
