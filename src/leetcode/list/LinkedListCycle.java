package leetcode.list;

public class LinkedListCycle {
    ListNode head;
    int size;

    public LinkedListCycle() {
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


    int get(int index) {
        ListNode temp = head;
        if(index >= size || size < 0) return -1;
        for(int i = 0; i < size; i++)
        {
            temp = temp.next;
        }
        return temp.val;
    }

    public boolean hasCycle(ListNode node) {
        ListNode slow = head;
        ListNode fast = head;
        while (slow != null && fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) return true;
        }
        return false;
    }
}
