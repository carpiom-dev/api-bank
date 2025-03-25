package com.mcarpio.bank.infrastructure.in.api;

import com.mcarpio.bank.infrastructure.in.Handler.CustomerHandler;
import com.mcarpio.bank.infrastructure.in.dto.CustomerInDTO;
import com.mcarpio.bank.infrastructure.in.dto.CustomerOutDTO;
import com.mcarpio.bank.infrastructure.in.dto.CustomerUpdateInDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("customers")
public class CustomerApi {

    private final CustomerHandler customerHandler;

    public CustomerApi(CustomerHandler customerHandler) {
        this.customerHandler = customerHandler;
    }

    @Operation(summary = "Get all customers", description = "Retrieve a list of all customers.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved list of customers"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping
    public ResponseEntity<List<CustomerOutDTO>> findAll() {
        return ResponseEntity.ok(customerHandler.findByStatusTrue());
    }

    @Operation(summary = "Get a customer by ID", description = "Retrieve customer information based on the customer ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved customer"),
            @ApiResponse(responseCode = "404", description = "Customer not found")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Optional<CustomerOutDTO>> findById(@PathVariable Integer id) {
        return ResponseEntity.ok((customerHandler.findById(id)));
    }

    @PostMapping
    public ResponseEntity<CustomerOutDTO> save(@Valid @RequestBody CustomerInDTO customerInDTO) {
        return new ResponseEntity<>(customerHandler.save(customerInDTO), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        customerHandler.delete(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<CustomerOutDTO> update(@Valid @RequestBody CustomerUpdateInDto update) {
        return ResponseEntity.ok((customerHandler.update(update)));
    }
}
