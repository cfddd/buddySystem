package geng.cheshi;

import javax.swing.*;
import java.awt.*;

public class BarChart extends JFrame {

   public BarChart() {
      setTitle("Java����һ�����ڣ���ʾһ�������Σ���ͬ��������ɫ��ͬ����������");
      setSize(2000, 400);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      BarPanel bp = new BarPanel(); // ����һ���Զ���������
      Container c = getContentPane(); // ��ȡ���ݴ���
      c.add(bp); // �������ӵ����ݴ���
      setVisible(true); // ���ô��ڿɼ�


   }


//   public static void main(String[] args) {
//      new BarChart(); // ����һ��ʵ��������
//   }
}

class BarPanel extends JPanel {

   @Override
   public void paintComponent(Graphics g) {
      super.paintComponent(g);
      int width = getWidth(); // ��ȡ���Ŀ��
      int height = getHeight(); // ��ȡ���ĸ߶�
      int barWidth = width / 4; // ���ó����εĿ��Ϊ����ȵ��ķ�֮һ
      int barHeight = height / 2; // ���ó����εĸ߶�Ϊ���߶ȵĶ���֮һ
      int x = width / 8; // ���ó����ε���ʼ������Ϊ����ȵİ˷�֮һ
      int y = height / 4; // ���ó����ε���ʼ������Ϊ���߶ȵ��ķ�֮һ

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
   }


}
