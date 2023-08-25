package com.softuni.book.service;

import com.softuni.book.model.dtos.UserRegistrationDto;
//import com.softuni.book.model.entity.UserEntity;
//import com.softuni.book.repository.UserRepository;
import com.softuni.book.model.entity.UserEntity;
import com.softuni.book.repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;

import java.util.function.Consumer;

@Service
public class UserService {

    private final UserRepository userRepository;
//    private final PasswordEncoder passwordEncoder;
//    private final SecurityContextRepository securityContextRepository;
//    private final UserDetailsService userDetailsService;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
//        this.passwordEncoder = passwordEncoder;
//        this.securityContextRepository = securityContextRepository;
//        this.userDetailsService = userDetailsService;
    }

//    public void RegisterUser(UserRegistrationDto registrationDto, Consumer<Authentication> successfulLoginProcessor) {
//        UserEntity userEntity = UserEntity.builder().build();
//
//        userRepository.save(userEntity);
//
//        var userDetails = userDetailsService.loadUserByUsername(registrationDto.getEmail());
//        Authentication authentication = new UsernamePasswordAuthenticationToken(
//            userDetails, userDetails.getPassword(), userDetails.getAuthorities()
//        );
//
//        successfulLoginProcessor.accept(authentication);
//    }
}
