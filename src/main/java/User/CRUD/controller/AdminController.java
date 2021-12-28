package User.CRUD.controller;

import User.CRUD.model.Role;
import User.CRUD.model.User;
import User.CRUD.service.RoleService;
import User.CRUD.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @GetMapping(value = "/")
    public String allUsers(Model model) {
        List<User> users = userService.allUsers();
        model.addAttribute("userList", users);
        return "allusers";
    }

    @GetMapping(value = "/edit/{id}")
    public String editPage(@PathVariable int id, Model model) {
        User user = userService.getById(id);
        model.addAttribute("user", user);
        return "edit";
    }

    @PostMapping(value = "/edit")
    public String editUser(@ModelAttribute("user") User user, @RequestParam(required = false) String roleAdmin) {
        Set<Role> roles = new HashSet<>();
        roles.add(roleService.getRoleById(2l));
        if (roleAdmin != null ) {
            roles.add(roleService.getRoleById(1l));
        }
        user.setRoles(roles);
        userService.edit(user);
        return "redirect:/admin/";
    }

    @GetMapping("/add")
    public String addPage(Model model) {
        model.addAttribute("user", new User());
        return "/add";
    }

    @PostMapping(value = "/add")
    public String addUser(@ModelAttribute("user") User user, @RequestParam(required = false) String roleAdmin) {

            Set<Role> roles = new HashSet<>();
            roles.add(roleService.getRoleById(2l));
            if (roleAdmin != null ) {
                roles.add(roleService.getRoleById(1l));
            }
            user.setRoles(roles);
            userService.add(user);
        return "redirect:/admin/";
    }


    @GetMapping(value = "/delete/{id}")
    public String deleteUser(@PathVariable int id) {
        User user = userService.getById(id);
        userService.remove(user);
        return "redirect:/admin/";
    }
}
