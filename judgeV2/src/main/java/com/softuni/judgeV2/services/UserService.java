package com.softuni.judgeV2.services;

import com.softuni.judgeV2.models.dtos.UserDto;
import com.softuni.judgeV2.models.dtos.UserProfileDto;
import com.softuni.judgeV2.models.entities.UserEntity;
import com.softuni.judgeV2.models.enums.RoleNameEnum;

import java.util.List;

public interface UserService {
    void registerUser(UserDto dto);

    UserDto findUserByUsernameAndPassword(String username, String password);

    void login(UserDto user);

    void logout();

    List<String> findAllUsernames();

    void changeRole(String username, RoleNameEnum roleNameEnum);

    UserEntity findById(Long id);

    UserProfileDto findProfileById(Long id);

    Long findUsersCount();
}
