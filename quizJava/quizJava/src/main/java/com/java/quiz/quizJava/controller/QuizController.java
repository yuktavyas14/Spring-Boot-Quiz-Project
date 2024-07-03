package com.java.quiz.quizJava.controller;

import com.java.quiz.quizJava.domain.Quiz;
import com.java.quiz.quizJava.dto.QuestionWrapperDto;
import com.java.quiz.quizJava.dto.QuizDto;
import com.java.quiz.quizJava.mapper.QuestionMapper;
import com.java.quiz.quizJava.service.QuizService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    private final QuizService quizService;
    private final QuestionMapper questionMapper;

    public QuizController(QuizService quizService, QuestionMapper questionMapper) {
        this.quizService = quizService;
        this.questionMapper = questionMapper;
    }

    @PostMapping("/create")
    public ResponseEntity<QuizDto> createQuiz(@RequestParam String category, @RequestParam  int count, @RequestParam String title){
        return ResponseEntity.ok().body(quizService.createRandomQuiz(category,count,title));
    }


    @GetMapping("/{id}")
    public ResponseEntity<Quiz> quizGetById(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok().body(quizService.getById(id));
    }


    @GetMapping("/get-quiz-questions/{id}")
    public ResponseEntity<List<QuestionWrapperDto>> getQuizQuestions(@PathVariable Long id) throws Exception {
        Quiz quiz = quizService.getById(id);
        return ResponseEntity.ok().body(questionMapper.toWrapperDto(quiz.getQuestions()));
    }

    @PostMapping("/submit/{id}")
    public ResponseEntity<AtomicInteger> submitResult(@PathVariable Long id, @RequestBody Map<String,String> response) throws Exception {
        return ResponseEntity.ok().body(quizService.getResult(id, response));
    }
}
