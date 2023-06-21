package main;

import BuddySystem.BuddySystem;
import geng.font.FontClass;
import geng.handle.HandleAllocation;
import geng.view.mainView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class MainWindow extends JFrame implements ActionListener{
   JButton computerButton;
   static JLabel tip;
   String showText = "<html>Demo the Procession of <br> Memory Allocation: </html>";
   mainView view;
   public static BuddySystem bs;
   MainWindow() {
      setLayout(new FlowLayout());
      setBounds(0,0,1200,1000);


      FontClass.loadIndyFont();//font

      computerButton = new JButton(showText);
      computerButton.addActionListener(this);
      add(computerButton,BorderLayout.NORTH);

      view = new mainView();
      view.setSize(1200,300);

      add(view,0);


      tip = new JLabel();
//      tip.setFont(new Font());
      tip.setSize(300,800);

      tip.setText(HandleAllocation.getPageListText() + bs.getFreeAreaText());
      add(tip);
      tip.setLayout(new FlowLayout());

      setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      setVisible(true); 
   }

   public static void setTip(String str)
   {
      tip.setText(str);
   }

   public void actionPerformed(ActionEvent e) {

      generatorPicture win=new generatorPicture();
   }

}