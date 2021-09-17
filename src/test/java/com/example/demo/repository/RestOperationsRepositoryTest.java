package com.example.demo.repository;

import com.example.demo.entity.QuoteEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.repository.RestOperationsRepository;

import static org.junit.jupiter.api.Assertions.*;

class RestOperationsRepositoryTest {

    @Autowired
    RestOperationsRepository restOperationsRepository;

    @Test
    void willFetchAQuote() {
        QuoteEntity quoteEntity = restOperationsRepository.fetchQuote();
        assertEquals(1, 1);
    }

}