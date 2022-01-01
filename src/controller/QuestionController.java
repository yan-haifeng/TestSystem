package controller;

import beans.Question;
import service.QuestionService;
import service.impl.QuestionServiceImpl;

public class QuestionController {
    QuestionService questionService = new QuestionServiceImpl();

    public Question getQuestion(int index){
        return questionService.getQuestion(index);
    }
}
