package com.softuni.book.service;

//import com.softuni.book.model.entity.UserEntity;
//import com.softuni.book.model.entity.UserRoleEntity;
//import com.softuni.book.model.enums.UserRoleEnum;
//import com.softuni.book.repository.UserRepository;
//import com.softuni.book.repository.UserRoleRepository;
import com.softuni.book.model.entity.UserEntity;
import com.softuni.book.model.entity.UserRoleEntity;
import com.softuni.book.model.enums.UserRoleEnum;
import com.softuni.book.repository.UserRepository;
import com.softuni.book.repository.UserRoleRepository;
import jakarta.annotation.PostConstruct;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InitService {

    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;

//    private final PasswordEncoder passwordEncoder;

    public InitService(UserRepository userRepository, UserRoleRepository userRoleRepository) {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
//        this.passwordEncoder = passwordEncoder;
    }


    @PostConstruct
    public void init() {
        initRoles();
        initUsers();
    }

    private void initRoles() {
        if(userRoleRepository.count() == 0) {
            var moderatorRole = UserRoleEntity.builder().role(UserRoleEnum.MODERATOR).build();
            UserRoleEntity adminRole = UserRoleEntity.builder().role(UserRoleEnum.ADMIN).build();
            userRoleRepository.saveAll(List.of(moderatorRole, adminRole));
        }
    }

    private void initUsers() {
        if(userRepository.count() == 0) {
            initAdmin();
            initModerator();
        }
    }

    private void initAdmin() {
//        var adminUser = UserEntity.builder()
//                .email("admin@example.com")
//                .firstName("admin")
//                .lastName("admin")
//                .password(passwordEncoder.encode("admin"))
//                .roles(userRoleRepository.findAll()).build();
//        userRepository.save(adminUser);
    }

    private void initModerator() {
//        var moderatorUser = UserEntity.builder()
//            .email("moderator@example.com")
//            .firstName("moderator")
//            .lastName("moderator")
//            .password(passwordEncoder.encode("moderator"))
//            .roles(List.of(userRoleRepository.findUserRoleEntityByRole(UserRoleEnum.MODERATOR).orElseThrow())).build();
//        userRepository.save(moderatorUser);
    }
}
