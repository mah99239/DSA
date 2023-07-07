package Data_structure.LinkedList;

public class CircularlyLinkedList {
    ListNode tail;
    int size;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int first() {
        return isEmpty() ? -1 : tail.next.val;
    }

    public int last() {
        return isEmpty() ? -1 : tail.val;
    }

    public void rotate() {
        if (tail != null) {
            tail = tail.next;
        }
    }

    public void addFirst(int value) {//O(1)
        if (isEmpty()) {
            tail = new ListNode(value, null);
            tail.next = tail;
        } else {
            var newest = new ListNode(value, tail.next);
            tail.next = newest;
        }

        size++;
    }

    public void addLast(int value) {//O(1)
        addFirst(value);
        tail = tail.next;
    }

    public int removeFirst() {//O(1)
        if (isEmpty()) return -1;
        var head = tail.next;
        if (head == tail) tail = null;
        else tail.next = head.next;
        size--;


        return head.val;

    }

    public int removeLast() {//O(n)
        if (isEmpty()) return -1;

        if (size == 1) return removeFirst();

        ListNode temp = tail.next;
        while (temp.next != tail) {
            temp = temp.next;
        }

        int remove = tail.val;
        temp.next = tail.next;

        tail = temp;

        size--;
        return remove;
    }

    public void print() {
        if(isEmpty()) return;
        var node = tail.next;
        while (node != tail) {
            System.out.println("value = " + node.val);
            node = node.next;
        }
        System.out.println("value = " + node.val);
    }

    public static void main(String[] args) {
        CircularlyLinkedListK list = new CircularlyLinkedListK();
        list.addFirst(4);
        list.addFirst(3);
        list.addFirst(2);
        list.addFirst(1);
        list.addLast(5);
        list.addFirst(1);
        System.out.println(list.removeLast());
        System.out.println(list.removeLast());
        System.out.println(list.removeLast());
        System.out.println(list.removeLast());
        System.out.println(list.removeLast());
        System.out.println(list.removeLast());


        list.print();
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int value, ListNode n) {
            val = value;
            next = n;
        }
    }

}
