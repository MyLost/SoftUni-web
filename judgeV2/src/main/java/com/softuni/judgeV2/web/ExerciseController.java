package com.softuni.judgeV2.web;

import com.softuni.judgeV2.mappers.ExerciseMapper;
import com.softuni.judgeV2.models.bindings.ExerciseAddBindingModel;
import com.softuni.judgeV2.models.dtos.ExerciseDto;
import com.softuni.judgeV2.services.ExercisesService;
import jakarta.validation.Valid;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/exercises")
public class ExerciseController {

    private final ExercisesService exercisesService;

    private final ExerciseMapper exerciseMapper;

    public ExerciseController(ExercisesService exercisesService) {
        this.exercisesService = exercisesService;
        this.exerciseMapper = Mappers.getMapper(ExerciseMapper.class);
    }

    @GetMapping("/add")
    public String add(Model model) {

        if(!model.containsAttribute("exerciseAddBindingModel")) {
            model.addAttribute("exerciseAddBindingModel", new ExerciseAddBindingModel());
        }

        return "exercise-add";
    }

    @PostMapping("/add")
    public String addConfirm(@Valid  ExerciseAddBindingModel exerciseAddBindingModel,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes) {

        if(bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("exerciseAddBindingModel", exerciseAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.exerciseAddBindingModel", bindingResult);
            return "redirect:add";
        }

        ExerciseDto dto = exerciseMapper.modelToDto(exerciseAddBindingModel);
        exercisesService.addExercise(dto);

        return "redirect:/";

    }
}
