package leetcode.list;

public class RandomList {

    class Node {
        int val;
        Node next;
        Node random;
        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head)
    {
        Node headCopies = null;
        Node tailCopies = null;
        Node cur = head;
        while (cur != null)
        {
            if(headCopies == null)
            {
             headCopies = new Node(cur.val);

            }
            else{
                if(tailCopies == null)
                {
                    tailCopies = new Node(cur.val);
                    headCopies.next = tailCopies;

                }else{
                    Node newest = new Node(cur.val);

                    tailCopies.next = newest;
                    tailCopies = newest;
                }
            }
            cur = cur.next;
        }

        cur = head;
        Node curCopy = headCopies;
        while (cur != null && curCopy != null)
        {
            if(cur.random != null)
            {
                matchValue(cur.random, head, headCopies, curCopy);
            }
            curCopy = curCopy.next;
            cur = cur.next;

        }


        return headCopies;
    }

    private void matchValue(Node nodeRandom,Node headOriginal, Node headCopies, Node copies)
    {
        Node cur = headOriginal;
        Node match = null;
        while (cur != null  )
        {
            if(nodeRandom == cur.random)
            {
                match = cur.random;
            break;
            }
            cur = cur.next;
        }
        cur = headOriginal;
        while (headCopies != null)
        {
            System.out.println("nodeRandom = " + match + ", curRandom = " + cur.random);

            if(cur == match)
            {
                copies.random = headCopies;

            }
            cur = cur.next;
            headCopies = headCopies.next;

        }
    }

}
