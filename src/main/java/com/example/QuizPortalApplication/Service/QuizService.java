package com.example.QuizPortalApplication.Service;

import com.example.QuizPortalApplication.entity.Quiz;
import com.example.QuizPortalApplication.repository.QuizRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuizService {

    private final QuizRepository repository;

    // Save Quiz
    public Quiz saveQuiz(Quiz quiz) {
        return repository.save(quiz);
    }

    // Get All Quizzes
    public List<Quiz> getAllQuiz() {
        return repository.findAll();
    }

    // Get Quiz By ID
    public Quiz getQuiz(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Quiz Not Found"));
    }

    // Delete Quiz
    public void deleteQuiz(Long id) {
        repository.deleteById(id);
    }
}