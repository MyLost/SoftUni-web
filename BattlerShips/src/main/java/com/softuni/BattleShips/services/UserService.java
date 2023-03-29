package com.softuni.BattleShips.services;

import com.softuni.BattleShips.domain.helpers.LoggedUser;
import com.softuni.BattleShips.model.UserModel;
import com.softuni.BattleShips.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private LoggedUser loggedUser;
    public UserService(UserRepository userRepository, ModelMapper modelMapper, LoggedUser loggedUser) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.loggedUser = loggedUser;
    }


    public UserModel findByUsername(String username) {
        UserEntity userEntity = this.userRepository.findByUsername(username).orElse(new UserEntity());
        UserModel userModel = this.modelMapper.map(userEntity, UserModel.class);
        return userModel;
    }

    public UserModel findById(long id) {
        UserEntity userEntity = this.userRepository.findById(id).orElse(new UserEntity());
        UserModel userModel = this.modelMapper.map(userEntity, UserModel.class);
        return userModel;
    }

    public UserModel findByIdNot(long id) {
        UserEntity userEntity = this.userRepository.findByIdNot(id).orElse(new UserEntity());
        UserModel userModel = this.modelMapper.map(userEntity, UserModel.class);
        return userModel;
    }
}
