package com.example.demo.repository;

import com.example.demo.entity.BookEntity;
import com.example.demo.entity.BookEntityMother;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class BookRepositoryTest {

    @Autowired
    BookRepository sut;

    @Test
    void saveBook() {
        BookEntity bookEntity = new BookEntityMother().getBookEntity();
        sut.save(bookEntity);
    }

}