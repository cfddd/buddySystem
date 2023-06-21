package geng.handle;

import geng.model.free;
import geng.view.warning;
import main.MainWindow;
public class HandleFreePages {
   public void handleFreePages(free free) {
//      MainWindow.bs.freePages(new Page(Integer.valueOf(free.getInputStart()).intValue())
//              ,Integer.valueOf(free.getInputSize()).intValue());
      int n = HandleAllocation.existPages.size();
      System.out.println(n);
      int c = Integer.valueOf(free.getInpuIdx()).intValue();
      System.out.println(c);
      if(n <= c)
      {
         warning t = new warning();
         return;
      }
      MainWindow.bs.freePages(HandleAllocation.existPages.get(c),HandleAllocation.existPages.get(c).order);

      HandleAllocation.existPages.remove(c);

      MainWindow.bs.printFreeArea();
      MainWindow.setTip(HandleAllocation.getPageListText() + MainWindow.bs.getFreeAreaText());
   }
}
