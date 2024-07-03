package com.java.quiz.quizJava.controller;


import com.java.quiz.quizJava.dto.QuestionDto;
import com.java.quiz.quizJava.service.QuestionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class QuestionController {

    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/questions")
    public ResponseEntity<List<QuestionDto>> getQuestionAllList(){
        return ResponseEntity.ok().body(questionService.findAll());
    }

    @GetMapping("/questions/{category}")
    public  ResponseEntity<List<QuestionDto>> getQuestionByCategory(@PathVariable String category){
        return ResponseEntity.ok().body(questionService.findByCategory(category));
    }


    @PostMapping("/add")
    public  ResponseEntity<QuestionDto> createQuestions(@RequestBody QuestionDto question ){
        return ResponseEntity.ok().body(questionService.save(question));
    }
}
