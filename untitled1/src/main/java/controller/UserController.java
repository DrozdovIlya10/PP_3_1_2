package controller;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import service.UserService;

public class UserController {
    @Autowired
    UserService userService;

    @GetMapping(value = "/user")
    public String printCars( Model model) {
        model.addAttribute("messages", userService.listUsers());
        return "User";
    }
    @RequestMapping(value="/user/add")
    public ModelAndView addTeamPage() {
        ModelAndView modelAndView = new ModelAndView("add-team-form");
        modelAndView.addObject("team", new User());
        return modelAndView;
    }
    /*@RequestMapping(value="/team/add/process")
    public ModelAndView addingTeam(@ModelAttribute User user) {

        ModelAndView modelAndView = new ModelAndView("home");
        userService.addUser(user);

        String message = "Team was successfully added.";
        modelAndView.addObject("message", message);

        return modelAndView;
    }
    @RequestMapping(value="/team/edit/{id}", method=RequestMethod.GET)
    public ModelAndView editTeamPage(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("edit-team-form");
        Team team = teamService.getTeam(id);
        modelAndView.addObject("team",team);
        return modelAndView;
    }*/
}
