package com.softuni.judgeV2.web;

import com.softuni.judgeV2.models.enums.RoleNameEnum;
import com.softuni.judgeV2.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/roles")
public class RoleController {

    private final UserService userService;

    public RoleController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("names", userService.findAllUsernames());
        return "role-add";
    }

    @PostMapping("/add")
    public String addConfirm(@RequestParam String username, @RequestParam String role) {

        userService.changeRole(username, RoleNameEnum.valueOf(role.toUpperCase()));

        return "redirect:/";
    }
}
