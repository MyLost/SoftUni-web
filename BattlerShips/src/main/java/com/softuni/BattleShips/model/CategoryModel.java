package com.softuni.BattleShips.model;

import com.softuni.BattleShips.domain.enums.CategoryType;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryModel {

    private Long id;

    private CategoryType name;

    private String description;
}
