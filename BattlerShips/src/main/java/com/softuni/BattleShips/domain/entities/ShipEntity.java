package com.softuni.BattleShips.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "ships")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ShipEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    @Column(nullable = false)
    private Long Health;

    @Column(nullable = false)
    private Long power;

    @Column(nullable = false)
    private Date created;

    @ManyToOne
    private CategoryEntity category;

    @ManyToOne
    private UserEntity user;

    @Override
    public String toString() {
        return  String.format("| %s | %s  | %s | ", getName(), getHealth(), getPower());
    }
}
