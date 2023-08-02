package com.softuni.book.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "books")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookEntity extends BaseEntity {

    private String title;
    private String isbn;
    @ManyToOne
    private AuthorEntity author;
}
