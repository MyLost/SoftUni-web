package com.softuni.book.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "addresses")
@Getter
@Setter
public class AddressEntity extends BaseEntity {

    private String streetNumber;
    private String streetName;
    @ManyToOne
    private CityEntity city;
    @ManyToOne
    private CountryEntity country;
    @OneToMany
    private List<CustomerAddressEntity> customerAddresses;
    @OneToMany
    private List<OrderEntity> orders;

}
