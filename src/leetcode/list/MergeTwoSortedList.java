package leetcode.list;

public class MergeTwoSortedList {
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

    ListNode head;
    int size;

    public void addFirst(int value) {
        head = new ListNode(value, head);
        size++;
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode sorted = null;
        ListNode lastNode = null;
        int i = 0;
        while (list1 != null || list2 != null) {
            int temp1 = list1 != null ? list1.val : Integer.MAX_VALUE;
            int temp2 = list2 != null ? list2.val : Integer.MAX_VALUE;

            if ( temp1 < temp2) {
                ListNode newest = new ListNode(list1.val, null);
                if (sorted == null) {
                    sorted = newest;
                    lastNode = sorted;
                } else {
                    lastNode.next = newest;
                }
                lastNode = newest;
                list1 = list1.next != null ? list1.next : null ;


            } else {
                ListNode newest = new ListNode(list2.val, null);
                if (sorted == null) {
                    sorted = newest;
                    lastNode = sorted;
                } else {
                    lastNode.next = newest;
                }
                lastNode = newest;

                list2 = list2.next != null ? list2.next : null;

            }

        }

        return sorted;
    }

    public void print(ListNode node) {
        ListNode cur = node;
        while (cur != null) {
            System.out.println(cur.val);
            cur = cur.next;
        }

    }

    public static void main(String[] args) {
        MergeTwoSortedList ms1 = new MergeTwoSortedList();
        MergeTwoSortedList ms2 = new MergeTwoSortedList();

        ms1.addFirst(4);
        ms1.addFirst(2);
        ms1.addFirst(1);

        ms2.addFirst(4);
        ms2.addFirst(3);
        ms2.addFirst(1);

       ms2.print( ms2.mergeTwoLists(ms1.head, ms2.head));
    }


}
