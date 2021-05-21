package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class PostDto {
    private Long id;
    private String description;
    @JsonIgnore
    private UserDto userDto;
}