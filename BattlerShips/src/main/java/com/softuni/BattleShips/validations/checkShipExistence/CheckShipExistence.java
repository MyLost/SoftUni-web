package com.softuni.BattleShips.validations.checkShipExistence;

import com.softuni.BattleShips.validations.checkUserExistance.UserLoginValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = ShipExistenceValidator.class)
public @interface CheckShipExistence {
    String message() default "Ship already exist";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
