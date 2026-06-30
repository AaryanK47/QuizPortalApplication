package com.example.QuizPortalApplication.controller;

import com.example.QuizPortalApplication.Service.UserService;
import com.example.QuizPortalApplication.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @GetMapping("/")
    public String home() {
        return "login";
    }

    @GetMapping("/register")
    public String registerPage(Model model) {

        model.addAttribute("user", new User());

        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user, Model model) {
        try {
            service.register(user);
            return "redirect:/";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "register";
        }
    }
    @PostMapping("/login")
    String login(@RequestParam String email,@RequestParam String password,Model model){
        try {
            User user = service.login(email, password);
            model.addAttribute("user", user);
            return "dashboard";
        }
        catch (Exception e){
            model.addAttribute("error",e.getMessage());
            return "login";
        }

    }
}