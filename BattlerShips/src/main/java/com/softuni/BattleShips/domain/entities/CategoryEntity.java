package com.softuni.BattleShips.domain.entities;

import com.softuni.BattleShips.domain.enums.CategoryType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "categories")
@Setter
@Getter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.ORDINAL)
    @Column(unique = true, nullable = false)
    private CategoryType name;

    @Column(columnDefinition = "TEXT")
    private String description;
}
