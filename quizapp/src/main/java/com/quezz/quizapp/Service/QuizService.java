package com.quezz.quizapp.Service;

import com.quezz.quizapp.Model.Question;
import com.quezz.quizapp.Model.QuestionWrapper;
import com.quezz.quizapp.Model.Quiz;
import com.quezz.quizapp.Model.Response;
import com.quezz.quizapp.Repository.QuestionDAO;
import com.quezz.quizapp.Repository.QuizDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {
    @Autowired
    QuestionDAO questionDAO;
    @Autowired
    QuizDAO quizDAO;

    public String createQuiz(String category, int numQ, String title) {
        List<Question> questions = questionDAO.findRandomQuestionsByCategory(category,numQ);
        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestion(questions);
        quizDAO.save(quiz);
        return "success";
    }

    public List<QuestionWrapper> getQuizQuestions(Integer id) {
        Optional<Quiz> quiz = quizDAO.findById(id);
        List<Question> questionFromDb = quiz.get().getQuestion();
        List<QuestionWrapper> questionForUsers = new ArrayList<>();
        for(Question q: questionFromDb){
            QuestionWrapper qw = new QuestionWrapper(q.getId(),q.getQuestionText(),q.getOption_a(),q.getOption_b(),q.getOption_c(),q.getOption_d());
            questionForUsers.add(qw);
        }
        return questionForUsers;
    }

    public Integer submitQuiz(Integer id, List<Response> responses) {

        Quiz quiz = quizDAO.findById(id).get();
        List<Question> questions = quiz.getQuestion();

        int right = 0;
        int i = 0;
        for(Response response: responses){
            if(response.getResponse().equals(questions.get(i).getCorrectOption()))
                right++;

            i++;
        }

        return right;
    }
}
