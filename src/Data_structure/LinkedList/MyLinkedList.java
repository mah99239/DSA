package Data_structure.LinkedList;

public class MyLinkedList {

    public ListNode head;
    private int size;


    class ListNode {
        int value;
        ListNode next;

        ListNode(int x) {
            this.value = x;

        }

        ListNode(int val, ListNode next) {
            this.value = val;
            this.next = next;
        }

    }


    public MyLinkedList() {
        head = null;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int get(int index) {
        if (index >= size) {
            return -1;
        }
        ListNode node = head;

        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node.value;
    }

    public int size() {
        return size;
    }

    public void addAtHead(int val) {
        ListNode newNode = new ListNode(val);//initialize new node

        if (isEmpty()) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }

        size++;

    }


    public void addAtTail(int val) {
        if (isEmpty()) {
            addAtHead(val);
        } else {
            ListNode node = new ListNode(val);
            ListNode cur = head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = node;
            node.next = null;
            size++;
        }
    }

    public void addAtIndex(int index, int val) {
        if (index > size) return;
      /*  if(index == size)
        {
            addAtTail(val);
            return;
        }*/
        ListNode newNode = new ListNode(val);

        if (head == null) {
            head = newNode;
            size++;
            return;
        }

        if (index == 0) {
            newNode.next = head;
            head = newNode;
            size++;
            return;
        }

        ListNode cur = head;
        for (int i = 0; i < index - 1; i++) {
            cur = cur.next;
            // System.out.println(i);
        }

        newNode.next = cur.next;
        cur.next = newNode;
        size++;
    }

    public void deleteAtIndex(int index) {
        if (index >= size) return;
        if (index == 0) {
            ListNode destroy = head;
            head = head.next;
            destroy = null; // delete by the garbage collector.
            size--;
            return;
        }
        ListNode cur = head;
        for (int i = 0; i < index - 1; i++) {
            cur = cur.next;
        }
        ListNode destroy = cur.next;
        cur.next = cur.next != null ? cur.next.next : null;
        destroy = null;
        size--;
    }

    public void print() {
        if (isEmpty()) return;
        ListNode temp = head;
        while (temp != null) {
            System.out.println(String.valueOf(temp.value));
            temp = temp.next;
        }


    }

    public static void main(String[] args) {
        MyLinkedList obj = new MyLinkedList();
        obj.addAtHead(2);
        obj.deleteAtIndex(1);
        obj.addAtHead(2);
        obj.addAtHead(7);
        obj.addAtHead(3);
        obj.addAtHead(2);
        obj.addAtHead(5);
        obj.addAtTail(5);
        System.out.println(obj.get(5));
        obj.deleteAtIndex(6);
        obj.deleteAtIndex(4);

        //  obj.deleteAtIndex(0);
        //   System.out.println(obj.get(0));


        /*
         *
         * Your MyLinkedList object will be instantiated and called as such:
         * MyLinkedList obj = new MyLinkedList();
         * int param_1 = obj.get(index);
         * obj.addAtHead(val);
         * obj.addAtTail(val);
         * obj.addAtIndex(index,val);
         * obj.deleteAtIndex(index);
         */
        //  ob.deleteAtIndex(1);
        //  System.out.println(ob.size);
        // ob.print();
        //  ob.deleteAtIndex(8);
        // System.out.println(ob.get(7));
    }

}
