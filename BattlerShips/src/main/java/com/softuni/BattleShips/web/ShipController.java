package com.softuni.BattleShips.web;

import com.softuni.BattleShips.domain.helpers.LoggedUser;
import com.softuni.BattleShips.model.binding.ShipRegisterModel;
import com.softuni.BattleShips.services.ShipService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/ships")
public class ShipController {

    private final ShipService shipService;

    private final LoggedUser loggedUser;

    public ShipController(ShipService shipService, LoggedUser loggedUser) {
        this.shipService = shipService;
        this.loggedUser = loggedUser;
    }

    @GetMapping("/add")
    public String getShip() {
        if(loggedUser.getId() == null) {
            return "redirect:/auth/login";
        }


        return "ship-add";
    }

    @PostMapping("/add")
    public String postShip(@Valid @ModelAttribute(name="shipRegisterModel") ShipRegisterModel shipRegisterModel,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes) {

        if(bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("shipRegisterModel", shipRegisterModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.shipRegisterModel", bindingResult);

            return "redirect:add";
        }

        this.shipService.addShip(shipRegisterModel);

        return "redirect:/home";
    }

    @ModelAttribute(name="shipRegisterModel")
    public ShipRegisterModel shipRegisterModel() {
        return new ShipRegisterModel();
    }
}
