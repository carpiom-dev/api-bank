package com.mcarpio.bank.customers.domain.exception;

public class CustomerAlreadyExistsException extends RuntimeException {
    public CustomerAlreadyExistsException(String mensaje) {
        super(mensaje);
    }

    public CustomerAlreadyExistsException(String mensaje, Throwable cause) {
        super(mensaje, cause);
    }
}
