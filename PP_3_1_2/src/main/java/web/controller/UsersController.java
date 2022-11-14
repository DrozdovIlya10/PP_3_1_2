package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
public class UsersController {

    @Autowired
    private UserService userService;

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("people",userService.listUsers());
        return "index";
    }

    @GetMapping("/{id}")
    public String  show(Model model, @PathVariable("id") long id) {
        model.addAttribute("user", userService.getIdForUser(id));
        return "show";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "new";
    }

    @PostMapping()
    public String create(@ModelAttribute("user") User user) {
        userService.getUserForAdd(user);
        return "redirect:/";
    }

    @GetMapping("/{id}/edit")
    public String  edit(Model model, @PathVariable("id") long id) {
        model.addAttribute("user", userService.getIdForUser(id));
        return "edit";
    }

    @PatchMapping("/{id}")
    public String update(@PathVariable("id") long id ,@ModelAttribute("user") User user ) {
        userService.getIdAndUserForUpdate(id,user);
        return "redirect:/";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") long id) {
        userService.getIdForDelete(id);
        return "redirect:/";
    }

}
