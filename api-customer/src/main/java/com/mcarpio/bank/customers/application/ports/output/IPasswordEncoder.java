package com.mcarpio.bank.customers.application.ports.output;

public interface IPasswordEncoder {
    String encode(String rawPassword);
    boolean matches(String rawPassword, String encodedPassword);
}
