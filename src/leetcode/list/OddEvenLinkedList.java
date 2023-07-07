package leetcode.list;

public class OddEvenLinkedList {
    static class ListNode {
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

    public void addToHead(int val) {
        head = new ListNode(val, head);
        size++;
    }

    public void print(ListNode head) {
        ListNode cur = head;
        while (cur != null) {
            System.out.println(cur.val);
            cur = cur.next;
        }
    }

    public ListNode OddEvenList(ListNode head) {
        if(head == null) return null;
        ListNode cur = head;
        ListNode oddNodes = null;
        ListNode evenNodes = null;
        int i = 0;
        while (cur != null) {
            if (i++ % 2 == 0) {
                System.out.println("i =" + i);
                System.out.println("value = " + cur.val);
                //add even nodes;


                    ListNode newest = new ListNode(cur.val, null);

                    if (oddNodes == null) {
                        oddNodes = newest;
                    }else{
                        ListNode last = oddNodes;

                        while (last.next != null) {
                            last = last.next;
                        }
                        last.next = newest;
                    }


                // cur = tail;
            } else {
                ListNode newest = new ListNode(cur.val, null);
                if (evenNodes == null) {
                    evenNodes = newest;
                } else {
                    ListNode last = evenNodes;

                    while (last.next != null) {
                        last = last.next;
                    }
                    last.next = newest;
                }

            }
            cur = cur.next;
            //  head = head.next;
        }
         head = oddNodes;
        ListNode last = head;
        while (last.next != null)
        {
            last = last.next;
        }
        last.next = evenNodes;
        return head;
    }

    public static void main(String[] args) {
        OddEvenLinkedList ol = new OddEvenLinkedList();

        // ol.OddEvenList(ol.head);
        ol.print(ol.OddEvenList(ol.head));
    }
}
