package controller;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.UserService;
import service.UserServiceImpl;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/customer")
public class UserController {

    private UserService userService = new UserServiceImpl();


    @GetMapping("/list")
    public String listUser(Model model) {
        List<User> users = userService.listUsers();
        model.addAttribute("messages", users);
        return "list-user";
    }

    @GetMapping("/showForm")
    public String showFormForAdd(Model theModel) {
        User user = new User();
        theModel.addAttribute("customer", user);
        return "customer-form";
    }

    @PostMapping("/saveUser")
    public String saveCustomer(@ModelAttribute("messages") User user) {
        userService.add(user);
        return "redirect:/User/list";
    }
    @GetMapping("/updateForm")
    public String showFormForUpdate(@RequestParam("userId") int theId,
                                    Model theModel) {
        User user= userService.getUser(theId);
        theModel.addAttribute("messages", user);
        return "customer-form";
    }
    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("userId") int theId) {
        userService.delUser(theId);
        return "redirect:/customer/list";
    }

    /*@GetMapping(value = "/")
    public String printCars( ModelMap model) {
        List<String> messages = new ArrayList<>();
        messages.add("Hello!");
        messages.add("I'm Spring MVC application");
        messages.add("5.2.0 version by sep'19 ");
        model.addAttribute("messages", messages);
        return "index";
    }
    @RequestMapping(value="/user/add")
    public ModelAndView addTeamPage() {
        ModelAndView modelAndView = new ModelAndView("add-team-form");
        modelAndView.addObject("team", new User());
        return modelAndView;
    }
    @RequestMapping(value="/team/add/process")
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
