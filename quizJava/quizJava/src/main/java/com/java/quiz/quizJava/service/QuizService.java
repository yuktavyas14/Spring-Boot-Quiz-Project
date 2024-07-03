package com.java.quiz.quizJava.service;

import com.java.quiz.quizJava.domain.Question;
import com.java.quiz.quizJava.domain.Quiz;
import com.java.quiz.quizJava.dto.QuizDto;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public interface QuizService {

    QuizDto createRandomQuiz(String category, int count, String title);

    Quiz getById(Long id) throws Exception;

    AtomicInteger getResult(Long id, Map<String, String> response) throws Exception;


}
