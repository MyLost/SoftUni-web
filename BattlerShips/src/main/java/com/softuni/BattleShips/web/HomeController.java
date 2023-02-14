package com.softuni.BattleShips.web;

import com.softuni.BattleShips.domain.entities.ShipEntity;
import com.softuni.BattleShips.domain.helpers.LoggedUser;
import com.softuni.BattleShips.model.UserWithShipsModel;
import com.softuni.BattleShips.model.binding.BattleShipsModel;
import com.softuni.BattleShips.repositories.ShipRepository;
import com.softuni.BattleShips.services.BattleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {

    private final LoggedUser loggedUser;
    private final BattleService battleService;

    private final ShipRepository shipRepository;

    public HomeController(LoggedUser loggedUser, BattleService battleService, ShipRepository shipRepository) {
        this.loggedUser = loggedUser;
        this.battleService = battleService;
        this.shipRepository = shipRepository;
    }

    @GetMapping("/home")
    public ModelAndView getHome(ModelAndView modelAndView) {
        if(loggedUser.getId() == null) {
            modelAndView.setViewName("redirect:/auth/login");
            return modelAndView;
        }
        UserWithShipsModel attacker = battleService.getLoggedUserWIthShips();
        UserWithShipsModel defender = battleService.getNotLoggedUserWIthShips(loggedUser.getId());

        modelAndView.setViewName("home");
        modelAndView.addObject("attacker", attacker);
        modelAndView.addObject("defender", defender);

        return modelAndView;
    }

    @PostMapping("/battle")
    public String getHome(@ModelAttribute("battleShipModel") BattleShipsModel battleShipsModel) {
        return "redirect:/home";
    }

    @GetMapping
    public String getIndex() {
        return "index";
    }

    @ModelAttribute(name="battleShipModel")
    public BattleShipsModel battleShipsModel () {
        return new BattleShipsModel();
    }


    @ModelAttribute(name="allShips")
    public List<ShipEntity> ships() {
        return this.shipRepository.findAll();
    }
}
