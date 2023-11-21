package by.lask.spring.boot_security.demo.controller;

import by.lask.spring.boot_security.demo.model.Role;
import by.lask.spring.boot_security.demo.model.User;
import by.lask.spring.boot_security.demo.service.RoleService;
import by.lask.spring.boot_security.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;

    private final RoleService roleService;

    @Autowired
    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping()
    public String showAllUsers(ModelMap model) {
        model.addAttribute("users", userService.getAllUsers());
        return "all-users";
    }

    @GetMapping("/new-user")
    public String addNewUser(ModelMap model) {
        User user = new User();
        Set<Role> roles = roleService.findAll();

        model.addAttribute("user", user);
        model.addAttribute("roles", roles);
        return "add-user";
    }

    @PostMapping("/add-user")
    public String saveUser(@ModelAttribute User user) {
        userService.saveUser(user);
        return "redirect:/admin";
    }

    @PostMapping("/update-user")
    public String updateUser(@ModelAttribute User user) {
        userService.updateUser(user);
        return "redirect:/admin";
    }

    @GetMapping("/get-user")
    public String getUserById(@RequestParam("userId") int id, ModelMap model) {
        User user = userService.getById(id);
        Set<Role> roles = roleService.findAll();
        model.addAttribute("user", user);
        model.addAttribute("roles", roles);

        return "update-user";
    }

    @DeleteMapping("/delete-user")
    public String deleteUser(@RequestParam("userId") int id) {
        userService.deleteUserById(id);
        return "redirect:/admin";
    }
}
