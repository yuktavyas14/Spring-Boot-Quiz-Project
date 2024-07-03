package com.java.quiz.quizJava.service.serviceImpl;

import com.java.quiz.quizJava.domain.Question;
import com.java.quiz.quizJava.domain.Quiz;
import com.java.quiz.quizJava.dto.QuizDto;
import com.java.quiz.quizJava.mapper.QuizMapper;
import com.java.quiz.quizJava.repositiory.QuestionRepository;
import com.java.quiz.quizJava.repositiory.QuizRepository;
import com.java.quiz.quizJava.service.QuizService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class QuizServiceImpl implements QuizService {

    private final QuestionRepository questionRepository;
    private final QuizMapper quizMapper;

    private final QuizRepository quizRepository;

    public QuizServiceImpl(QuestionRepository questionRepository, QuizMapper quizMapper, QuizRepository quizRepository) {
        this.questionRepository = questionRepository;
        this.quizMapper = quizMapper;
        this.quizRepository = quizRepository;
    }

    @Override
    public QuizDto createRandomQuiz(String category, int count, String title) {
        Quiz quiz=new Quiz();
        List<Question> questionList=questionRepository.findRandomQuestionsByCategory(category,count);
        quiz.setTitle(title);
        quiz.setQuestions(questionList);
        return quizMapper.toDto(quizRepository.save(quiz));
    }

    @Override
    public Quiz getById(Long id) throws Exception {
       Optional<Quiz> getById= quizRepository.findById(id);
      if(getById.isPresent()){
          return getById.get();
      }
      else{
          throw new Exception("No Quiz Present For This Id");
      }
    }

    @Override
    public AtomicInteger getResult(Long id, Map<String, String> response) throws Exception {
       Quiz quiz = getById(id);
       List<Question> questionList = quiz.getQuestions();
       AtomicInteger count = new AtomicInteger();
       response.forEach((key,value)->{
           if(questionList.stream().anyMatch(s->s.getRightAnswer().equals(value))){
               count.getAndIncrement();
           }
       });
        return count;
    }
}
