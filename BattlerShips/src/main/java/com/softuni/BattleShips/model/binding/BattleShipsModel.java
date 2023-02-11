package com.softuni.BattleShips.model.binding;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BattleShipsModel {

    private Long attackerShip;
    private Long defenderShip;
}
