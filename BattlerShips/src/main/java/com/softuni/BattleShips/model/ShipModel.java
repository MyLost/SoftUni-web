package com.softuni.BattleShips.model;

import com.softuni.BattleShips.domain.entities.CategoryEntity;
import com.softuni.BattleShips.domain.entities.UserEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ShipModel {

    private Long id;
    private String name;
    private Long health;
    private Long power;
    private Date created;
    private CategoryModel category;
    private UserModel user;
}
