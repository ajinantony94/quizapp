package com.quezz.quizapp.Repository;

import com.quezz.quizapp.Model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDAO extends JpaRepository<Question,Integer> {

     @Query(value = "SELECT * FROM question WHERE question.category=:category ORDER BY RANDOM() LIMIT :numQ",nativeQuery = true)
     List<Question> findRandomQuestionsByCategory(String category, int numQ);

     List<Question> findByCategory(String category);
     
}
