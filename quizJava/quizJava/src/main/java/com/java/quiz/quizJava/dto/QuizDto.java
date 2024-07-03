package com.java.quiz.quizJava.dto;

import com.java.quiz.quizJava.domain.Question;

import java.io.Serializable;
import java.util.List;

public class QuizDto implements Serializable {

    private Long id;

    private String title;

    private List<Question> questions;

    public QuizDto(Long id, String title, List<Question> questions) {
        this.id = id;
        this.title = title;
        this.questions = questions;
    }

    public QuizDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}
