package leetcode.list;

public class DoublyLinkedList {
    ListNode head, tail;
    int size;

    class ListNode {
        int val;
        ListNode next, prev;

        ListNode(int value) {
            this.val = value;
        }

        ListNode() {
        }

        ListNode(int value, ListNode n, ListNode p) {
            this.val = value;
            this.next = n;
            this.prev = p;
        }
    }

    DoublyLinkedList() {
        head = new ListNode(-1, null, null);
        tail = new ListNode(-1, null, head);
        head.next = tail;
    }

    private boolean isEmpty() {
        return size == 0;
    }

    public ListNode first() {
        return  head.next;
    }

    public ListNode last() {
        return tail.prev;
    }

    public int get(int index) {
        if (index >= size || isEmpty()) return -1;
        ListNode cur = first();
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.val;
    }

    public void addAtHead(int val) {
        addBetween(val, first(), head);
    }


    public void addAtTail(int val) {
        addBetween(val, tail, tail.prev);

    }

    public void addAtIndex(int index, int val) {
        if ( index > size) return;
        if(isEmpty()){
            addBetween(val, tail,head);
        }else{
        ListNode cur = first();
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        addBetween(val, cur, cur.prev);}
    }

    public void addBetween(int val, ListNode n, ListNode p) {
        ListNode newest = new ListNode(val, n, p);
        p.next = newest;
        n.prev = newest;
        size++;

    }

    public void deleteAtIndex(int index) {
        if (isEmpty() || index >= size) return;
        ListNode cur = first();
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.prev.next = cur.next;
        cur.next.prev = cur.prev;
        size--;
    }

    public void print() {
        ListNode cur = first();
        while (cur != null & cur != tail) {
            System.out.println(cur.val);
            cur = cur.next;
        }
    }

    public static void main(String[] args) {
        DoublyLinkedList myLinkedList = new DoublyLinkedList();

        myLinkedList.addAtHead(1);
        myLinkedList.addAtTail(3);
        myLinkedList.addAtIndex(1,2);
        System.out.println(  myLinkedList.get(1));
        myLinkedList.deleteAtIndex(1);
        System.out.println(  myLinkedList.get(1));

      //  myLinkedList.print();// linked list becomes 1->2->3
        // return 2

         myLinkedList.print();


    }
}
