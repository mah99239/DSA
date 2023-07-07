package leetcode.list;

public class RemoveLinkedListElements {
    ListNode head;
    int size;

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

    public void addHead(int val) {
        head = new ListNode(val, head);
        size++;
    }

    public void print(ListNode h) {
        ListNode cur = h;
        while (cur != null) {
            System.out.println(cur.val);
            cur = cur.next;
        }
    }

    public ListNode removeElements(ListNode head, int val) {
        ListNode nodes = null;
        while (head != null) {

            if (head.val != val) {
                ListNode newest = new ListNode(head.val, null);

                if (nodes == null) {
                    nodes = newest;
                } else {
                    ListNode cur = nodes;
                    while(cur.next != null)
                    {
                        cur = cur.next;
                    }
                    cur.next = newest;
                }
            }

            head = head.next;

        }

        head = nodes;
        return head;
    }

    public static void main(String[] args) {
        RemoveLinkedListElements rl = new RemoveLinkedListElements();
        rl.addHead(5);
        rl.addHead(4);
        rl.addHead(3);
        rl.addHead(2);
        rl.addHead(1);
        rl.print(rl.removeElements(rl.head, 3));
    }
}
