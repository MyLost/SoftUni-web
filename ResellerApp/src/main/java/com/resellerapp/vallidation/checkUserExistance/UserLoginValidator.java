package com.resellerapp.vallidation.checkUserExistance;

import com.resellerapp.model.bindings.users.LoginBindingModel;
import com.resellerapp.model.entity.UserEntity;
import com.resellerapp.service.UserService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UserLoginValidator implements ConstraintValidator<CheckUserExistence, LoginBindingModel> {

    private final UserService userService;

    public UserLoginValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void initialize(CheckUserExistence constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(LoginBindingModel model, ConstraintValidatorContext constraintValidatorContext) {
        UserEntity userModel = this.userService.findByUsername(model.getUsername());
        return userModel.getId() != null
                && userModel.getPassword().equals(model.getPassword());
    }
}
