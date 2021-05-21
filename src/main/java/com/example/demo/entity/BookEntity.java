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
@Table(name = "book")
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    @JoinTable(name = "books_authors",
               joinColumns = {@JoinColumn(name = "book_id", referencedColumnName = "id", nullable = false, updatable = false)},
               inverseJoinColumns = {@JoinColumn(name = "author_id", referencedColumnName = "id", nullable = false, updatable = false)})
    private List<AuthorEntity> authors = new ArrayList<>();
}
