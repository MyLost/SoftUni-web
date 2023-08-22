package com.softuni.book.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name="orders")
public class OrderEntity extends AwareEntity {

    private LocalDate orderDate;
    @ManyToOne
    private CustomerEntity customer;
    @ManyToOne
    private AddressEntity address;
    @ManyToOne
    private ShippingMethodEntity shippingMethod;
}
