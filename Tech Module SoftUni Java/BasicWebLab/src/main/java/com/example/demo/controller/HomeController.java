package com.example.demo.controller;

import com.example.demo.data.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    List<User> users;

    public HomeController() {
        this.users = new ArrayList<>();
    }


    @GetMapping("/users/all")
    public String showIco(Model model) {

        model.addAttribute("users", this.users);
        return "home";
    }

    @PostMapping("/user")
    public String createUser(String name, String email, String password) {

        this.users.add(new User(name, email, password));

        return "redirect:/users/all";
    }
}
