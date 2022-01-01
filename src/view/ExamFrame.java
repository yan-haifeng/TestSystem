package view;

import beans.Question;
import beans.User;
import memory.DataMemory;
import memory.TestMemory;
import util.Config;
import util.MyUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class ExamFrame {
    JFrame frame = new JFrame();
    Config config = new Config("/config.properties");
    User user;
    Question question;
    public ExamFrame(){
        init();
    }

    private void init(){
        //加载题库
        TestMemory.getTestMemory().LoadTestQuestionList();
        frame.setTitle("指针信息在线测评");
        frame.setSize(800,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        user = DataMemory.getDataMemory().getLoginUser();
        question = TestMemory.getTestMemory().getQuestionArrayList().get(0);
        frame.add(this.getExamPanel());
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
    }

    private JPanel getExamPanel(){
        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel title = new JLabel();
        Icon icon = new ImageIcon(Objects.requireNonNull(ExamFrame.class.getResource("/images/exam_title.png")));
        title.setIcon(icon);
        title.setSize(panel.getPreferredSize());
        title.setBounds(200,0,800,100);
        panel.add(title);

        JLabel nameLabel = new JLabel("姓名：");
        nameLabel.setBounds(50,90,100,25);
        panel.add(nameLabel);
        JLabel name = new JLabel(user.getName());
        name.setBounds(90,90,100,25);
        panel.add(name);

        JLabel idLabel = new JLabel("编号：");
        idLabel.setBounds(140,90,100,25);
        panel.add(idLabel);
        JLabel id = new JLabel(user.getId());
        id.setBounds(180,90,100,25);
        panel.add(id);

        JLabel examtimeLabel = new JLabel("考试时间：");
        examtimeLabel.setBounds(320,90,100,25);
        panel.add(examtimeLabel);
        JLabel examtime = new JLabel(config.getString("TimeLimit"));
        examtime.setBounds(380,90,100,25);
        panel.add(examtime);

        JLabel examtypeLabel = new JLabel("考试类别：");
        examtypeLabel.setBounds(440,90,100,25);
        panel.add(examtypeLabel);
        JLabel type = new JLabel(config.getString("PaperTitle"));
        type.setBounds(500,90,150,25);
        panel.add(type);

        JLabel examcountLabel = new JLabel("题目数量：");
        examcountLabel.setBounds(650,90,100,25);
        panel.add(examcountLabel);
        JLabel count = new JLabel(config.getString("QuestionNumber"));
        count.setBounds(710,90,150,25);
        panel.add(count);

        JTextArea jTextArea = new JTextArea();
        jTextArea.setBounds(50,140,680,260);
        jTextArea.setEditable(false);
        jTextArea.setLineWrap(true);
        jTextArea.setWrapStyleWord(true);
        String text = question.getTitle() + "\n" + question.getOptionA() + "\n" + question.getOptionB()+ "\n" + question.getOptionC()+ "\n" + question.getOptionD();
        jTextArea.setText(text);
        panel.add(jTextArea);

        JLabel kuang = new JLabel();
        kuang.setBounds(40,120,200,200);
        kuang.setSize(new Dimension(700, 290));
        panel.add(kuang, BorderLayout.CENTER);
        kuang.setBorder(BorderFactory.createTitledBorder("题目"));

        JCheckBox checkboxA = new JCheckBox("A");
        checkboxA.setBounds(260,420,40,40);
        panel.add(checkboxA);
        JCheckBox checkboxB = new JCheckBox("B");
        checkboxB.setBounds(340,420,40,40);
        panel.add(checkboxB);
        JCheckBox checkboxC = new JCheckBox("C");
        checkboxC.setBounds(420,420,40,40);
        panel.add(checkboxC);
        JCheckBox checkboxD = new JCheckBox("D");
        checkboxD.setBounds(500,420,40,40);
        panel.add(checkboxD);

        JButton button1 = new JButton("上一题");
        button1.setBounds(200,480,80,40);
        panel.add(button1);
        JButton button2 = new JButton("下一题");
        button2.setBounds(350,480,80,40);
        panel.add(button2);
        JButton button3 = new JButton("交卷");
        button3.setBounds(500,480,80,40);
        panel.add(button3);

        JLabel leftdown = new JLabel("题目："+config.getString("QuestionNumber")+"的第"+question.getId()+"题");
        leftdown.setBounds(20,520,150,25);
        panel.add(leftdown);

        JLabel rightdown = new JLabel("剩余时间：" + config.getString("TimeLimit") + "：0");
        rightdown.setBounds(630,520,150,25);
        panel.add(rightdown);
        //上一题事件
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(question.getId() > 1){
                    String answer = "";
                    //存答案
                    if (checkboxA.isSelected()){
                        answer += "/1";
                    }
                    if (checkboxB.isSelected()){
                        answer += "/2";
                    }
                    if (checkboxC.isSelected()){
                        answer += "/3";
                    }
                    if (checkboxD.isSelected()){
                        answer += "/4";
                    }
                    answer = answer.length() > 1 ? answer.substring(1) : answer;
                    HashMap<String,Question> hashMap = new HashMap<>();
                    hashMap.put(answer,question);
                    TestMemory.getTestMemory().getAnswerMap().put(question.getId(),hashMap);

                    //加载数据
                    question = TestMemory.getTestMemory().getQuestionArrayList().get(question.getId() - 2);
                    answer = TestMemory.getTestMemory().getAnswerMap().get(question.getId()) != null ? (String)TestMemory.getTestMemory().getAnswerMap().get(question.getId()).keySet().toArray()[0] : "";
                    //设置复选框
                    String[] answerList = answer.split("/");
                    checkboxA.setSelected(false);
                    checkboxB.setSelected(false);
                    checkboxC.setSelected(false);
                    checkboxD.setSelected(false);
                    for (String data : answerList) {
                        if("1".equals(data)) checkboxA.setSelected(true);
                        if("2".equals(data)) checkboxB.setSelected(true);
                        if("3".equals(data)) checkboxC.setSelected(true);
                        if("4".equals(data)) checkboxD.setSelected(true);
                    }
                    String text = question.getTitle() + "\n" + question.getOptionA() + "\n" + question.getOptionB()+ "\n" + question.getOptionC()+ "\n" + question.getOptionD();
                    jTextArea.setText(text);
                    leftdown.setText("题目："+config.getString("QuestionNumber")+"的第"+question.getId()+"题");
                }else{
                    JOptionPane.showMessageDialog(frame,"已经是第一题！");
                }
            }
        });

        //下一题事件
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(question.getId() < config.getInt("QuestionNumber")){
                    //存答案
                    String answer = "";
                    if (checkboxA.isSelected()){
                        answer += "/1";
                    }
                    if (checkboxB.isSelected()){
                        answer += "/2";
                    }
                    if (checkboxC.isSelected()){
                        answer += "/3";
                    }
                    if (checkboxD.isSelected()){
                        answer += "/4";
                    }
                    answer = answer.length() > 1 ? answer.substring(1) : answer;
                    HashMap<String,Question> hashMap = new HashMap<>();
                    hashMap.put(answer,question);
                    TestMemory.getTestMemory().getAnswerMap().put(question.getId(),hashMap);

                    //加载数据
                    question = TestMemory.getTestMemory().getQuestionArrayList().get(question.getId());
                    answer = TestMemory.getTestMemory().getAnswerMap().get(question.getId()) != null ? (String)TestMemory.getTestMemory().getAnswerMap().get(question.getId()).keySet().toArray()[0] : "";
                    //设置复选框
                    String[] answerList = answer.split("/");
                    checkboxA.setSelected(false);
                    checkboxB.setSelected(false);
                    checkboxC.setSelected(false);
                    checkboxD.setSelected(false);
                    for (String data : answerList) {
                        if("1".equals(data)) checkboxA.setSelected(true);
                        if("2".equals(data)) checkboxB.setSelected(true);
                        if("3".equals(data)) checkboxC.setSelected(true);
                        if("4".equals(data)) checkboxD.setSelected(true);
                    }
                    String text = question.getTitle() + "\n" + question.getOptionA() + "\n" + question.getOptionB()+ "\n" + question.getOptionC()+ "\n" + question.getOptionD();
                    jTextArea.setText(text);
                    leftdown.setText("题目："+config.getString("QuestionNumber")+"的第"+question.getId()+"题");
                }else{
                    JOptionPane.showMessageDialog(frame,"已经是最后一题！");
                }
            }
        });

        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //存答案
                String answer = "";
                if (checkboxA.isSelected()){
                    answer += "/1";
                }
                if (checkboxB.isSelected()){
                    answer += "/2";
                }
                if (checkboxC.isSelected()){
                    answer += "/3";
                }
                if (checkboxD.isSelected()){
                    answer += "/4";
                }
                answer = answer.length() > 1 ? answer.substring(1) : answer;
                HashMap<String,Question> hashMap = new HashMap<>();
                hashMap.put(answer,question);
                TestMemory.getTestMemory().getAnswerMap().put(question.getId(),hashMap);
                int size = 0;
                for (int i = 0; i < config.getInt("QuestionNumber"); i++) {
                    if(TestMemory.getTestMemory().getAnswerMap().get(i) != null){
                        if(!"".equals(TestMemory.getTestMemory().getAnswerMap().get(i).keySet().toArray()[0])) size++;
                    }
                }
                int isDetermine = JOptionPane.showConfirmDialog(null, config.getString("QuestionNumber") + "题已做" + size + "题,确认交卷？", "确认交卷",JOptionPane.YES_NO_OPTION);
                if(isDetermine == 0){
                    JOptionPane.showMessageDialog(frame, "你一共得了"+MyUtil.calculationScore()+"分");
                    MenuFrame menuFrame = new MenuFrame();
                    menuFrame.show();
                    close();
                }
            }
        });

        //计时
        AtomicInteger mm = new AtomicInteger(config.getInt("TimeLimit"));
        AtomicInteger ss = new AtomicInteger();
        new Thread(() -> {
            while(true){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (ss.get() == 0) {
                    mm.getAndDecrement();
                    ss.set(59);
                } else {
                    ss.getAndDecrement();
                }
                if(mm.get() == 0 && ss.get() == 0){
                    //存答案
                    String answer = "";
                    if (checkboxA.isSelected()){
                        answer += "/1";
                    }
                    if (checkboxB.isSelected()){
                        answer += "/2";
                    }
                    if (checkboxC.isSelected()){
                        answer += "/3";
                    }
                    if (checkboxD.isSelected()){
                        answer += "/4";
                    }
                    answer = answer.length() > 1 ? answer.substring(1) : answer;
                    HashMap<String,Question> hashMap = new HashMap<>();
                    hashMap.put(answer,question);
                    TestMemory.getTestMemory().getAnswerMap().put(question.getId(),hashMap);
                    JOptionPane.showMessageDialog(frame, "你一共得了"+MyUtil.calculationScore()+"分");
                    MenuFrame menuFrame = new MenuFrame();
                    menuFrame.show();
                    close();
                    break;
                }
                rightdown.setText("剩余时间："+mm+"："+ss);
            }
        }).start();
        return panel;
    }
    public void show(){
        this.frame.setVisible(true);
    }

    public void close(){
        TestMemory.getTestMemory().clear();
        this.frame.setVisible(false);
    }
}
