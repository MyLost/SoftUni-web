package com.resellerapp.service.impl;

import com.resellerapp.model.UserDto;
import com.resellerapp.model.bindings.users.LoginBindingModel;
import com.resellerapp.model.bindings.users.RegisterBindingModel;
import com.resellerapp.model.entity.UserEntity;
import com.resellerapp.model.helpers.LoggedUser;
import com.resellerapp.repository.UserRepository;
import com.resellerapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final LoggedUser loggedUser;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, LoggedUser loggedUser) {
        this.userRepository = userRepository;
        this.loggedUser = loggedUser;
    }


    @Override
    public void registerUser(RegisterBindingModel registerBindingModel) {

        UserEntity userEntity = UserEntity.builder()
                .username(registerBindingModel.getUsername())
                .email(registerBindingModel.getEmail())
                .password(registerBindingModel.getPassword())
                .build();

        userRepository.saveAndFlush(userEntity);
    }

    @Override
    public void loginUser(LoginBindingModel loginBindingModel) {

        UserEntity user = userRepository.findByUsername(loginBindingModel.getUsername()).orElseThrow();
        loggedUser.setId(user.getId());
    }

    @Override
    public UserEntity findByUsername(String username) {
        UserEntity user = userRepository.findByUsername(username).orElseThrow();
        return user;
    }

    @Override
    public UserDto findById(Long id) {
        UserEntity entity = userRepository.findById(id).orElseThrow();

        return UserDto.builder()
                .username(entity.getUsername())
                .email(entity.getEmail())
                .boughtOffers(entity.getBoughtOffers())
                .offers(entity.getOffers())
                .build();
    }
}
