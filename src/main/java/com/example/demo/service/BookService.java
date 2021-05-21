package com.example.demo.service;

import com.example.demo.service.mapping.BookConverter;
import com.example.demo.dto.BookDto;
import com.example.demo.entity.BookEntity;
import com.example.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService {

    @Autowired
    BookRepository bookRepository;
    @Autowired
    BookConverter bookConverter;

    public BookDto save(BookDto bookDto) {
        BookEntity bookEntity = bookRepository.save(bookConverter.dtoToEntity(bookDto));
        return bookConverter.entityToDto(bookEntity);
    }

    public List<BookDto> getAll() {
        return bookConverter.entityToDto(bookRepository.findAll());
    }

}
