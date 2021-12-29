package view;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class ExamFrame {
    public static JFrame getExam(){
        JFrame frame = new JFrame();
        frame.setTitle("指针信息在线测评");
        frame.setSize(800,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(ExamFrame.getExamPanel());
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        return frame;
    }

    private static JPanel getExamPanel(){
        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel title = new JLabel();
        Icon icon = new ImageIcon(Objects.requireNonNull(ExamFrame.class.getResource("/images/exam_title.png")));
        title.setIcon(icon);
        title.setSize(panel.getPreferredSize());
        title.setBounds(200,0,800,100);
        panel.add(title);

        JLabel nameLabel = new JLabel("姓名：");
        nameLabel.setBounds(100,90,100,25);
        panel.add(nameLabel);
        JLabel name = new JLabel("张三");
        name.setBounds(140,90,100,25);
        panel.add(name);

        JLabel examtimeLabel = new JLabel("考试时间：");
        examtimeLabel.setBounds(200,90,100,25);
        panel.add(examtimeLabel);
        JLabel examtime = new JLabel("10分钟");
        examtime.setBounds(260,90,100,25);
        panel.add(examtime);

        JLabel examtypeLabel = new JLabel("考试类别：");
        examtypeLabel.setBounds(340,90,100,25);
        panel.add(examtypeLabel);
        JLabel type = new JLabel("JavaSE阶段测试（一）");
        type.setBounds(400,90,150,25);
        panel.add(type);

        JLabel examcountLabel = new JLabel("题目数量：");
        examcountLabel.setBounds(560,90,100,25);
        panel.add(examcountLabel);
        JLabel count = new JLabel("10");
        count.setBounds(620,90,150,25);
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
}
