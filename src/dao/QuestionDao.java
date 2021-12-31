package dao;

import beans.Question;
import memory.DataMemory;
import util.Config;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class QuestionDao {
    final String API = QuestionDao.class.getResource("/").getPath().substring(1);
    String url = (API + new Config("/config.properties").getString("QuestionFile")).replace("/","\\");

    public static void main(String[] args) {
        QuestionDao questionDao = new QuestionDao();
        System.out.println(DataMemory.getDataMemory().getQuestionsMemory());
    }
}
