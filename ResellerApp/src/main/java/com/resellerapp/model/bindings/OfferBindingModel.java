package com.resellerapp.model.bindings;

import com.resellerapp.model.enums.ConditionNames;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OfferBindingModel {

    @Size(min = 2, max = 50)
    @NotNull
    private String description;

    @Positive
    @NotNull
    private Double price;

    private ConditionNames condition;

}
