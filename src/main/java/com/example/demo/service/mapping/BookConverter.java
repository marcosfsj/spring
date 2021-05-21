package com.example.demo.service.mapping;

import com.example.demo.dto.AuthorDto;
import com.example.demo.dto.BookDto;
import com.example.demo.entity.AuthorEntity;
import com.example.demo.entity.BookEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookConverter {

    public BookDto entityToDto(BookEntity bookEntity) {
        BookDto bookDto = new BookDto();
        bookDto.setId(bookEntity.getId());
        bookDto.setTitle(bookEntity.getTitle());
        //userDto.setPosts(postConverter.entityToDto(userEntity.getPosts()));
        return bookDto;
    }

    public List<BookDto> entityToDto(List<BookEntity> bookEntityList) {
        return bookEntityList.stream().map(this::entityToDto).collect(Collectors.toList());
    }

    public BookEntity dtoToEntity(BookDto bookDto) {
        BookEntity bookEntity = new BookEntity();
        bookEntity.setId(bookDto.getId());
        bookEntity.setTitle(bookDto.getTitle());
        for (AuthorDto authorDto : bookDto.getAuthors()) {
            AuthorEntity authorEntity = new AuthorEntity();
            authorEntity.setId(authorDto.getId());
            bookEntity.getAuthors().add(authorEntity);
        }
        return bookEntity;
    }

    public List<BookEntity> dtoToEntity(List<BookDto> bookDtoList) {
        return bookDtoList.stream().map(this::dtoToEntity).collect(Collectors.toList());
    }

}
