package com.softuni.judgeV2.web;

import com.softuni.judgeV2.models.bindings.HomeworkAddBindingModel;
import com.softuni.judgeV2.services.ExercisesService;
import com.softuni.judgeV2.services.HomeworkService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/homework")
public class HomeworkController {

    private final ExercisesService exercisesService;

    private final HomeworkService homeworkService;

    public HomeworkController(ExercisesService exercisesService, HomeworkService homeworkService) {
        this.exercisesService = exercisesService;
        this.homeworkService = homeworkService;
    }

    @GetMapping("/add")
    public String add(Model model) {

        if(!model.containsAttribute("homeworkAddBindingModel")){
            model.addAttribute("homeworkAddBindingModel", new HomeworkAddBindingModel());
            model.addAttribute("isLate", false);
        }
        model.addAttribute("exNames", exercisesService.findAllExerciseNames());

        return "homework-add";
    }

    @PostMapping("/add")
    private String addConfirm(@Valid HomeworkAddBindingModel homeworkAddBindingModel,
                              BindingResult bindingResult,
                              RedirectAttributes redirectAttributes) {

        if(bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("homeworkAddBindingModel", homeworkAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.homeworkAddBindingModel", bindingResult);

            return "redirect:add";
        }

        boolean isLate = exercisesService.check(homeworkAddBindingModel.getExercise());

        if(isLate) {
            redirectAttributes.addFlashAttribute("homeworkAddBindingModel", homeworkAddBindingModel);
            redirectAttributes.addFlashAttribute("isLate", true);
        }

        homeworkService.addHomework(homeworkAddBindingModel.getExercise(), homeworkAddBindingModel.getGitAddress());

        return "redirect:/";
    }
}
