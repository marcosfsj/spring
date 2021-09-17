package com.example.demo.repository;

import com.example.demo.configuration.RestOperationsConfig;
import com.example.demo.entity.QuoteEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestOperations;

@Repository
public class RestOperationsRepository {

    private final RestOperations restOperations;
    private final RestOperationsConfig restOperationsConfig;

    @Autowired
    public RestOperationsRepository(RestOperations restOperations, RestOperationsConfig restOperationsConfig) {
        this.restOperations = restOperations;
        this.restOperationsConfig = restOperationsConfig;
    }

    public QuoteEntity fetchQuote() {
        return restOperations.getForObject(restOperationsConfig.getQuoteUri(), QuoteEntity.class);
    }

}
