package leetcode.list;

public class AddTwoNumbers {
    ListNode head;
    ListNode tail;

    class ListNode {
        ListNode next;
        int val;

        ListNode(int v) {
            val = v;
        }

        ListNode(int v, ListNode n) {
            val = v;
            next = n;
        }

    }

    public void addAtHead(int v) {
        head = new ListNode(v, head);
        if (head.next == null) {
            tail = head;
        }

    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sumhead = null;
        ListNode sumTail = null;
        int temp = 0;
        while (l1 != null || l2 != null) {
            int value1 = l1 != null ? l1.val : 0;
            int value2 = l2 != null ? l2.val : 0;

            int sum = value1 + value2 + temp;
            temp = 0;

            if (sum > 9) {
                int x = sum > 10 ? sum - 10 : 0;
                ListNode newest = new ListNode(x, null);
                if (sumhead == null) {
                    sumhead = newest;
                    sumTail = sumhead;

                }
                else {
                    sumTail.next = newest;
                    sumTail = newest;
                }
                temp = 1;
            } else {
                ListNode newest = new ListNode(sum, null);
                if (sumhead == null) {
                    sumhead = newest;
                    sumTail = sumhead;

                }
                else {
                    sumTail.next = newest;
                    sumTail = newest;
                }
            }

            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;

        }
        if(temp == 1){
            ListNode newest = new ListNode(temp, null);
            sumTail.next = newest;
            sumTail = newest;
        }


        return sumhead;
    }

    public void addAtLast(int v, ListNode t) {
        ListNode newest = new ListNode(v, null);
        //  if (head == null) head = newest;
        // else
        if (t == null) {
            t = newest;

        } else {

            t.next = newest;

            t = newest;
        }
    }

    public void print(ListNode node) {
        ListNode cur = node;
        while (cur != null) {
            System.out.println(cur.val);
            cur = cur.next;
        }
    }

    public static void main(String[] args) {
        AddTwoNumbers sum = new AddTwoNumbers();
        AddTwoNumbers sum2 = new AddTwoNumbers();
        sum.addAtHead(9);
        sum.addAtHead(9);
        sum.addAtHead(9);
        sum.addAtHead(9);
        sum.addAtHead(9);
        sum.addAtHead(9);
        sum.addAtHead(9);


        sum2.addAtHead(9);
        sum2.addAtHead(9);
        sum2.addAtHead(9);
        sum2.addAtHead(9);

        sum.addTwoNumbers(sum.head, sum2.head);
      //  sum.print(sum.addTwoNumbers(sum.head, sum2.head));


    }
}
