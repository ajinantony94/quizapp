package com.quezz.quizapp.Controller;

import com.quezz.quizapp.Model.Question;
import com.quezz.quizapp.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/questions")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("/all")
    public ResponseEntity<List<Question>> getAllQuestions(){
        return questionService.getAllQuestions();
    }

    @GetMapping("/{id}")
    public Optional<Question> getById(@PathVariable int id){
        return questionService.getById(id);
    }

    @GetMapping("/category/{category}")
    public List<Question> getByCategory(@PathVariable String category){
        return questionService.getByCategory(category);
    }

    //to add some new questions!!!!
    @PostMapping("/add")
    public ResponseEntity<String> addQuestions(@RequestBody Question question){
       return questionService.addQuestion(question);
    }


}
