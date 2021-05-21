package com.example.demo.dto;

import lombok.Data;
import org.springframework.beans.factory.annotation.Required;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class UserDto {
    private Long id;
    @Size(min=2, message = "First Name has to be at least 2 char long")
    private String firstName;
    @Size(min=2)
    private String lastName;
    private List<PostDto> posts;
}