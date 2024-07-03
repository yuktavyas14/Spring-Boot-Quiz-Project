package com.java.quiz.quizJava.mapper;

import com.java.quiz.quizJava.domain.Question;
import com.java.quiz.quizJava.dto.QuestionDto;
import com.java.quiz.quizJava.dto.QuestionWrapperDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface QuestionMapper extends EntityMapper<Question, QuestionDto> {

    List<QuestionWrapperDto> toWrapperDto(List<Question> questions);
}
