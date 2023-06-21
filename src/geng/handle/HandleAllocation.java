package geng.handle;

import Page.Page;
import geng.model.allocation;
import main.MainWindow;

import java.util.ArrayList;

public class HandleAllocation {
   public static ArrayList<Page> existPages = new ArrayList<>();
   public void showAllocation(allocation allocation) {
      int t = Integer.valueOf(allocation.getInPutSize()).intValue();
      System.out.println(t);
      HandleAllocation.existPages.add(MainWindow.bs.allocPages(t));
      MainWindow.bs.printFreeArea();
      MainWindow.setTip(getPageListText() + MainWindow.bs.getFreeAreaText());
   }

   public static String getPageListText(){
      String res = new String("<html>The Memory Block has used(index  address  order):<br>");
      int idx = 0;
      for(Page x : HandleAllocation.existPages)
      {
         res += "index " + Integer.toString(idx ++) + ": " +  x.index + " " + x.order + "<br>";
      }
      return res + "</br>";
   }
}
