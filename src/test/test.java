package test;

import BuddySystem.BuddySystem;
import Page.Page;

public class test {
    // 测试代码，模拟一系列进程对内存的请求与释放
    public static void main(String[] args) {
        BuddySystem bs = new BuddySystem(); // 创建一个伙伴系统对象

        bs.printFreeArea(); // 打印空闲页链表信息
        Page []p1 = new Page[10];
        for(int i = 0;i < 10;i ++)
        {
            p1[i] = bs.allocPages(3); // 分配8个连续页帧
        }

        bs.printFreeArea();

        Page p2 = bs.allocPages(4); // 分配16个连续页帧

        bs.printFreeArea();

        Page p3 = bs.allocPages(5); // 分配32个连续页帧

        bs.printFreeArea();
//        p2.allocated = false;
        bs.freePages(p2, 4); // 释放16个连续页帧

        bs.printFreeArea();
//        p1.allocated = false;
        for(int i = 0;i < 10;i ++){
            bs.freePages(p1[i], 3); // 释放8个连续页帧
        }


        bs.printFreeArea();
//        p3.allocated = false;
        bs.freePages(p3, 5); // 释放32个连续页帧

        bs.printFreeArea();
    }
}
