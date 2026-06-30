package com.example.QuizPortalApplication.controller;

import com.example.QuizPortalApplication.Service.QuestionService;
import com.example.QuizPortalApplication.Service.QuizService;
import com.example.QuizPortalApplication.entity.Question;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class QuestionController {

    private final QuestionService questionService;
    private final QuizService quizService;

    @GetMapping("/questions/{quizId}")
    public String questionList(@PathVariable Long quizId, Model model) {

        model.addAttribute("questions", questionService.getQuestionByQuiz(quizId));
        model.addAttribute("quizId", quizId);

        return "questionList";
    }

    @GetMapping("/addQuestion/{quizId}")
    public String addQuestion(@PathVariable Long quizId, Model model) {

        Question question = new Question();
        question.setQuiz(quizService.getQuiz(quizId));

        model.addAttribute("question", question);

        return "addQuestion";
    }

    @PostMapping("/saveQuestion")
    public String saveQuestion(@ModelAttribute Question question) {

        questionService.saveQuestion(question);

        return "redirect:/questions/" + question.getQuiz().getId();
    }

    @GetMapping("/deleteQuestion/{id}")
    public String deleteQuestion(@PathVariable Long id) {

        Question question = questionService.getQuestion(id);

        Long quizId = question.getQuiz().getId();

        questionService.deleteQuestion(id);

        return "redirect:/questions/" + quizId;
    }
}