package com.quezz.quizapp.Controller;

import com.quezz.quizapp.Model.Question;
import com.quezz.quizapp.Model.QuestionWrapper;
import com.quezz.quizapp.Model.Response;
import com.quezz.quizapp.Service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {
    @Autowired
    QuizService quizService;

    @PostMapping("/create")
    public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam int numQ, @RequestParam String title){
        return new ResponseEntity<>(quizService.createQuiz(category,numQ,title), HttpStatus.OK);
    }
    @GetMapping("/get/{id}")
    public List<QuestionWrapper> getQuizQuestions(@PathVariable Integer id){
        return quizService.getQuizQuestions(id);
    }
    @PostMapping("/submit/{id}")
    public Integer submitQuiz(@PathVariable Integer id, @RequestBody List<Response> responses){
        return quizService.submitQuiz(id,responses);
    }
}
