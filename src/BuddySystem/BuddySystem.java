package BuddySystem;

import Page.Page;

import java.util.ArrayList;
import java.util.LinkedList;
public class BuddySystem {

    public static final int MAX_ORDER = 11; // ������
    public static final int PAGE_SIZE = 1 << 9; // ҳ���С
    public static final int MEM_SIZE = 1 << 20; // ģ���ڴ��С

    // ҳ����


    public static LinkedList<Page>[] freeArea; // ����ҳ��������
    public static Page[] memPool; // ģ���ڴ��

    // ���췽������ʼ���ڴ�غͿ���ҳ����
    public BuddySystem() {
        int n = MEM_SIZE / PAGE_SIZE; // ��ҳ��
        memPool = new Page[n]; // ����ģ���ڴ��
        for (int i = 0; i < n; i++) { // ��ʼ��ÿ��ҳ��
            memPool[i] = new Page(i);
        }
        freeArea = new LinkedList[MAX_ORDER]; // �������ҳ��������
        for (int i = 0; i < MAX_ORDER; i++) { // ��ʼ��ÿ������
            freeArea[i] = new LinkedList<>();
        }
        freeArea[MAX_ORDER - 1].add(memPool[0]); // �������ڴ����Ϊһ�����׵Ŀ��п�
    }

    // �ж�����ҳ���Ƿ��ǻ��
    public boolean isBuddy(Page p1, Page p2, int order) {
        if (p1 == null || p2 == null) return false; // ��ָ�벻�ǻ��
        if (p1.allocated || p2.allocated) return false; // �ѷ��䲻�ǻ��
        int indexDiff = p1.index - p2.index; // ������ֵ
        if (indexDiff == (1 << order) || indexDiff == -(1 << order)) return true; // ������ֵ���ڽ�����Ӧ��ҳ�����ǻ��
        return false;
    }

    // �ڿ���ҳ�����в���һ��ҳ��
    public void insertPage(Page p, int order) {
        p.order = order; // ���ý���
        p.allocated = false; // ����δ����
        freeArea[order].addFirst(p); // ���뵽����ͷ��
    }

    // �ڿ���ҳ������ɾ��һ��ҳ��
    public void deletePage(Page p, int order) {
        freeArea[order].remove(p); // ɾ��ҳ��
    }

    // ����һ��ָ���������ڴ�飬����ҳ�����ʧ�ܷ���null
    public Page allocPages(int order) {
        if (order < 0 || order >= MAX_ORDER) return null; // ����Խ��
        if (!freeArea[order].isEmpty()) { // ����п��п�
            Page p = freeArea[order].removeFirst(); // ȡ������ͷ����ҳ��
            p.allocated = true; // �����ѷ���
            p.order = order;
            return p; // ����ҳ�����
        } else { // ���û�п��п�
            Page p = allocPages(order + 1); // ���Է�����߽׵��ڴ��
            if (p == null) return null; // ����ʧ�ܷ���null
            Page buddy = memPool[p.index + (1 << order)]; // �ҵ����ҳ��
            insertPage(buddy, order); // �����ҳ����뵽����������
            p.allocated = true; // �����ѷ���
            p.order = order;
            return p; // ����ҳ�����
        }
    }

    // �ͷ�һ��ָ���������ڴ�飬����ҳ�����
    public void freePages(Page p, int order) {
//        MainWindow.bs.printFreeArea();

        if (p == null || order < 0 || order >= MAX_ORDER) return; // ������Ч
        Page buddy = null;
        p.allocated = false;
        for (Page curr : freeArea[order]) {
            if (isBuddy(p, curr, order)) { // ����ҵ����ҳ��
                buddy = curr;
                break;
            }
        }

        if (buddy == null) { // ���û���ҵ����ҳ�棬ֱ�Ӳ��뵽����������
            insertPage(p, order);
        } else { // ����ҵ��˻��ҳ�棬�ϲ��ɸ���Ŀ飬���ݹ��ͷ�
            deletePage(buddy, order); // ɾ�����ҳ��

            Page merged = p.index < buddy.index ? p : buddy; // �ϲ����ҳ��Ϊ������С��
//            insertPage(merged, order+1);
            freePages(merged, order + 1); // �ݹ��ͷŸ��߽׵Ŀ�
        }
//        MainWindow.bs.printFreeArea();
    }

    // ��ӡ����ҳ������Ϣ�����ڵ���
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
