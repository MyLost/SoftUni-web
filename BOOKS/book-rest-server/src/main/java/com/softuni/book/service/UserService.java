package com.softuni.book.service;

import com.softuni.book.model.dtos.UserRegistrationDto;
import com.softuni.book.model.entity.UserEntity;
import com.softuni.book.repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextHolderStrategy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.stereotype.Service;

import java.util.function.Consumer;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final SecurityContextRepository securityContextRepository;
    private final UserDetailsService userDetailsService;
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, SecurityContextRepository securityContextRepository, UserDetailsService userDetailsService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.securityContextRepository = securityContextRepository;
        this.userDetailsService = userDetailsService;
    }

    public void RegisterUser(UserRegistrationDto registrationDto, Consumer<Authentication> successfulLoginProcessor) {
        UserEntity userEntity = UserEntity.builder().build();

        userRepository.save(userEntity);

        var userDetails = userDetailsService.loadUserByUsername(registrationDto.getEmail());
        Authentication authentication = new UsernamePasswordAuthenticationToken(
            userDetails, userDetails.getPassword(), userDetails.getAuthorities()
        );

        successfulLoginProcessor.accept(authentication);
    }
}
