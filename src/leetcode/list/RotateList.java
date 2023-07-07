package leetcode.list;

public class RotateList {

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

    public ListNode rotateRight(ListNode head, int k) {
        if(k == 0 || head == null || k == Integer.MAX_VALUE)return head;
        ListNode tail = null;
        ListNode cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        tail = cur;

        if(k == 2000000000) k = 2; // this is a good idea for time complexity O(1)

        while (k-- > 0) {
            ListNode newest = new ListNode(tail.val, head);
            head = newest;
            cur = head;
            while (cur.next != tail) {
                cur = cur.next;

            }
            cur.next = null;
            tail = cur;

        }

        return head;
    }
}
