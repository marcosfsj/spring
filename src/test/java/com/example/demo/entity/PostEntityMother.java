package com.example.demo.entity;

public class PostEntityMother {

    public static PostEntity getPostEntity() {
        return PostEntity.builder()
                .id(1L)
                .description("bla bla bla")
                .build();
    }

}
