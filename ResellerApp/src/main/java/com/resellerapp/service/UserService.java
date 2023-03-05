package com.resellerapp.service;

import com.resellerapp.model.UserDto;
import com.resellerapp.model.bindings.users.LoginBindingModel;
import com.resellerapp.model.bindings.users.RegisterBindingModel;
import com.resellerapp.model.entity.UserEntity;

public interface UserService {

    void registerUser(RegisterBindingModel registerBindingModel);

    void loginUser(LoginBindingModel loginBindingModel);

    UserEntity findByUsername(String username);

    UserDto findById(Long id);

}
