package main;

import BuddySystem.BuddySystem;

import java.awt.*;

public class main {


    public static void main(String args[]) {
        MainWindow.bs = new BuddySystem();
        MainWindow window = new MainWindow();

        window.setTitle("Buddy System Demo Memory Allocation");
        window.setFont(new Font("ËÎÌו",1,24));

    }
}
