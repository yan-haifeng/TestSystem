package memory;

import beans.Question;
import beans.User;

import java.io.BufferedReader;
import java.io.FileReader;
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
        //
        this.LoadQuestion();
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

    private void LoadQuestion(){
        ArrayList<Question> questionList = DataMemory.getDataMemory().getQuestionsMemory();
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        String line = null;
        Question question = null;
        int flag = 1; //1.参数 2.题目 3.选项A 4.选项B 5.选型C 6.选项D
        try {
            fileReader = new FileReader(url);
            bufferedReader = new BufferedReader(fileReader);

            while(true){
                line = bufferedReader.readLine();
                if (line == null) break;
                //掠过空行与注释
                if("".equals(line.trim()) || line.charAt(0) == '#') continue;
                //解析每题参数
                if(flag == 1 && line.startsWith("@")){
                    question = new Question();
                    String[] s = line.substring(1).split(",");
                    for (String data: s) {
                        String[] ss = data.split("=");
                        if(ss.length == 2){
                            if ("answer".equals(ss[0])) question.setAnswer(ss[1]);
                            if ("score".equals(ss[0])) question.setScore(ss[1]);
                            if ("level".equals(ss[0])) question.setLevel(ss[1]);
                        }else {
                            return;
                        }
                    }
                    flag = 2;
                    continue;
                }
                //解析每题题目
                if (flag == 2){
                    question.setTitle(line);
                    flag = 3;
                    continue;
                }
                //解析A选项
                if(flag == 3){
                    question.setOptionA(line);
                    flag = 4;
                    continue;
                }
                //解析B选项
                if(flag == 4){
                    question.setOptionB(line);
                    flag = 5;
                    continue;
                }
                //解析C选项
                if(flag == 5){
                    question.setOptionC(line);
                    flag = 6;
                    continue;
                }
                //解析D选项
                if(flag == 6){
                    question.setOptionD(line);
                    questionList.add(question);
                    flag = 1;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                assert bufferedReader != null;
                bufferedReader.close();
                fileReader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
