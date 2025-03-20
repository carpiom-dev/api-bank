package com.mcarpio.bank.infrastructure.in.api;

import com.mcarpio.bank.infrastructure.in.Handler.CustomerHandler;
import com.mcarpio.bank.infrastructure.in.dto.CustomerOutputDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
        var customers = customerHandler.findAll();
        return ResponseEntity.ok(customers);
    }
}
