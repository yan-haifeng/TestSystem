package util;

import beans.Question;
import memory.TestMemory;

import java.util.HashMap;
import java.util.HashSet;

public class MyUtil {
    public static HashSet<Integer> getRandomIndex(Integer max, Integer n){
        if (n > (max + 1) || max < 0) {
            return null;
        }
        HashSet<Integer> set = new HashSet<>();
        while(set.size() < n){
            int num = (int) (Math.random() * max);
            set.add(num);// 将不同的数存入HashSet中
        }
        return set;
    }

    public static int calculationScore(){
        int score = 0;
        HashMap<Integer, HashMap<String,Question>> map = TestMemory.getTestMemory().getAnswerMap();
        for (int i = 0; i < new Config("/config.properties").getInt("QuestionNumber"); i++) {
            if (map.get(i) != null){
                //对比答案
                String myAnswer = (String)map.get(i).keySet().toArray()[0];
                String answer = map.get(i).get(myAnswer).getAnswer();
                if (answer.equals(myAnswer)) score += Integer.parseInt(map.get(i).get(myAnswer).getScore());
            }
        }
        return score;
    }
}
