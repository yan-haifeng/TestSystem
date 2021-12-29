package view;

import controller.UserController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame {
    private JFrame frame = new JFrame("登录系统");
    public LoginFrame(){
        frame.setSize(400, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(this.getLoginPanel());
        frame.setLocationRelativeTo(null);
    }

    private JPanel getLoginPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(null);

        // 创建 JLabel
        JLabel userTitle = new JLabel("登录考试系统");
        userTitle.setBounds(150,10,100,30);
        panel.add(userTitle);

        /*
         * 创建用户输入
         */
        JLabel userLabel = new JLabel("编号:");
        userLabel.setBounds(10,50,80,25);
        panel.add(userLabel);

        JTextField userText = new JTextField(20);
        userText.setBounds(100,50,260,25);
        panel.add(userText);

        // 输入密码的文本域
        JLabel passwordLabel = new JLabel("密码:");
        passwordLabel.setBounds(10,80,80,25);
        panel.add(passwordLabel);

        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(100,80,260,25);
        panel.add(passwordText);

        // 创建登录按钮
        JButton loginButton = new JButton("login");
        loginButton.setBounds(80, 150, 100, 40);
        panel.add(loginButton);

        //登录点击事件
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = userText.getText();
                String password = new String(passwordText.getPassword()).trim();
                UserController userController = new UserController();
                if(userController.login(username,password)){
                    MenuFrame menuFrame = new MenuFrame();
                    menuFrame.show();
                    close();
                }else{
                    //登录失败
                    JOptionPane.showMessageDialog(frame,"用户名或密码错误！");
                    System.out.println("密码错误");
                }
            }
        });

        // 创建重置按钮
        JButton cancelButton = new JButton("cancel");
        cancelButton.setBounds(200, 150, 100, 40);
        panel.add(cancelButton);

        return panel;
    }

    public void show(){
        this.frame.setVisible(true);
    }

    public void close(){
        this.frame.setVisible(false);
    }
}
