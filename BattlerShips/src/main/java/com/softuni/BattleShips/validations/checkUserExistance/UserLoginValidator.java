package com.softuni.BattleShips.validations.checkUserExistance;

import com.softuni.BattleShips.model.UserModel;
import com.softuni.BattleShips.model.binding.UserLoginModel;
import com.softuni.BattleShips.services.UserService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UserLoginValidator implements ConstraintValidator<CheckUserExistence, UserLoginModel> {

    private final UserService userService;

    public UserLoginValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void initialize(CheckUserExistence constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(UserLoginModel userLoginModel, ConstraintValidatorContext constraintValidatorContext) {
        UserModel userModel = this.userService.findByUsername(userLoginModel.getUsername());
        return userModel.getId() != null
                && userModel.getPassword().equals(userLoginModel.getPassword());
    }
}
