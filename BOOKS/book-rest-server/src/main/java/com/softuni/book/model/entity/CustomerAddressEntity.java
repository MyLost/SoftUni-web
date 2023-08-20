package com.softuni.book.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "customer_address")
@Getter
@Setter
public class CustomerAddressEntity extends BaseEntity {

    @ManyToOne
    private CustomerEntity customer;
    @ManyToOne
    private AddressEntity address;
    @ManyToOne
    private AddressStatusEntity status;
}
