package leetcode.list;

public class LinkedListCycle2 {

    ListNode tail = null;
    int size = 0;

    public  void addFirst(int x)
    {
        if(size == 0)
        {
            tail = new ListNode(x);
            tail.next = tail;
        }else {
            ListNode node = new ListNode(x);
            node.next = tail.next;
            tail.next = node;
        }
        size++;

    }
    public void addLast(int x)
    {
        addFirst(x);
        tail = tail.next;
    }

    public ListNode first()
    {
        return tail.next;
    }
    public void setTail(ListNode head)
    {
        tail = null;
        ListNode temp = head;
        while (temp.next != null){
            temp = temp.next;
            System.out.println(1);
        }
        tail = temp;
        tail.next = head;
    }
    class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null)
        {
            fast = fast.next.next;
            slow = slow.next;
            if(slow == fast)
            {
                while(slow != head)
                {
                    head = head.next;
                    slow = slow.next;
                }
                return head;
            }
        }
        return null;

    }
    public void print()
    {
        ListNode temp = tail.next;
        int i = 0;
        while(i < size && temp!= null){
                i++;
            System.out.println(temp.val);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {



        LinkedListCycle2 l = new LinkedListCycle2();
        l.addFirst(3);
        l.addFirst(2);
        l.addFirst(1);
       // l.print();
        System.out.println(l.detectCycle(l.tail.next));

    }
}
