package com.softuni.BattleShips.services;

import com.softuni.BattleShips.domain.entities.UserEntity;
import com.softuni.BattleShips.domain.helpers.LoggedUser;
import com.softuni.BattleShips.model.binding.UserLoginModel;
import com.softuni.BattleShips.model.binding.UserRegisterModel;
import com.softuni.BattleShips.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final LoggedUser loggedUser;

    public AuthService(UserRepository userRepository, ModelMapper modelMapper, LoggedUser loggedUser) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.loggedUser = loggedUser;
    }

    public void registerUser(UserRegisterModel userRegisterModel) {
        this.userRepository.saveAndFlush(this.modelMapper.map(userRegisterModel, UserEntity.class));
    }

    public void loginUser(UserLoginModel userLoginModel) {
        UserEntity user = this.userRepository.findByUsername(userLoginModel.getUsername()).get();
        this.loggedUser.setId(user.getId());
    }

    public void logout() {
        this.loggedUser.cleanUser();
    }
}
