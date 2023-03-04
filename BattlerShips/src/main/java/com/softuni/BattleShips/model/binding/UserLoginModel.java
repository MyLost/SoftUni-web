package com.softuni.BattleShips.model.binding;

import com.softuni.BattleShips.validations.checkUserExistance.CheckUserExistence;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@CheckUserExistence
public class UserLoginModel {

    @Size(min=3, max = 10)
    private String username;

    @Size(min=3)
    private String password;
}
