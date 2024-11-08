package com.quezz.quizapp.Model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


import java.util.List;

@Entity
@Data
@Setter
@Getter
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    @ManyToMany
    private List<Question> question;

    public void setTitle(String title) {
        this.title=title;
    }
    public void setQuestion(List<Question> question){
        this.question = question;
    }

    public List<Question> getQuestion() {
        return question;
    }
}
