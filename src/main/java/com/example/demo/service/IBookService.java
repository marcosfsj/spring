package com.example.demo.service;

import com.example.demo.dto.BookDto;

import java.util.List;

public interface IBookService {
    public BookDto save(BookDto bookDto);
    public List<BookDto> getAll();
}
