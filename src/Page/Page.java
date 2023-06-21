package Page;

public class Page {
    public Page next; // 链表指针
    public int order; // 阶数

    public int num; //容量
    public int index; // 索引
    public boolean allocated; // 是否已分配

    public Page(int index) {
        this.next = null;
        this.order = 0;
        this.index = index;
        this.allocated = false;
    }



}