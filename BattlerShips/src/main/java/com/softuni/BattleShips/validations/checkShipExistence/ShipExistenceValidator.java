package com.softuni.BattleShips.validations.checkShipExistence;

import com.softuni.BattleShips.repositories.ShipRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ShipExistenceValidator implements ConstraintValidator<CheckShipExistence, String>  {

    private ShipRepository shipRepository;

    public ShipExistenceValidator(ShipRepository shipRepository) {
        this.shipRepository = shipRepository;
    }

    @Override
    public void initialize(CheckShipExistence constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String shipName, ConstraintValidatorContext constraintValidatorContext) {
        return this.shipRepository.findByName(shipName).isEmpty();
    }
}
