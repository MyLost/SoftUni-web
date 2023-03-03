package com.softuni.judgeV2.web;

import com.softuni.judgeV2.mappers.UserMapper;
import com.softuni.judgeV2.models.bindings.UserLoginBindingModel;
import com.softuni.judgeV2.models.bindings.UserRegisterBindingModel;
import com.softuni.judgeV2.models.dtos.UserDto;
import com.softuni.judgeV2.security.CurrentUser;
import com.softuni.judgeV2.services.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    private final UserMapper userMapper;

    private final CurrentUser currentUser;

    public UserController(UserService userService, CurrentUser currentUser) {
        this.userService = userService;
        this.currentUser = currentUser;
        this.userMapper = Mappers.getMapper(UserMapper.class);;
    }

    @GetMapping("/login")
    public String login(Model model) {
        if(!model.containsAttribute("userLoginBindingModel")) {
            model.addAttribute("userLoginBindingModel", new UserLoginBindingModel());
            model.addAttribute("notFound", false);
        }
        return "login";
    }

    @PostMapping("/login")
    public String loginConfirm(@Valid @ModelAttribute UserLoginBindingModel userLoginBindingModel,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes,
                               HttpSession httpSession){

        if(bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userLoginBindingModel", userLoginBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userLoginBindingModel", bindingResult);
            return "redirect:login";
        }

        UserDto user =
                userService.findUserByUsernameAndPassword(userLoginBindingModel.getUsername(), userLoginBindingModel.getPassword());

//        httpSession.setAttribute("user", user);

        if(user == null) {
            redirectAttributes.addFlashAttribute("userLoginBindingModel", userLoginBindingModel);
            redirectAttributes.addFlashAttribute("notFound", true);

            return "redirect:login";
        }

        userService.login(user);
        return "redirect:/";

    }

    @GetMapping("/register")
    public String register(Model model) {
        if(!model.containsAttribute("userRegisterBindingModel")) {
            model.addAttribute("userRegisterBindingModel", new UserRegisterBindingModel());
        }
        return "register";
    }

    @PostMapping("/register")
    public String registerConfirm(@Valid @ModelAttribute UserRegisterBindingModel userRegisterBindingModel,
                                  BindingResult bindingResult,
                                  RedirectAttributes redirectAttributes) {

        if(bindingResult.hasErrors() ||
                !userRegisterBindingModel.getPassword().equals(userRegisterBindingModel.getConfirmPassword())) {
            redirectAttributes.addFlashAttribute("userRegisterBindingModel", userRegisterBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userRegisterBindingModel", bindingResult);
            return "redirect:register";
        }

        UserDto dto = userMapper.modelToDto(userRegisterBindingModel);
        userService.registerUser(dto);

        return "redirect:login";
    }

    @GetMapping("/logout")
    public String logout() {

        userService.logout();
        return "redirect:/";
    }

    @GetMapping("/profile/{id}")
    public String profilePath(@PathVariable Long id, Model model) {

        if(currentUser.isAnonymous()) {
            return "redirect:/login";
        }

        model.addAttribute("user", userService.findProfileById(id));
        return "profile";
    }

//    @GetMapping("/profile")
//    public String profileQuery(@RequestParam Long id) {
//        return "redirect:/";
//    }

}
