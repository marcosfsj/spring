package com.example.demo.entity;

public class AuthorEntityMother {

    public AuthorEntity getAuthorEntity() {
        return AuthorEntity.builder()
                .id(1L)
                .name("Marcos Fernandes")
                .build();
    }

}
