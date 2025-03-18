package com.mcarpio.bank.customers.domain.exception;

public class CustomerNotFoundException extends RuntimeException {
    public CustomerNotFoundException(String mensaje) {
        super(mensaje);
    }

    public CustomerNotFoundException(String mensaje, Throwable cause) {
        super(mensaje, cause);
    }
}
