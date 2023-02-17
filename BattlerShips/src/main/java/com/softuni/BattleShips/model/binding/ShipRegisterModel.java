package com.softuni.BattleShips.model.binding;

import com.softuni.BattleShips.domain.enums.CategoryType;
import com.softuni.BattleShips.validations.checkShipExistence.CheckShipExistence;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ShipRegisterModel {

    @NotNull
    @Size(min = 2, max = 10)
    @CheckShipExistence
    private String name;
    @Positive
    @NotNull
    private Long health;

    @NotNull
    @Positive
    private Long power;
    @NotNull
    @PastOrPresent
    private Date created;
    @NotNull
    private CategoryType category;
}
