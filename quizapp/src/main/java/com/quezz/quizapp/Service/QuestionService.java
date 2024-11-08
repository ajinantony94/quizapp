package com.quezz.quizapp.Service;

import com.quezz.quizapp.Model.Question;
import com.quezz.quizapp.Repository.QuestionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {

    @Autowired
    private QuestionDAO questionDAO;


    public ResponseEntity<List<Question>> getAllQuestions() {
        try{
            return new ResponseEntity<>(questionDAO.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);


    }

    public Optional<Question> getById(int id) {
        return questionDAO.findById(id);
    }

    public List<Question> getByCategory(String category) {
        return questionDAO.findByCategory(category);
    }

    public ResponseEntity<String> addQuestion(Question question) {

         questionDAO.save(question);
        return new ResponseEntity<>("Success",HttpStatus.CREATED);
    }
}
