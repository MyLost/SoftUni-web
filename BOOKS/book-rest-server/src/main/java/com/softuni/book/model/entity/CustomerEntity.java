package com.softuni.book.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="customers")
@Getter
@Setter
public class CustomerEntity extends BaseEntity {

    private String firstName;
    private String lastName;
    @Email
    private String email;
    @OneToMany
    private List<CustomerAddressEntity> addresses;
    @OneToMany
    private List<OrderEntity> orders;
}
