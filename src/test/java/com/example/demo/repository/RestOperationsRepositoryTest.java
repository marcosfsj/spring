package com.example.demo.repository;

import com.example.demo.entity.QuoteEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RestOperationsRepositoryTest {

    @Autowired
    RestOperationsRepository restOperationsRepository;

    @Test
    void willFetchAQuote() {
        QuoteEntity quoteEntity = restOperationsRepository.fetchQuote();
        assertEquals(1, 1);
        assertNotEquals(quoteEntity, null);
    }

}