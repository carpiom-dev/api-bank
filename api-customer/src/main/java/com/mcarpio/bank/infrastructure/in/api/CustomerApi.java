package com.mcarpio.bank.infrastructure.in.api;

import com.mcarpio.bank.infrastructure.in.Handler.CustomerHandler;
import com.mcarpio.bank.infrastructure.in.dto.CustomerInputDTO;
import com.mcarpio.bank.infrastructure.in.dto.CustomerOutputDTO;
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
    public ResponseEntity<List<CustomerOutputDTO>> findAll() {
        return ResponseEntity.ok(customerHandler.findAll());
    }

    @Operation(summary = "Get a customer by ID", description = "Retrieve customer information based on the customer ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved customer"),
            @ApiResponse(responseCode = "404", description = "Customer not found")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Optional<CustomerOutputDTO>> findById(@PathVariable Integer id) {
        return new ResponseEntity<>(customerHandler.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CustomerOutputDTO> save(@Valid @RequestBody CustomerInputDTO customerInputDTO) {
        return new ResponseEntity<>(customerHandler.save(customerInputDTO), HttpStatus.CREATED);
    }
}
