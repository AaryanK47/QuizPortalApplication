package com.example.QuizPortalApplication.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Table(name = "quizzes")
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String category;
    private int duration;
}
