package geng.view;

import geng.handle.HandleAllocation;
import geng.model.allocation;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class allocPages extends JPanel implements ActionListener {
   allocation allocation;
   JTextField inputSize;
   JButton buttonAllocate;
   allocPages() {
      allocation = new allocation();


      inputSize = new JTextField(12);
      add(inputSize);

      buttonAllocate = new JButton("Allocate");
      add(new JLabel("The required Size(2^x)£º"));
      add(buttonAllocate);
      buttonAllocate.addActionListener(this);

//      add(new JLabel("The required Size(Rand)£º"));



   }
   public void actionPerformed(ActionEvent e) {
      allocation.setInPutSize(inputSize.getText());
      System.out.println(allocation.getInPutSize());


//      char [] pw =inputPassword.getPassword();
//      allocPages.setPassword(new String(pw));
//      allocPages.setBirth(inputBirth.getText());
      HandleAllocation handleAllocation = new HandleAllocation();
      handleAllocation.showAllocation(allocation);
   }


}