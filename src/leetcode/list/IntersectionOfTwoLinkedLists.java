package leetcode.list;

public class IntersectionOfTwoLinkedLists {
    ListNode head;
    int size;

    public IntersectionOfTwoLinkedLists() {
        head = null;
        size = 0;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public void addHead(int x) {
        ListNode newNode = new ListNode(x);
        if (size == 0) {
            head = newNode;

        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;

    }

    public void print() {
        ListNode temp = head;
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }

    public ListNode getIntersectionNode( ListNode headA, ListNode headB) {

        ListNode nodeA = headA;
        ListNode nodeB = headB;

        while (nodeA != nodeB)

        {
            nodeA = nodeA == null ? headB : nodeA.next;
            nodeB = nodeB == null ? headA : nodeB.next;

        }
    return nodeA;
    }

    public static void main(String[] args) {
        IntersectionOfTwoLinkedLists list1 = new IntersectionOfTwoLinkedLists();
        list1.addHead(5);
        list1.addHead(4);
        list1.addHead(8);
        list1.addHead(1);
        list1.addHead(4);
        IntersectionOfTwoLinkedLists list2 = new IntersectionOfTwoLinkedLists();
        list2.addHead(5);
        list2.addHead(4);
        list2.addHead(8);
        list2.addHead(1);
        list2.addHead(6);
        list2.addHead(5);


        System.out.println(list2.getIntersectionNode( list1.head, list2.head));
    }
}
