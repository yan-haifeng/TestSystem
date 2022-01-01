package dao;

import beans.Question;
import memory.TestMemory;

public class QuestionDao {
    public Question getQuestionByIndex(int index){
        return TestMemory.getTestMemory().getQuestionArrayList().get(index);
    }
}
