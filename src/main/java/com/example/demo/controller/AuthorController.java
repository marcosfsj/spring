package com.example.demo.controller;

import com.example.demo.dto.AuthorDto;
import com.example.demo.service.IAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class AuthorController {

    @Autowired
    IAuthorService authorService;

    @GetMapping("/authors")
    public List<AuthorDto> getAuthors() {
        return authorService.getAll();
    }

    @PostMapping("/authors")
    public ResponseEntity<Object> createNewAuthor(@Valid @RequestBody AuthorDto authorDto) {
        authorDto = authorService.save(authorDto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(authorDto.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
}