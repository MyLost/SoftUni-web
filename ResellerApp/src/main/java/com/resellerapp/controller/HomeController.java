package com.resellerapp.controller;

import com.resellerapp.model.OtherUsersOffers;
import com.resellerapp.model.UserDto;
import com.resellerapp.model.UserOfferDTO;
import com.resellerapp.model.entity.OfferEntity;
import com.resellerapp.model.helpers.LoggedUser;
import com.resellerapp.service.OfferService;
import com.resellerapp.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/")
public class HomeController {

    private final LoggedUser loggedUser;
    private final UserService userService;

    private final OfferService offerService;

    public HomeController(LoggedUser loggedUser, UserService userService, OfferService offerService) {
        this.loggedUser = loggedUser;
        this.userService = userService;
        this.offerService = offerService;
    }

    @GetMapping("/home")
    public String home(Model model) {

        if(loggedUser.getId() == null) {
            return "redirect:/auth/login";
        }

        UserDto userModel = userService.findById(loggedUser.getId());

        List<UserOfferDTO> userOffers = this.offerService.userOfferList();
        List<OtherUsersOffers> otherOffers = this.offerService.otherOfferList();

        System.out.println(userModel.getBoughtOffers());
        System.out.println(userModel.getOffers());

        model.addAttribute("userModel", userModel);
        model.addAttribute("userOffers", userOffers);
        model.addAttribute("otherOffers", otherOffers);

        return "home";
    }


}
