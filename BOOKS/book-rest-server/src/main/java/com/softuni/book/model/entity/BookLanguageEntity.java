package com.softuni.book.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="languages")
@Getter
@Setter
public class BookLanguageEntity extends BaseEntity {

    private String languageCode;
    private String languageName;
    @OneToMany
    private List<BookEntity> books;
}
