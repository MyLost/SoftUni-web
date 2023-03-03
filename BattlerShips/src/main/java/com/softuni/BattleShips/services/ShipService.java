package com.softuni.BattleShips.services;

import com.softuni.BattleShips.domain.entities.ShipEntity;
import com.softuni.BattleShips.domain.helpers.LoggedUser;
import com.softuni.BattleShips.model.CategoryModel;
import com.softuni.BattleShips.model.ShipModel;
import com.softuni.BattleShips.model.UserModel;
import com.softuni.BattleShips.model.binding.ShipRegisterModel;
import com.softuni.BattleShips.repositories.ShipRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShipService {

    private final ShipRepository shipRepository;
    private final UserService userService;
    private final ModelMapper modelMapper;
    private final LoggedUser loggedUser;
    private final CategoryService categoryService;

    public ShipService(ShipRepository shipRepository, UserService userService, ModelMapper modelMapper, LoggedUser loggedUser, CategoryService categoryService) {
        this.shipRepository = shipRepository;
        this.userService = userService;
        this.modelMapper = modelMapper;
        this.loggedUser = loggedUser;
        this.categoryService = categoryService;
    }

    public void addShip(ShipRegisterModel shipRegisterModel) {
        UserModel user = this.userService.findById(loggedUser.getId());
        CategoryModel category = this.categoryService.findByName(shipRegisterModel.getCategory());

        ShipEntity ship = modelMapper.map(ShipModel.builder()
                .name(shipRegisterModel.getName())
                .power(shipRegisterModel.getPower())
                .created(shipRegisterModel.getCreated())
                .health(shipRegisterModel.getHealth())
                .category(category)
                .user(user)
                .build(), ShipEntity.class);

        this.shipRepository.saveAndFlush(ship);
    }

    public List<ShipModel> findAllByUserId(Long id) {
        List<ShipEntity> ships = this.shipRepository.findAllByUserId(id).orElseThrow();
        return ships.stream().map(ship -> modelMapper.map(ship, ShipModel.class)).toList();
    }
}
