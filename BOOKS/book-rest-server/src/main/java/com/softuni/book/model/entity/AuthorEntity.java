package com.softuni.book.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@ToString
@Table(name = "authors")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthorEntity extends BaseEntity {

    private String name;
    @OneToMany(mappedBy = "author")
    private List<BookEntity> books;
}
