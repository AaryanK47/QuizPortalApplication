package com.example.QuizPortalApplication.controller;

import com.example.QuizPortalApplication.entity.Quiz;
import com.example.QuizPortalApplication.service.QuizService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class QuizController {

    private final QuizService service;

    // Display all quizzes
    @GetMapping("/quiz")
    public String quizList(Model model) {
        model.addAttribute("quizList", service.getAllQuiz());
        return "quizList";
    }

    // Open Add Quiz page
    @GetMapping("/addQuiz")
    public String addQuiz(Model model) {
        model.addAttribute("quiz", new Quiz());
        return "addQuiz";
    }

    // Save Quiz
    @PostMapping("/saveQuiz")
    public String saveQuiz(@ModelAttribute Quiz quiz) {
        service.saveQuiz(quiz);
        return "redirect:/quiz";
    }

    // Delete Quiz
    @GetMapping("/deleteQuiz/{id}")
    public String deleteQuiz(@PathVariable Long id) {
        service.deleteQuiz(id);
        return "redirect:/quiz";
    }

    // Open Edit Quiz Page
    @GetMapping("/editQuiz/{id}")
    public String editQuiz(@PathVariable Long id, Model model) {
        model.addAttribute("quiz", service.getQuiz(id));
        return "editQuiz";
    }

    // Update Quiz
    @PostMapping("/updateQuiz")
    public String updateQuiz(@ModelAttribute Quiz quiz) {
        service.updateQuiz(quiz);
        return "redirect:/quiz";
    }
}