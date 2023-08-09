package com.softuni.book.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "statuses")
@Getter
@Setter
public class AddressStatusEntity extends BaseEntity {

    private String status;
    @OneToMany
    private List<CustomerAddressEntity> customerAddresses;
}
