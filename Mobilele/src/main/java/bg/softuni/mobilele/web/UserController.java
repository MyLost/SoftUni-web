package bg.softuni.mobilele.web;

import bg.softuni.mobilele.domain.dtos.branding.UserLoginFormDto;
import bg.softuni.mobilele.domain.dtos.branding.UserRegisterFormDto;
import bg.softuni.mobilele.domain.dtos.view.UserRoleViewDto;
import bg.softuni.mobilele.services.role.UserRoleService;
import bg.softuni.mobilele.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/users") // url after localhost:8080 -> /users
public class UserController extends BaseController {
    private final UserRoleService roleService;
    private final UserService userService;

    @Autowired
    public UserController(UserRoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @GetMapping("/register") // post method localhost:8080/users/register
    public ModelAndView getRegister(ModelAndView modelAndView) {
        List<UserRoleViewDto> roleServiceAll = this.roleService.getAll();

        modelAndView.addObject("roles", roleServiceAll);

        return super.view("auth-register", modelAndView);
    }

    @PostMapping("/register")
    public ModelAndView postRegister(UserRegisterFormDto userRegisterInfo) {
        this.userService.registerUser(userRegisterInfo);

        return super.redirect("login");
    }


    @GetMapping("/login")
    public ModelAndView getLogin() {
        return super.view("auth-login");
    }

    @PostMapping("/login")
    public ModelAndView postLogin(UserLoginFormDto userLoginForm) {
        return this.userService.loginUser(userLoginForm).isValid()
                ? super.redirect("/")
                : super.redirect("login");
    }

    @PostMapping("/logout")
    public ModelAndView postLogout() {
        this.userService.logout();
        return super.redirect("/");
    }
}