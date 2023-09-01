package com.softuni.book.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@Slf4j
public class LoginController {

    @GetMapping("/users/login")
    public String login() {
        // TODO make login
        return "auth-login";
    }

//    @PostMapping("/users/login-error")
//    public String onFailedLogin(
//            @ModelAttribute(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_USERNAME_KEY) String username,
//            RedirectAttributes redirectAttributes) {
//        // TODO make redirect
//        redirectAttributes.addFlashAttribute("bad_credentials", true);
//
//        return "redirect:/users/login";
//    }
}
