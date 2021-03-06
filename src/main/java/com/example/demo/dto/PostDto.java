package com.example.demo.dto;

import lombok.*;

@Setter
@Getter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PostDto {
    private Long id;
    private String description;
}