package com.softuni.book.web;

import com.softuni.book.model.dtos.UserRegistrationDto;
import com.softuni.book.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextHolderStrategy;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class UserRegistrationController {

    private final UserService userService;
    private final SecurityContextRepository securityContextRepository;

    public UserRegistrationController(UserService userService, SecurityContextRepository securityContextRepository) {
        this.userService = userService;
        this.securityContextRepository = securityContextRepository;
    }

    @GetMapping("/users/register")
    public String register() {
        return "auth-register";
    }

    @PostMapping("/users/register")
    public String registerUser(@RequestBody UserRegistrationDto userRegistrationDto, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        userService.RegisterUser(userRegistrationDto, successfulAuth -> {

            //populate security context
            SecurityContextHolderStrategy strategy = SecurityContextHolder.getContextHolderStrategy();
            SecurityContext context = strategy.createEmptyContext();
            context.setAuthentication(successfulAuth);
            strategy.setContext(context);

            securityContextRepository.saveContext(context, httpServletRequest, httpServletResponse);
        });
        return "auth-register";
    }
}

