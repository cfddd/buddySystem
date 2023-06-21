package geng.view;

import javax.swing.*;
import java.awt.*;
public class warning extends JDialog {
    public warning() {
        setVisible(true);
        setBounds(500, 100, 400, 300);
//        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); 这是多余的 弹窗默认有关闭动作

        Container container = getContentPane();

        container.add(new JLabel("invalid input, try it again",JLabel.CENTER));
//        container.setBackground(Color.YELLOW);
    }


}
