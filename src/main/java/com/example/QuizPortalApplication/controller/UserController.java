package com.example.QuizPortalApplication.controller;

import com.example.QuizPortalApplication.entity.User;
import com.example.QuizPortalApplication.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    // Login Page
    @GetMapping("/")
    public String home() {
        return "login";
    }

    // Register Page
    @GetMapping("/register")
    public String registerPage(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    // Register User
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

    // Login User
    @PostMapping("/login")
    public String login(@RequestParam String email,
                        @RequestParam String password,
                        Model model) {

        try {
            User user = service.login(email, password);
            model.addAttribute("user", user);
            return "dashboard";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "login";
        }
    }

    // Dashboard
    @GetMapping("/dashboard")
    public String dashboard() {
        return "dashboard";
    }
}