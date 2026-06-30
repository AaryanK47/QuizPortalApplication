package com.example.QuizPortalApplication.repository;

import com.example.QuizPortalApplication.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepository extends JpaRepository<Quiz,Long> {
}
