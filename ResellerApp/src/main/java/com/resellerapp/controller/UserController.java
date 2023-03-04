package com.resellerapp.controller;

import com.resellerapp.model.bindings.users.LoginBindingModel;
import com.resellerapp.model.bindings.users.RegisterBindingModel;
import com.resellerapp.model.helpers.LoggedUser;
import com.resellerapp.service.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/auth")
public class UserController {

    private final LoggedUser loggedUser;
    private final UserService userService;

    public UserController(LoggedUser loggedUser, UserService userService) {
        this.loggedUser = loggedUser;
        this.userService = userService;
    }


    @GetMapping("/login")
    public String login(Model model) {

        if(!model.containsAttribute("loginBindingModel")) {
            model.addAttribute("loginBindingModel", new LoginBindingModel());
        }
        return "login";
    }


    @PostMapping("/login")
    public String loginConfirm(@Valid @ModelAttribute LoginBindingModel loginBindingModel,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("loginBindingModel", loginBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.loginBindingModel", bindingResult);
            return "redirect:login";
        }

        userService.loginUser(loginBindingModel);

        if (loggedUser.getId() == null) {
            return "redirect:login";
        }

        return "redirect:/home";
    }


    @GetMapping("/register")
    public String register(Model model) {
        if(!model.containsAttribute("registerBindingModel")) {
            model.addAttribute("registerBindingModel", new RegisterBindingModel());
        }
        return "register";
    }

    @PostMapping("/register")
    public String registerConfirm(@Valid @ModelAttribute RegisterBindingModel registerBindingModel,
                                  BindingResult bindingResult,
                                  RedirectAttributes redirectAttributes) {

        if(bindingResult.hasErrors() ||
                !registerBindingModel.getPassword().equals(registerBindingModel.getConfirmPassword())) {
            redirectAttributes.addFlashAttribute("registerBindingModel", registerBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.registerBindingModel", bindingResult);
            return "redirect:register";
        }

        this.userService.registerUser(registerBindingModel);

        return "redirect:login";
    }

    @GetMapping("/logout")
    public String logout() {
        //clear user data service -> logout
        return "redirect:/";
    }
}
