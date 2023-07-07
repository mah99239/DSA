package leetcode.list;


public class RemoveNthNodeFromEndOfList {
    int size = 0;
    ListNode head1;

    RemoveNthNodeFromEndOfList() {
        head1 = null;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }


        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public record ListNode2(int val, ListNode2 next) {
        public ListNode2(int val) {
            this(val, null);
        }
    }

    public void addAtHead(int v) {
        ListNode node = new ListNode(v);
        if (size == 0) {
            head1 = node;
        } else {
            node.next = head1;
            head1 = node;

        }
        size++;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int race, i = 0, size = 0;

        ListNode trace = head;

        while (trace != null) {
            trace = trace.next;
            size++;
        }

        race = size - n;

        ListNode node = head;


        while (++i < race) {

            node = node.next;
        }
        if (n == size) {
            node = node.next != null ? node.next : null;
            head = node;
        } else {
            if (node != null) {
                node.next = node.next != null ? node.next.next : null;
            }
        }
        return head;
    }

    public void print(ListNode node) {
        ListNode temp = node;
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
        //   temp = null;
    }

    public static void main(String[] args) {
        RemoveNthNodeFromEndOfList list = new RemoveNthNodeFromEndOfList();


        list.addAtHead(5);
        list.addAtHead(4);
        list.addAtHead(3);
        list.addAtHead(2);
        list.addAtHead(1);
        list.print(list.removeNthFromEnd(list.head1, 2));
        // list.print(list.head1);
    }


}
