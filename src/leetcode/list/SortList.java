package leetcode.list;

public class SortList {
    
     public class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }
    

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode cur = head;
        outer:
        while (cur != null) {
            ListNode first = cur, second = cur.next;
            while (second != null) {
                if (second.val < cur.val) {
                    System.out.println(1);
                    var newest = second.next;

                    second.next = head;


                    // cur = second;
                    head = second;
                    first.next = newest;

                    continue outer;


                }

                first = first.next;
                second = second.next;

            }


            cur = cur.next;

        }


        return head;
    }
}
