package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "book")
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    private String title;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    @JoinTable(name = "books_authors",
               joinColumns = {@JoinColumn(name = "book_id", referencedColumnName = "id", nullable = false, updatable = false)},
               inverseJoinColumns = {@JoinColumn(name = "author_id", referencedColumnName = "id", nullable = false, updatable = false)})
    private Set<AuthorEntity> authors = new HashSet<>();
}
