package com.mcarpio.bank.domain.exception;

public class CustomerNotFoundException extends RuntimeException {
    public CustomerNotFoundException(String mensaje) {
        super(mensaje);
    }

    public CustomerNotFoundException(String mensaje, Throwable cause) {
        super(mensaje, cause);
    }
}
