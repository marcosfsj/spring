package com.example.demo.dto;

import com.jparams.verifier.tostring.NameStyle;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.jparams.verifier.tostring.ToStringVerifier;

public class UserDtoTest {
    @Test
    @DisplayName("This test check the to string is correctly built for the tested class")
    void hasValidToString() {
        ToStringVerifier.forClasses(UserDto.class)
                .withClassName(NameStyle.CANONICAL_NAME)
                .verify();
    }
}