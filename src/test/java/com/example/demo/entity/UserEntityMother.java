package com.example.demo.entity;

public class UserEntityMother {

    public UserEntity getUserEntity() {
        return UserEntity.builder()
                .id(1L)
                .firstName("Marcos")
                .lastName("Fernandes")
                .build();
    }

}
