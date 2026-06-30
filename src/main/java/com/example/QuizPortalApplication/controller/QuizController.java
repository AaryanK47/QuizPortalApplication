package com.example.QuizPortalApplication.controller;

import com.example.QuizPortalApplication.Service.QuizService;
import com.example.QuizPortalApplication.entity.Quiz;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class QuizController {

    private final QuizService service;

    @GetMapping("/dashboard")
    public String dashboard() {
        return "dashboard";
    }

    @GetMapping("/quiz")
    public String quizList(Model model) {

        model.addAttribute("quizList", service.getAllQuiz());

        return "quizList";
    }

    @GetMapping("/addQuiz")
    public String addQuiz(Model model) {

        model.addAttribute("quiz", new Quiz());

        return "addQuiz";
    }

    @PostMapping("/saveQuiz")
    public String saveQuiz(@ModelAttribute Quiz quiz) {

        service.saveQuiz(quiz);

        return "redirect:/quiz";
    }

    @GetMapping("/deleteQuiz/{id}")
    public String deleteQuiz(@PathVariable Long id) {

        service.deleteQuiz(id);

        return "redirect:/quiz";
    }

    @GetMapping("/editQuiz/{id}")
    public String editQuiz(@PathVariable Long id, Model model) {

        model.addAttribute("quiz", service.getQuiz(id));

        return "editQuiz";
    }

    @PostMapping("/updateQuiz")
    public String updateQuiz(@ModelAttribute Quiz quiz) {
        service.saveQuiz(quiz);
        return "redirect:/quiz";
    }
}