package com.softuni.book.model.entity;

import com.fasterxml.jackson.databind.ser.Serializers;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "publishers")
@Getter
@Setter
public class PublisherEntity extends BaseEntity {

    @OneToMany
    private List<BookEntity> books;
    private String name;
}
