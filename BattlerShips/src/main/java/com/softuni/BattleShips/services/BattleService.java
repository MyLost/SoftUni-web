package com.softuni.BattleShips.services;

import com.softuni.BattleShips.domain.helpers.LoggedUser;
import com.softuni.BattleShips.model.ShipModel;
import com.softuni.BattleShips.model.UserModel;
import com.softuni.BattleShips.model.UserWithShipsModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BattleService {

    private final UserService userService;

    private final ShipService shipService;

    private final LoggedUser loggedUser;

    public BattleService(UserService userService, ShipService shipService, LoggedUser loggedUser) {
        this.userService = userService;
        this.shipService = shipService;
        this.loggedUser = loggedUser;
    }

    public UserWithShipsModel getLoggedUserWIthShips() {
        UserModel user = this.userService.findById(this.loggedUser.getId());
        List<ShipModel> ships = this.shipService.findAllByUserId(this.loggedUser.getId());
        return UserWithShipsModel.builder()
                .userModel(user)
                .shipModelList(ships)
                .build();
    }

    public UserWithShipsModel getNotLoggedUserWIthShips(Long id) {
        UserModel user = this.userService.findByIdNot(id);
        List<ShipModel> ships = this.shipService.findAllByUserId(id);
        return UserWithShipsModel.builder()
                .userModel(user)
                .shipModelList(ships)
                .build();
    }

}
