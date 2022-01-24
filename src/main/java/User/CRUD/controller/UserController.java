package User.CRUD.controller;


import User.CRUD.model.User;
import User.CRUD.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserDetailsService userDetailsService;

    @Autowired
    public UserController(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @GetMapping(value = "/")
    public String getUserPage(ModelMap modelMap, Principal principal) {
        modelMap.addAttribute("user", userDetailsService.loadUserByUsername(principal.getName()));
        return "profile";
    }

}


