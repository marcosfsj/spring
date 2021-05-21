package com.example.demo.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Builder
@Entity
@Table(name = "author")
public class AuthorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @ManyToMany(mappedBy = "authors", fetch = FetchType.LAZY)
    private List<BookEntity> booksAuthored = new ArrayList<>();
    @OneToOne
    @JoinColumn(name = "address_id")
    private AddressEntity address;
}
