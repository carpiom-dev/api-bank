package com.mcarpio.bank.infrastructure.out.adapter;

import com.mcarpio.bank.application.ports.out.IPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

@Repository
public class PasswordEncoderRepositoryImpl implements IPasswordEncoder {

    private final PasswordEncoder passwordEncoder;

    public PasswordEncoderRepositoryImpl(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public String encode(String rawPassword) {
        return passwordEncoder.encode(rawPassword);
    }

    @Override
    public boolean matches(String rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }
}
