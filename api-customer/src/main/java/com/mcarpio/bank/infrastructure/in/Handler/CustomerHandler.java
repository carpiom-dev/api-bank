package com.mcarpio.bank.infrastructure.in.Handler;
import com.mcarpio.bank.application.ports.in.*;
import com.mcarpio.bank.infrastructure.in.dto.CustomerInDTO;
import com.mcarpio.bank.infrastructure.in.dto.CustomerOutDTO;
import com.mcarpio.bank.infrastructure.in.dto.CustomerUpdateInDto;
import com.mcarpio.bank.infrastructure.in.mapper.ICustomerMapperDtoImpl;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;

@Component
public class CustomerHandler {

    private final FindAllCustomerUseCase findAllCustomerUseCase;
    private final FindCustomerByIdUseCase findCustomerByIdUseCase;
    private final SaveCustomerUseCase saveCustomerUseCase;
    private final ICustomerMapperDtoImpl customerMapperDto;
    private final FindByStatusTrueCustomerUseCase findByStatusTrueCustomerUseCase;
    private final DeleteCustomerByIdUseCase deleteCustomerByIdUseCase;
    private final UpdateCustomerUseCase updateCustomerUseCase;


    public CustomerHandler(FindAllCustomerUseCase findAllCustomerUseCase,
                           FindCustomerByIdUseCase findCustomerByIdUseCase,
                           SaveCustomerUseCase saveCustomerUseCase,
                           ICustomerMapperDtoImpl customerMapperDto,
                           FindByStatusTrueCustomerUseCase finndByStatusTrueCustomerUseCase,
                           DeleteCustomerByIdUseCase deleteCustomerByIdUseCase,
                           UpdateCustomerUseCase updateCustomerUseCase) {
        this.findAllCustomerUseCase = findAllCustomerUseCase;
        this.findCustomerByIdUseCase = findCustomerByIdUseCase;
        this.saveCustomerUseCase = saveCustomerUseCase;
        this.customerMapperDto = customerMapperDto;
        this.findByStatusTrueCustomerUseCase = finndByStatusTrueCustomerUseCase;
        this.deleteCustomerByIdUseCase = deleteCustomerByIdUseCase;
        this.updateCustomerUseCase = updateCustomerUseCase;
    }

    public List<CustomerOutDTO> findAll() {
        return findAllCustomerUseCase.execute().stream()
                .map(customerMapperDto::toDTO)
                .toList();
    }

    public List<CustomerOutDTO> findByStatusTrue() {
        return findByStatusTrueCustomerUseCase.execute().stream()
                .map(customerMapperDto::toDTO)
                .toList();
    }

    public Optional<CustomerOutDTO> findById(Integer id) {
        return findCustomerByIdUseCase.execute(id)
                .map(customerMapperDto::toDTO);
    }

    public CustomerOutDTO save(CustomerInDTO customerInDTO) {
        var customerPojo = customerMapperDto.toPojo(customerInDTO);
        return customerMapperDto.toDTO(saveCustomerUseCase.execute(customerPojo));
    }

    public void delete(Integer customerId) {
        deleteCustomerByIdUseCase.execute(customerId);
    }

    public CustomerOutDTO update(CustomerUpdateInDto customerUpdateDto) {
        var customerPojo = customerMapperDto.toPojo(customerUpdateDto);
        return customerMapperDto.toDTO(updateCustomerUseCase.execute(customerPojo));
    }
}
