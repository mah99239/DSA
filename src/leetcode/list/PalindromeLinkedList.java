package leetcode.list;

public class PalindromeLinkedList {
    class ListNode{
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
    int size;

    public void addHead(int val)
    {
        head = new ListNode(val, head);
        size++;
    }

    public void print(ListNode h)
    {
        while (h != null)
        {
            System.out.println(h.val);
            h = h.next;
        }
    }

    public boolean isPalindrome(ListNode head)//O(N) time
    {
        //https://www.interviewbit.com/blog/palindrome-number/
        ListNode cur = head, reveseNode = null;

        while(cur != null)//n
        {
            reveseNode = new ListNode(cur.val, reveseNode);
            cur = cur.next;
        }
        cur = head;
        while (cur != null & reveseNode != null)//n
        {
            if(cur.val != reveseNode.val)return false;
            cur = cur.next;
            reveseNode = reveseNode.next;
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromeLinkedList pll = new PalindromeLinkedList();

        pll.addHead(1);
        pll.addHead(2);
        pll.addHead(1);
        System.out.println( pll.isPalindrome(pll.head));
    }
}
