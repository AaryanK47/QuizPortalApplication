package com.example.QuizPortalApplication.Service;

import com.example.QuizPortalApplication.entity.Question;
import com.example.QuizPortalApplication.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionService {

    private final QuestionRepository repository;

    public Question saveQuestion(Question question) {
        return repository.save(question);
    }

    public List<Question> getQuestionByQuiz(Long quizId) {
        return repository.findByQuizId(quizId);
    }

    public Question getQuestion(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Question Not Found"));
    }

    public void deleteQuestion(Long id) {
        repository.deleteById(id);
    }
}