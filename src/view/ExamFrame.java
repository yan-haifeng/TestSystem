package view;

import beans.User;
import memory.DataMemory;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class ExamFrame {
    JFrame frame = new JFrame();
    User user;
    public ExamFrame(){
        init();
    }

    private void init(){
        frame.setTitle("指针信息在线测评");
        frame.setSize(800,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        user = DataMemory.getDataMemory().getLoginUser();
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
        JLabel examtime = new JLabel("10分钟");
        examtime.setBounds(380,90,100,25);
        panel.add(examtime);

        JLabel examtypeLabel = new JLabel("考试类别：");
        examtypeLabel.setBounds(440,90,100,25);
        panel.add(examtypeLabel);
        JLabel type = new JLabel("JavaSE阶段测试（一）");
        type.setBounds(500,90,150,25);
        panel.add(type);

        JLabel examcountLabel = new JLabel("题目数量：");
        examcountLabel.setBounds(650,90,100,25);
        panel.add(examcountLabel);
        JLabel count = new JLabel("10");
        count.setBounds(710,90,150,25);
        panel.add(count);

        TextField textField = new TextField();
        textField.setBounds(50,140,680,260);
        panel.add(textField);

        JLabel kuang = new JLabel();
        kuang.setBounds(40,120,200,200);
        kuang.setSize(new Dimension(700, 290));
        panel.add(kuang, BorderLayout.CENTER);
        kuang.setBorder(BorderFactory.createTitledBorder("题目"));

        JCheckBox checkbox1 = new JCheckBox("A");
        checkbox1.setBounds(260,420,40,40);
        panel.add(checkbox1);
        JCheckBox checkbox2 = new JCheckBox("B");
        checkbox2.setBounds(340,420,40,40);
        panel.add(checkbox2);
        JCheckBox checkbox3 = new JCheckBox("C");
        checkbox3.setBounds(420,420,40,40);
        panel.add(checkbox3);
        JCheckBox checkbox4 = new JCheckBox("D");
        checkbox4.setBounds(500,420,40,40);
        panel.add(checkbox4);

        JButton button1 = new JButton("上一题");
        button1.setBounds(200,480,80,40);
        panel.add(button1);
        JButton button2 = new JButton("下一题");
        button2.setBounds(350,480,80,40);
        panel.add(button2);
        JButton button3 = new JButton("交卷");
        button3.setBounds(500,480,80,40);
        panel.add(button3);

        JLabel leftdown = new JLabel("题目：20的1题");
        leftdown.setBounds(20,520,100,25);
        panel.add(leftdown);

        JLabel rightdown = new JLabel("剩余时间：0：9：56");
        rightdown.setBounds(630,520,150,25);
        panel.add(rightdown);
        return panel;
    }
    public void show(){
        this.frame.setVisible(true);
    }

    public void close(){
        this.frame.setVisible(false);
    }
}
