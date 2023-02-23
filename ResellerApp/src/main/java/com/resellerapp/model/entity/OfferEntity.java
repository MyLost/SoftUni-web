package com.resellerapp.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.*;



@Entity
@Table(name = "offers")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OfferEntity extends BaseEntity {

    @Column(nullable = false)
    @Size(min = 2, max = 50)
    private String description;
    @Column(nullable = false)
    @Positive
    private Double price;
    @ManyToOne
    private UserEntity user;
    @ManyToOne
    private ConditionEntity condition;
}
