package geng.view;

import javax.swing.*;
import java.awt.*;
public class warning extends JDialog {
    public warning() {
        setVisible(true);
        setBounds(500, 100, 400, 300);
//        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); ���Ƕ���� ����Ĭ���йرն���

        Container container = getContentPane();

        container.add(new JLabel("invalid input, try it again",JLabel.CENTER));
//        container.setBackground(Color.YELLOW);
    }


}
