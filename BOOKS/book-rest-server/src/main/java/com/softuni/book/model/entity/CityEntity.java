package com.softuni.book.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "cities")
@Entity
public class CityEntity extends BaseEntity {

    private String name;
}
