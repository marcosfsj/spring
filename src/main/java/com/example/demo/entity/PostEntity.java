package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class PostEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String description;
    @ManyToOne(fetch = FetchType.LAZY)
    private UserEntity user;
}
