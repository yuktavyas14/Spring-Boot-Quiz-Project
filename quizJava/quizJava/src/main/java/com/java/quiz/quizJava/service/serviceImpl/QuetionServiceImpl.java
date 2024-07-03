package com.java.quiz.quizJava.service.serviceImpl;

import com.java.quiz.quizJava.domain.Question;
import com.java.quiz.quizJava.dto.QuestionDto;
import com.java.quiz.quizJava.mapper.QuestionMapper;
import com.java.quiz.quizJava.repositiory.QuestionRepository;
import com.java.quiz.quizJava.service.QuestionService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class QuetionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;

    private final QuestionMapper questionMapper;

    public QuetionServiceImpl(QuestionRepository questionRepository, QuestionMapper questionMapper) {
        this.questionRepository = questionRepository;
        this.questionMapper = questionMapper;
    }

    @Override
    public List<QuestionDto> findAll() {
        List<Question> questionList = questionRepository.findAll();
        return questionMapper.toDto(questionList);
    }

    @Override
    public List<QuestionDto> findByCategory(String category) {
       return questionMapper.toDto(questionRepository.findByCategoryIgnoreCase(category));
    }

    @Override
    public QuestionDto save(QuestionDto question) {
        Question entity = questionMapper.toEntity(question);
        entity = questionRepository.save(entity);
        return questionMapper.toDto(entity);
    }
}
