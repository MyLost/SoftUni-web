package com.softuni.book.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "shipping_methods")
@Getter
@Setter
public class ShippingMethodEntity extends BaseEntity {

    private String methodName;
    private Double coast;
}
