package com.resellerapp.controller;

import com.resellerapp.model.bindings.OfferBindingModel;
import com.resellerapp.model.entity.OfferEntity;
import com.resellerapp.model.entity.UserEntity;
import com.resellerapp.model.helpers.LoggedUser;
import com.resellerapp.repository.OfferRepository;
import com.resellerapp.repository.UserRepository;
import com.resellerapp.service.OfferService;
import com.resellerapp.service.UserService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/")
public class OfferController {

    private final LoggedUser loggedUser;
    private final OfferService offerService;

    private final OfferRepository offerRepository;

    private final UserService userService;

    private final UserRepository userRepository;

    private final ModelMapper modelMapper;

    public OfferController(LoggedUser loggedUser, OfferService offerService, OfferRepository offerRepository, UserService userService, UserRepository userRepository, ModelMapper modelMapper) {
        this.loggedUser = loggedUser;
        this.offerService = offerService;
        this.offerRepository = offerRepository;
        this.userService = userService;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/offer")
    public String offer(Model model) {

        if(!model.containsAttribute("offerBindingModel")) {
            model.addAttribute("offerBindingModel", new OfferBindingModel());
        }

        if(loggedUser.getId() == null) {
            return "redirect:/auth/login";
        }
        return "offer-add";
    }


    @PostMapping("/offer")
    public String addOffer(@Valid @ModelAttribute OfferBindingModel offerBindingModel,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("offerBindingModel", offerBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.offerBindingModel", bindingResult);
            return "redirect:login";
        }

        offerService.saveOffer(offerBindingModel);

        return "redirect:/home";
    }


    @GetMapping("/offer/{id}")
    public String buyOffer(@PathVariable("id") Long id) {

        OfferEntity offerEntity = offerService.findById(id);
        UserEntity userEntity = userRepository.findById(id).orElseThrow();
        offerEntity.setUser(userEntity);

        offerRepository.saveAndFlush(offerEntity);

        userEntity.getBoughtOffers().add(offerEntity);
        userRepository.saveAndFlush(userEntity);


        return "redirect:/home";
    }
}
