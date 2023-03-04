package com.resellerapp.model;

import com.resellerapp.model.entity.ConditionEntity;
import com.resellerapp.model.entity.UserEntity;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Positive;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserOfferDTO {

    private String description;

    private Double price;

    private ConditionEntity condition;
}
