package com.resellerapp.model.entity;


import com.resellerapp.model.enums.ConditionNames;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name="conditions")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ConditionEntity extends BaseEntity {

    @Column(unique = true, nullable = false)
    @Enumerated(EnumType.STRING)
    private ConditionNames conditionName;

    @Column(nullable = false)
    private String description;

    @OneToMany(mappedBy = "condition")
    private List<OfferEntity> offersEntityList;
}
