package com.example.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestOperations;

@Repository
public class RestOperationsRepository {

    private final RestOperations restOperations;

    @Autowired
    public RestOperationsRepository(RestOperations restOperations) {
        this.restOperations = restOperations;
    }


}
