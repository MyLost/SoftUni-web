package com.softuni.judgeV2.web;

import com.softuni.judgeV2.models.bindings.CommentAddBindingModel;
import com.softuni.judgeV2.services.CommentService;
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
@RequestMapping("/comments")
public class CommentsController {

    private final HomeworkService homeworkService;

    private final CommentService commentService;

    public CommentsController(HomeworkService homeworkService, CommentService commentService) {
        this.homeworkService = homeworkService;
        this.commentService = commentService;
    }

    @GetMapping("/add")
    public String add(Model model) {

        if(!model.containsAttribute("commentAddBindingModel")) {
            model.addAttribute("commentAddBindingModel", new CommentAddBindingModel());
        }

        model.addAttribute("homework", homeworkService.findHomeworkForScoring());
        return "homework-check";
    }

    @PostMapping("/add")
    public String addConfirm(@Valid CommentAddBindingModel commentAddBindingModel,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes) {

        if(bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("commentAddBindingModel", commentAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.commentAddBindingModel", bindingResult);

            return "redirect:add";
        }

        commentService.add(commentAddBindingModel);

        return "redirect:/";
    }
}
