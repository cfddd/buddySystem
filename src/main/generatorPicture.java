package main;

import BuddySystem.BuddySystem;
import Page.Page;

import javax.swing.*;
import java.awt.*;

public class generatorPicture extends JFrame {
    BarPanel bp;
    Container c;

    public generatorPicture() {
        setTitle("Java����һ�����ڣ���ʾһ�������Σ���ͬ��������ɫ��ͬ����������");
        setSize(2000, 400);
        setBounds(0,800,2000,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        bp = new BarPanel(); // ����һ���Զ���������


        c = getContentPane(); // ��ȡ���ݴ���
        c.add(bp); // �������ӵ����ݴ���
        setVisible(true); // ���ô��ڿɼ�

    }

    public static void main(String[] args) {
        new generatorPicture(); // ����һ��ʵ��������
    }
}

class BarPanel extends JPanel {
    Color color[] = new Color[20];

    public BarPanel()
    {
        color[0] = Color.red;
        color[1] = Color.ORANGE;
        color[2] = Color.yellow;
        color[3] = Color.green;
        color[4] = Color.blue;
        color[5] = Color.CYAN;
        color[6] = Color.MAGENTA;
        color[7] = Color.pink;
        color[8] = Color.DARK_GRAY;
        color[9] = Color.white;
        color[10] = Color.black;
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int width = getWidth(); // ��ȡ���Ŀ��
        int height = getHeight(); // ��ȡ���ĸ߶�
        int barWidth = width / 4; // ���ó����εĿ��Ϊ����ȵ��ķ�֮һ
        int barHeight = height / 2; // ���ó����εĸ߶�Ϊ���߶ȵĶ���֮һ
        int x = width / 8; // ���ó����ε���ʼ������Ϊ����ȵİ˷�֮һ
        int y = height / 4; // ���ó����ε���ʼ������Ϊ���߶ȵ��ķ�֮һ
        for (int i = 0; i < BuddySystem.MAX_ORDER; i++) {
//            System.out.print("order " + i + ": ");
            for (Page p : BuddySystem.freeArea[i]) {
//                System.out.print(p.index + " ");
                int order = i;
                int start = p.index;
                g.setColor(color[order]);
                g.fillRect(start*2,y,1<<order+1, barHeight);
//                g.fillRect(0,y,400, barHeight);
                g.setColor(Color.black);
                g.drawString(Integer.toString(start), start*2, y - 10); // �����Ϸ���ʾ����

            }
//            System.out.println();
        }
//        for(Page x : HandleAllocation.existPages)
//        {
//            int order = x.order;
//            int start = x.index;
//            g.setColor(color[order]);
//            g.fillRect(start,y,1<<order, barHeight);
//            g.setColor(Color.black);
//            g.drawString(Integer.toString(start), start, y - 10); // �����Ϸ���ʾ����
//
//        }
/*

        g.setColor(Color.red); // ���û�����ɫΪ��ɫ
        g.fillRect(x, y, barWidth / 3, barHeight); // ����һ������ĳ�����
        g.setColor(Color.black); // ���û�����ɫΪ��ɫ
        g.drawString("100", x, y - 10); // �ڵ�һ�������Ϸ���ʾ����

        g.setColor(Color.green); // ���û�����ɫΪ��ɫ
        g.fillRect(x + barWidth / 3, y, barWidth / 3, barHeight); // ���ڶ�������ĳ�����
        g.setColor(Color.black); // ���û�����ɫΪ��ɫ
        g.drawString("200", x + barWidth / 3, y - 10); // �ڵڶ��������Ϸ���ʾ����

        g.setColor(Color.blue); // ���û�����ɫΪ��ɫ
        g.fillRect(x + barWidth * 2 / 3, y, barWidth / 3, barHeight); // ������������ĳ�����
        g.setColor(Color.black); // ���û�����ɫΪ��ɫ
        g.drawString("300", x + barWidth * 2 / 3, y - 10); // �ڵ����������Ϸ���ʾ����

*/
    }

}
