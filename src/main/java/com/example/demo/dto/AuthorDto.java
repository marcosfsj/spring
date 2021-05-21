package com.example.demo.dto;

import lombok.Data;

import java.util.Set;

@Data
public class AuthorDto {
    private Long id;
    private String name;
    private Set<BookDto> booksAuthored;
    private AddressDto address;
}
