package com.java.quiz.quizJava.mapper;

import com.java.quiz.quizJava.domain.Quiz;
import com.java.quiz.quizJava.dto.QuizDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface QuizMapper extends  EntityMapper<Quiz, QuizDto>{
}
