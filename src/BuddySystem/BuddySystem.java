package BuddySystem;

import Page.Page;

import java.util.ArrayList;
import java.util.LinkedList;
public class BuddySystem {

    public static final int MAX_ORDER = 11; // 最大阶数
    public static final int PAGE_SIZE = 1 << 9; // 页面大小
    public static final int MEM_SIZE = 1 << 20; // 模拟内存大小

    // 页面类


    public static LinkedList<Page>[] freeArea; // 空闲页链表数组
    public static Page[] memPool; // 模拟内存池

    // 构造方法，初始化内存池和空闲页链表
    public BuddySystem() {
        int n = MEM_SIZE / PAGE_SIZE; // 总页数
        memPool = new Page[n]; // 分配模拟内存池
        for (int i = 0; i < n; i++) { // 初始化每个页面
            memPool[i] = new Page(i);
        }
        freeArea = new LinkedList[MAX_ORDER]; // 分配空闲页链表数组
        for (int i = 0; i < MAX_ORDER; i++) { // 初始化每个链表
            freeArea[i] = new LinkedList<>();
        }
        freeArea[MAX_ORDER - 1].add(memPool[0]); // 将整个内存池作为一个最大阶的空闲块
    }

    // 判断两个页面是否是伙伴
    public boolean isBuddy(Page p1, Page p2, int order) {
        if (p1 == null || p2 == null) return false; // 空指针不是伙伴
        if (p1.allocated || p2.allocated) return false; // 已分配不是伙伴
        int indexDiff = p1.index - p2.index; // 索引差值
        if (indexDiff == (1 << order) || indexDiff == -(1 << order)) return true; // 索引差值等于阶数对应的页数则是伙伴
        return false;
    }

    // 在空闲页链表中插入一个页面
    public void insertPage(Page p, int order) {
        p.order = order; // 设置阶数
        p.allocated = false; // 设置未分配
        freeArea[order].addFirst(p); // 插入到链表头部
    }

    // 在空闲页链表中删除一个页面
    public void deletePage(Page p, int order) {
        freeArea[order].remove(p); // 删除页面
    }

    // 分配一个指定阶数的内存块，返回页面对象，失败返回null
    public Page allocPages(int order) {
        if (order < 0 || order >= MAX_ORDER) return null; // 阶数越界
        if (!freeArea[order].isEmpty()) { // 如果有空闲块
            Page p = freeArea[order].removeFirst(); // 取出链表头部的页面
            p.allocated = true; // 设置已分配
            p.order = order;
            return p; // 返回页面对象
        } else { // 如果没有空闲块
            Page p = allocPages(order + 1); // 尝试分配更高阶的内存块
            if (p == null) return null; // 分配失败返回null
            Page buddy = memPool[p.index + (1 << order)]; // 找到伙伴页面
            insertPage(buddy, order); // 将伙伴页面插入到空闲链表中
            p.allocated = true; // 设置已分配
            p.order = order;
            return p; // 返回页面对象
        }
    }

    // 释放一个指定阶数的内存块，传入页面对象
    public void freePages(Page p, int order) {
//        MainWindow.bs.printFreeArea();

        if (p == null || order < 0 || order >= MAX_ORDER) return; // 参数无效
        Page buddy = null;
        p.allocated = false;
        for (Page curr : freeArea[order]) {
            if (isBuddy(p, curr, order)) { // 如果找到伙伴页面
                buddy = curr;
                break;
            }
        }

        if (buddy == null) { // 如果没有找到伙伴页面，直接插入到空闲链表中
            insertPage(p, order);
        } else { // 如果找到了伙伴页面，合并成更大的块，并递归释放
            deletePage(buddy, order); // 删除伙伴页面

            Page merged = p.index < buddy.index ? p : buddy; // 合并后的页面为索引较小者
//            insertPage(merged, order+1);
            freePages(merged, order + 1); // 递归释放更高阶的块
        }
//        MainWindow.bs.printFreeArea();
    }

    // 打印空闲页链表信息，用于调试
    public void printFreeArea() {
        for (int i = 0; i < MAX_ORDER; i++) {
            System.out.print("order " + i + ": ");
            for (Page p : freeArea[i]) {
                System.out.print(p.index + " ");
            }
            System.out.println();
        }
    }

    public String getFreeAreaText() {
        String res = new String(" free block address: <br>");
        for (int i = 0; i < MAX_ORDER; i++) {
            res += "order " + Integer.toString(i) + ": ";
            for (Page p : freeArea[i]) {
                res += p.index + " ";
            }
//            System.out.println();
            res += "<br>";
        }
        return res + "</html>";
    }

    public LinkedList<Page>[] getFreeArea() {
        return freeArea;
    }
    public ArrayList<Page> turn() {
        ArrayList<Page> res = new ArrayList<>();
        for (int i = 0; i < MAX_ORDER; i++) {

            for (Page p : freeArea[i]) {
                res.add(p);
            }
        }
        return res;
    }
}
