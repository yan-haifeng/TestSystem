package memory;

import beans.Question;
import util.Config;
import util.MyUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * 考试数据文件
 * 每次考试数据不一样
 */
public class TestMemory {
    private static final TestMemory testMemory;
    private ArrayList<Question> questionArrayList;
    private HashMap<Integer,HashMap<String,Question>> answerMap;
    static {
        testMemory = new TestMemory();
    }
    private TestMemory(){
        this.init();
    }

    private void init(){
        this.questionArrayList = new ArrayList<>();
        this.answerMap = new HashMap<>();
    }

    public static TestMemory getTestMemory() {
        return testMemory;
    }

    public ArrayList<Question> getQuestionArrayList() {
        return questionArrayList;
    }

    public HashMap<Integer,HashMap<String,Question>> getAnswerMap() {
        return answerMap;
    }

    /**
     * 随机从题库里抽取试题，题量由配置文件决定
     */
    public void LoadTestQuestionList(){
        int n = new Config("/config.properties").getInt("QuestionNumber");
        int i = 0;
        HashSet<Integer> randomIndexSet = MyUtil.getRandomIndex(DataMemory.getDataMemory().getQuestionsMemory().size() , n);
        if (randomIndexSet == null) return;
        for (Integer index: randomIndexSet) {
            Question question = DataMemory.getDataMemory().getQuestionsMemory().get(index);
            question.setId(++i);
            this.questionArrayList.add(question);
        }
    }

    public void clear(){
        this.questionArrayList.clear();
        this.answerMap.clear();
    }
}
