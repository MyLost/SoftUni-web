package com.softuni.book.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "books")
@Getter
@Setter
public class BookEntity extends BaseEntity {

    private String title;
    private String isbn13;
    @ManyToOne
    private BookLanguageEntity language;
    private Long pages;
    private LocalDate publicationDate;
    @ManyToOne
    private PublisherEntity publisher;
    @ManyToMany
    private List<AuthorEntity> authors;
    @OneToMany
    private List<OrderLineEntity> orderLines;

}
