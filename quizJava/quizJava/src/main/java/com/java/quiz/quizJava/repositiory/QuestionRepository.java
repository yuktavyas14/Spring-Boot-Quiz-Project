package com.java.quiz.quizJava.repositiory;

import com.java.quiz.quizJava.domain.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question,Long> {
    List<Question> findByCategoryIgnoreCase(String category);

    @Query(value = "SELECT * FROM questions q WHERE q.category = :category ORDER BY RAND() LIMIT :countQ", nativeQuery = true)
    List<Question> findRandomQuestionsByCategory(String category, int countQ);
}
