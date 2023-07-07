package leetcode.list;

public class ReverseLinkedList {
    static  class ListNode{
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int val)
        {
            this.val = val;
        }
        ListNode(int val, ListNode next)
        {
            this.val = val;
            this.next = next;
        }
    }
    ListNode head;

    public ReverseLinkedList()
    {
        head = null;
    }

    public ListNode reverseList(ListNode head) {
        ListNode reverseNode = null;
        while (head != null)
        {
            head = head.next;
            reverseNode = new ListNode(head.val, reverseNode);
        }
        head = reverseNode;
        return head;
    }




    }
