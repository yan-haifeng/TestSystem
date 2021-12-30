package memory;

import beans.Question;
import beans.User;

import java.util.ArrayList;

public class DataMemory {
    private ArrayList<Question> questionsMemory;
    private User loginUser;
    static DataMemory dataMemory;
    static {
        dataMemory = new DataMemory();
    }
    private DataMemory(){
        init();
    }

    private void init(){
        this.questionsMemory  = new ArrayList<>();
    }

    public static DataMemory getDataMemory(){
        return dataMemory;
    }

    public ArrayList<Question> getQuestionsMemory() {
        return this.questionsMemory;
    }

    public User getLoginUser() {
        return this.loginUser;
    }

    public void setLoginUser(User loginUser) {
        this.loginUser = loginUser;
    }
}
