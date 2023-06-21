package geng.view;

import geng.handle.HandleFreePages;
import geng.model.free;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class freePages extends JPanel implements ActionListener {
   free free;
   JTextField inputidx;
   JButton buttonFree;

   freePages() {
      free = new free();
      inputidx = new JTextField(12);
      buttonFree = new JButton("Free memory");
      add(new JLabel("Input the Index of the Following Free Record£º"));
      add(inputidx);

      buttonFree.addActionListener(this);
      add(buttonFree);
   }

   public void actionPerformed(ActionEvent e) {
      free.setInpuIdx(inputidx.getText());

//      System.out.println(inputidx.getText());
      HandleFreePages handleFreePages = new HandleFreePages();
      handleFreePages.handleFreePages(free);

   }
}
