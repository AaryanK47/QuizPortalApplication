package com.example.QuizPortalApplication.service;

import com.example.QuizPortalApplication.entity.Quiz;
import com.example.QuizPortalApplication.repository.QuizRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuizService {

    private final QuizRepository repository;

    public Quiz saveQuiz(Quiz quiz) {
        return repository.save(quiz);
    }

    public List<Quiz> getAllQuiz() {
        return repository.findAll();
    }

    public Quiz getQuiz(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Quiz updateQuiz(Quiz quiz) {
        return repository.save(quiz);
    }

    public void deleteQuiz(Long id) {
        repository.deleteById(id);
    }
}