package view;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class Welcome {
    JFrame frame = new JFrame("欢迎进入指针信息在线评系统");
    public Welcome(){
        frame.setSize(430,300);
        JPanel panel= new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                ImageIcon icon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/welcome.png")));
                Image img = icon.getImage();
                g.drawImage(img, 0, 0, icon.getIconWidth(), icon.getIconHeight(), icon.getImageObserver());
            }
        };
        frame.add(panel);
        frame.setResizable(false);
        frame.dispose();
        frame.setUndecorated(true);
        frame.setLocationRelativeTo(null);
    }

    public void show(){
        frame.setVisible(true);
    }

    public void close(){
        frame.setVisible(false);
    }
}
