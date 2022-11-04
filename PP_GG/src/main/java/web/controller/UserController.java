package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import web.service.UserService;
import web.service.UserServiceImpl;

@Controller
public class UserController {

    private UserService userService = new UserServiceImpl();

    @GetMapping(value = "/")
    public String printCars( Model model) {
        //@RequestParam(value = "count", defaultValue = "5") int allCars,
        model.addAttribute("messages", userService.getUser());
        return "users";
    }
}
