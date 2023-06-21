package geng.view;
import javax.swing.*; 
import java.awt.*;
public class mainView extends JPanel{
    JTabbedPane p;
    allocPages allocPages;
    freePages freePages;
    public mainView(){
        allocPages=new allocPages();
        freePages = new freePages();
        setLayout(new BorderLayout());
        p = new JTabbedPane();
        p.add("Input Memory requirements",allocPages);
        p.add("Free memory",freePages);
        p.validate();
        add(p,BorderLayout.CENTER); 
    }
//    public boolean isLoginSuccess() {
//        return loginView.isLoginSuccess();
//    }
}