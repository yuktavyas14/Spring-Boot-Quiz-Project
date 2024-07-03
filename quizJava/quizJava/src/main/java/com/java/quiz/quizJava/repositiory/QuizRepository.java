package com.java.quiz.quizJava.repositiory;

import com.java.quiz.quizJava.domain.Question;
import com.java.quiz.quizJava.domain.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizRepository extends JpaRepository<Quiz,Long> {


}
