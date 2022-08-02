package web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.models.User;
import web.service.UserService;

import java.util.List;

@Controller
public class UsersController {

    private UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String getUserList(Model model) {
        List<User> listOfUsers = userService.findAll();
        model.addAttribute("listOfUsers", listOfUsers);
        return "users";
    }

    @GetMapping("/users")
    public String getAllUsers(Model model) {
        List<User> listOfUsers = userService.findAll();
        model.addAttribute("listOfUsers", listOfUsers);
        return "users";
    }

    @GetMapping("/users/new")
    public String addNewUserGet(@ModelAttribute("user") User user) {
        return "newUser";
    }

    @PostMapping("/users/new")
    public String addNewUserPost(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/users";
    }

    @GetMapping("/users/{id}/edit")
    public String updateUserGet(@PathVariable("id") int id, Model model) {
        User user = userService.findOne(id);
        model.addAttribute("user", user);
        return "editUser";
    }

    @PatchMapping("/users/{id}")
    public String updateUserPost(@ModelAttribute("user") User user, @PathVariable("id") int id) {
        userService.update(id, user);
        return "redirect:/users";
    }

    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable("id") int id){
        userService.delete(id);
        return "redirect:/users";
    }

}
