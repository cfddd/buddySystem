package geng.cheshi;

import javax.swing.*;
import java.awt.*;

public class BarChart extends JFrame {

   public BarChart() {
      setTitle("Java生成一个窗口，显示一个长条形，不同区间上颜色不同，表上数字");
      setSize(2000, 400);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      BarPanel bp = new BarPanel(); // 创建一个自定义的面板类
      Container c = getContentPane(); // 获取内容窗格
      c.add(bp); // 将面板添加到内容窗格
      setVisible(true); // 设置窗口可见


   }


//   public static void main(String[] args) {
//      new BarChart(); // 创建一个实例化对象
//   }
}

class BarPanel extends JPanel {

   @Override
   public void paintComponent(Graphics g) {
      super.paintComponent(g);
      int width = getWidth(); // 获取面板的宽度
      int height = getHeight(); // 获取面板的高度
      int barWidth = width / 4; // 设置长条形的宽度为面板宽度的四分之一
      int barHeight = height / 2; // 设置长条形的高度为面板高度的二分之一
      int x = width / 8; // 设置长条形的起始横坐标为面板宽度的八分之一
      int y = height / 4; // 设置长条形的起始纵坐标为面板高度的四分之一

      g.setColor(Color.red); // 设置画笔颜色为红色
      g.fillRect(x, y, barWidth / 3, barHeight); // 填充第一个区间的长方形
      g.setColor(Color.black); // 设置画笔颜色为黑色
      g.drawString("100", x, y - 10); // 在第一个区间上方显示数字

      g.setColor(Color.green); // 设置画笔颜色为绿色
      g.fillRect(x + barWidth / 3, y, barWidth / 3, barHeight); // 填充第二个区间的长方形
      g.setColor(Color.black); // 设置画笔颜色为黑色
      g.drawString("200", x + barWidth / 3, y - 10); // 在第二个区间上方显示数字

      g.setColor(Color.blue); // 设置画笔颜色为蓝色
      g.fillRect(x + barWidth * 2 / 3, y, barWidth / 3, barHeight); // 填充第三个区间的长方形
      g.setColor(Color.black); // 设置画笔颜色为黑色
      g.drawString("300", x + barWidth * 2 / 3, y - 10); // 在第三个区间上方显示数字
   }


}
