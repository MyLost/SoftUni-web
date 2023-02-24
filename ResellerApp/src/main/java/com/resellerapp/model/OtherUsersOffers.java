package com.resellerapp.model;

import com.resellerapp.model.entity.ConditionEntity;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OtherUsersOffers {

    private Long id;
    private String description;

    private Double price;

    private ConditionEntity condition;
}
