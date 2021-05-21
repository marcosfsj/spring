package com.example.demo.service;

import com.example.demo.dto.AuthorDto;

import java.util.List;

public interface IAuthorService {
    public AuthorDto save(AuthorDto authorDto);
    public List<AuthorDto> getAll();
}
