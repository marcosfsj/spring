package com.example.demo.controller;

import com.example.demo.dto.BookDto;
import com.example.demo.dto.UserDto;
import com.example.demo.exception.NotFoundException;
import com.example.demo.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class BookController {

    @Autowired
    IBookService bookService;

    @GetMapping("/books")
    public List<BookDto> getBooks() {
        return bookService.getAll();
    }

    @PostMapping("/books")
    public ResponseEntity<Object> createNewBook(@Valid @RequestBody BookDto bookDto) {
        bookDto = bookService.save(bookDto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(bookDto.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
}