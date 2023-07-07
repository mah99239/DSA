package leetcode.list;

import org.jetbrains.annotations.NotNull;

public class FlattenMultilevelDoublyLinkedList {
    class Node {
        int val;
        Node next;
        Node prev;
        Node child;

        Node(int val, Node p, Node n) {
            this.val = val;
            this.next = n;
            this.prev = p;
        }


    }

    Node head;
    Node tail;
    int size;

    FlattenMultilevelDoublyLinkedList() {
        head = new Node(-1, null, null);
        tail = new Node(-1, null, head);
        head.next = tail;

    }

    public Node flatten(Node head) {
        Node cur = head;

        while (cur != null) {

            Node parentChild = cur.child;
            cur.child = null;

            while (parentChild != null) {

                addBetween(parentChild.val, cur, cur.next);
                Node otherChild = parentChild.child;

                if (otherChild != null) {

                    Node levelChild = flatten(otherChild);

                    while (levelChild != null) {
                        cur = cur.next; // next node with parent this must be executed.

                        addBetween(levelChild.val, cur, cur.next);
                        levelChild = levelChild.next; // next node of child

                    }

                }
                parentChild = parentChild.next;
                cur = cur.next;

            }

            cur = cur.next;
        }

        return head;
    }

    @NotNull
    private Node addNode(Node cur, Node f, Node last) {
        if (f == null) {
            f = new Node(cur.val, null, null);

        } else {
            if (last == null) {
                last = new Node(cur.val, null, f);
                f.next = last;


            } else {
                System.out.println("current  =" + cur.val);
                Node newest = new Node(cur.val, null, last);
                last.next = newest;
                //addBetween(cur.val, last.prev, );
            }

        }
      /*  Node child = cur.child;
        if (child != null) {
            if (last == null) {
                last = new Node(cur.child.val, null, cur);
                f.next = last;
                child = child.next;

            }

            if (child != null) {
                System.out.println("in other child");
                last.next = addNode(child,f,last);
            }
        }*/

        return f;
    }

    public void addFirst(int val) {
        addBetween(val, head, head.next);

    }

    public void addAtFirstChild(int val, Node head) {

        Node newest = new Node(val, null, null);
        if (head.child == null) {
            head.child = newest;
        } else {
            Node cur = head.child;
            while (cur.next != null) {
                cur = cur.next;
            }
            Node newest2 = new Node(val, null, cur.child);

            //  newest.prev = head.child;
            cur.next = newest;
            // head.child = newest;
        }
    }

    public void addBetween(int val, Node p, Node n) {
        Node newest = new Node(val, p, n);
        p.next = newest;
        if (n != null)
            n.prev = newest;
    }

    void print(Node node) {
        Node cur = node;
        while (cur != null) {
            System.out.println(cur.val);
            cur = cur.next;
        }
    }

    public static void main(String[] args) {
        FlattenMultilevelDoublyLinkedList f = new FlattenMultilevelDoublyLinkedList();
        f.addFirst(2);
        f.addFirst(12);
        f.addAtFirstChild(6, f.head);
        f.addAtFirstChild(5, f.head);
        f.addAtFirstChild(4, f.head);
        f.addAtFirstChild(3, f.head.child);
        f.addAtFirstChild(2, f.head.child);
        f.addAtFirstChild(1, f.head.child);
        // f.print(f.head.child.child);

        f.addFirst(1);
        f.addAtFirstChild(5, f.head);
        f.addAtFirstChild(35, f.head);
        f.addAtFirstChild(35, f.head);
        f.addAtFirstChild(2322, f.head.child);

        f.flatten(f.head.next);
        // f.print(f.head.next);
        // f.flatten();
    }
}
