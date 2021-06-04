package com.example.demo.entity;

import java.util.List;

public class UserEntityMother {

    public static UserEntity getUserEntity() {
        return UserEntity.builder()
                .id(1L)
                .firstName("Marcos")
                .lastName("Fernandes")
                .posts(List.of(PostEntityMother.getPostEntity()))
                .build();
    }

}
