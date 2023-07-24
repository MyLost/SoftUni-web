package com.softuni.book.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Getter
@Setter
@Table(name = "books")
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookEntity extends BaseEntity {

    private String title;
    private String isbn;
    @ManyToOne
    private AuthorEntity author;
}
