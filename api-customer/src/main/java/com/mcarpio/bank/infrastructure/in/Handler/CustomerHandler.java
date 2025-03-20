package com.mcarpio.bank.infrastructure.in.Handler;
import com.mcarpio.bank.application.ports.in.FindAllCustomerUseCase;
import com.mcarpio.bank.application.ports.in.FindCustomerByIdUseCase;
import com.mcarpio.bank.application.ports.in.SaveCustomerUseCase;
import com.mcarpio.bank.infrastructure.in.dto.CustomerOutputDTO;
import com.mcarpio.bank.infrastructure.in.mapper.ICustomerMapperDtoImpl;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class CustomerHandler {

    private final FindAllCustomerUseCase findAllCustomerUseCase;
    private final FindCustomerByIdUseCase findCustomerByIdUseCase;
    private final SaveCustomerUseCase saveCustomerUseCase;
    private final ICustomerMapperDtoImpl customerMapperDto;


    public CustomerHandler(FindAllCustomerUseCase findAllCustomerUseCase,
                           FindCustomerByIdUseCase findCustomerByIdUseCase,
                           SaveCustomerUseCase saveCustomerUseCase,
                           ICustomerMapperDtoImpl customerMapperDto) {
        this.findAllCustomerUseCase = findAllCustomerUseCase;
        this.findCustomerByIdUseCase = findCustomerByIdUseCase;
        this.saveCustomerUseCase = saveCustomerUseCase;
        this.customerMapperDto = customerMapperDto;
    }

    public List<CustomerOutputDTO> findAll() {
        return findAllCustomerUseCase.execute().stream()
                .map(customerMapperDto::toDTO)
                .toList();
    }
}
