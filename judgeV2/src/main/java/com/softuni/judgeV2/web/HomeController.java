package com.softuni.judgeV2.web;

import com.softuni.judgeV2.security.CurrentUser;
import com.softuni.judgeV2.services.CommentService;
import com.softuni.judgeV2.services.ExercisesService;
import com.softuni.judgeV2.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final CurrentUser currentUser;
    private final ExercisesService exercisesService;
    private final CommentService commentService;
    private final UserService userService;
    public HomeController(CurrentUser currentUser, ExercisesService exercisesService, CommentService commentService, UserService userService) {
        this.currentUser = currentUser;
        this.exercisesService = exercisesService;
        this.commentService = commentService;
        this.userService = userService;
    }

    @GetMapping("/")
    public String index(Model model) {

        if(currentUser.isAnonymous()) {
            return "index";
        }

        model.addAttribute("exercises", exercisesService.findAllExerciseNames());
        model.addAttribute("avg", commentService.findAvgScore());
        model.addAttribute("userCount", userService.findUsersCount());
        model.addAttribute("scoreMap", commentService.findScoreMap());

        return "home";
    }
}
