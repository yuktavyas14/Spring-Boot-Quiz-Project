package com.java.quiz.quizJava.service;

import com.java.quiz.quizJava.domain.Question;
import com.java.quiz.quizJava.dto.QuestionDto;

import java.util.List;

public interface QuestionService  {

    List<QuestionDto> findAll();

    List<QuestionDto> findByCategory(String category);

    QuestionDto save(QuestionDto question);
}
