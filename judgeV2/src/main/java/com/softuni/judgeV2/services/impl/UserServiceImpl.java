package com.softuni.judgeV2.services.impl;

import com.softuni.judgeV2.mappers.UserMapper;
import com.softuni.judgeV2.models.dtos.UserDto;
import com.softuni.judgeV2.models.dtos.UserProfileDto;
import com.softuni.judgeV2.models.entities.UserEntity;
import com.softuni.judgeV2.models.enums.RoleNameEnum;
import com.softuni.judgeV2.repositories.UserRepository;
import com.softuni.judgeV2.security.CurrentUser;
import com.softuni.judgeV2.services.RoleService;
import com.softuni.judgeV2.services.UserService;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleService roleService;
    private final CurrentUser currentUser;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, RoleService roleService, CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.roleService = roleService;
        this.currentUser = currentUser;
        this.userMapper = Mappers.getMapper(UserMapper.class);
    }

    @Override
    public void registerUser(UserDto dto) {
        UserEntity user = userMapper.fromDto(dto);
        user.setRole(roleService.findRole(RoleNameEnum.USER));

        userRepository.save(user);
    }

    @Override
    public UserDto findUserByUsernameAndPassword(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password)
                .map(userMapper::entityToDto)
                .orElse(null);
    }

    @Override
    public void login(UserDto user) {
        currentUser.setId(user.getId());
        currentUser.setUsername(user.getUsername());
        currentUser.setRole(user.getRole().getName());
    }

    @Override
    public void logout() {
        currentUser.setId(null);
        currentUser.setUsername(null);
        currentUser.setRole(null);
    }

    @Override
    public List<String> findAllUsernames() {
        return userRepository.findAllUsernames();
    }

    @Override
    public void changeRole(String username, RoleNameEnum roleNameEnum) {

        Optional<UserEntity> user = userRepository.findByUsername(username);

        if(user.isPresent()) {
           if(user.get().getRole().getName() != roleNameEnum ) {
                user.get().setRole(roleService.findRole(roleNameEnum));

                userRepository.save(user.get());
           }
        }
    }

    @Override
    public UserEntity findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public UserProfileDto findProfileById(Long id) {

        UserEntity entity = userRepository.findById(id).orElse(null);

        UserProfileDto dto = userMapper.profileFromEntity(entity);
        dto.setExercises(entity.getHomeworkSet().stream()
                .map(homework -> homework.getExercise().getName()).collect(Collectors.toSet()));

        return dto;
    }

    @Override
    public Long findUsersCount() {
        return userRepository.count();
    }
}
