package view;

import beans.User;

import java.util.Objects;
import javax.swing.*;

public class MenuFrame{
    JFrame frame = new JFrame();

    User user = null;
    MenuFrame(User user){
        frame.setTitle("指针信息在线测评");
        frame.setSize(800,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setUser(user);
        frame.add(this.getMenuJPanel());
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
    }

    public void setUser(User user) {
        this.user = user;
    }

    private JPanel getMenuJPanel(){
        JPanel panel = new JPanel();
        panel.setLayout(null);
        JLabel title = new JLabel();
        Icon icon = new ImageIcon(Objects.requireNonNull(MenuFrame.class.getResource("/images/title.png")));
        title.setIcon(icon);
        title.setBounds(120,20,800,100);
        panel.add(title);

        JLabel textField = new JLabel(user.getName() + "同学你好");
        textField.setBounds(360,10,680,260);
        panel.add(textField);


        JLabel textField1 = new JLabel("开始");
        textField1.setBounds(180,260,50,50);
        panel.add(textField1);
        JButton jButton1 = new JButton();
        Icon icon1 = new ImageIcon(Objects.requireNonNull(MenuFrame.class.getResource("/images/exam.png")));
        jButton1.setIcon(icon1);
        jButton1.setBounds(150,170,100,100);
        panel.add(jButton1);

        JLabel textField2 = new JLabel("分数");
        textField2.setBounds(325,260,50,50);
        panel.add(textField2);
        JButton jButton2 = new JButton();
        Icon icon2 = new ImageIcon(Objects.requireNonNull(MenuFrame.class.getResource("/images/result.png")));
        jButton2.setIcon(icon2);
        jButton2.setBounds(290,170,100,100);
        panel.add(jButton2);

        JLabel textField3 = new JLabel("考试规则");
        textField3.setBounds(455,260,60,50);
        panel.add(textField3);
        JButton jButton3 = new JButton();
        Icon icon3 = new ImageIcon(Objects.requireNonNull(MenuFrame.class.getResource("/images/message.png")));
        jButton3.setIcon(icon3);
        jButton3.setBounds(430,170,100,100);
        panel.add(jButton3);

        JLabel textField4 = new JLabel("离开");
        textField4.setBounds(605,260,50,50);
        panel.add(textField4);
        JButton jButton4 = new JButton();
        Icon icon4 = new ImageIcon(Objects.requireNonNull(MenuFrame.class.getResource("/images/exit.png")));
        jButton4.setIcon(icon4);
        jButton4.setBounds(570,170,100,100);
        panel.add(jButton4);

        JLabel rightdown = new JLabel("指针信息--版权所有 盗版必究");
        rightdown.setBounds(600,520,180,25);
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