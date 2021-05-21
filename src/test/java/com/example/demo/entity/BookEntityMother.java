package com.example.demo.entity;

import java.util.List;

public class BookEntityMother {

    public BookEntity getBookEntity() {
        return BookEntity.builder()
                .id(1L)
                .title("Java how to program")
                .authors(List.of(new AuthorEntityMother().getAuthorEntity()))
                .build();
    }

}
