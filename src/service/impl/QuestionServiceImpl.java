package service.impl;

import beans.Question;
import dao.QuestionDao;
import service.QuestionService;

public class QuestionServiceImpl implements QuestionService {
    QuestionDao questionDao = new QuestionDao();
    @Override
    public Question getQuestion(int index) {
        return questionDao.getQuestionByIndex(index);
    }
}
