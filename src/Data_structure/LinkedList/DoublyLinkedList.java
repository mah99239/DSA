package Data_structure.LinkedList;


public class DoublyLinkedList<E> implements Cloneable {
    class ListNode<E> {
        E val;
        ListNode<E> next;
        ListNode<E> prev;

        ListNode(E value, ListNode<E> p, ListNode<E> n) {
            val = value;
            next = n;
            prev = p;
        }
    }

    ListNode head;
    ListNode<E> tail;
    int size = 0;

    DoublyLinkedList() {
        System.out.println("clone2");
        head = new ListNode<>(null, null, null);
        tail = new ListNode<>(null, head, null);
        head.next = tail;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E first() {
        return isEmpty() ? null : (E) head.next.val;
    }

    public E last() {
        return isEmpty() ? null : tail.prev.val;
    }

    public void addFirst(E value) {
        addBetween(value, head, head.next);
    }

    public void addLast(E value) {
        addBetween(value, tail.prev, tail);
    }

    public E removeFirst() {
        return isEmpty() ? null : (E) remove(head.next);
    }

    public E removeLast() {
        return isEmpty() ? null : remove(tail.prev);
    }

    private void addBetween(E value, ListNode predecessor, ListNode successor) {
        ListNode newest = new ListNode<E>(value, predecessor, successor);
        predecessor.next = newest; // Head node is point to the new next node.
        successor.prev = newest;//Old next head node is point to the new next head.
        size++;
    }

    private E remove(ListNode<E> node) {
        ListNode<E> predecessor = node.prev;
        ListNode<E> successor = node.next;
        predecessor.next = successor;
        successor.prev = predecessor;
        size--;
        return node.val;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (getClass() != o.getClass()) return false;
        DoublyLinkedList other = (DoublyLinkedList) o; //Use parameterized type
        if (size != other.size) return false;
        ListNode walkA = head; // traverse the primary list
        ListNode walkB = other.head; //traverse the secondary list
        while (walkA != null) {
            if (walkA.val != walkB.val) return false;//mismatch
            walkA = walkA.next;
            walkB = walkB.next;
        }
        return true;
    }

    @Override
    protected DoublyLinkedList<E> clone() throws CloneNotSupportedException {
        DoublyLinkedList<E> other = (DoublyLinkedList<E>) super.clone();
        if (size > 0) {

            // remember most recently created node
            other.head = new ListNode<>(null, null, null);
            other.tail = new ListNode<>(null, other.head, null);
            other.head.next = other.tail;

            ListNode<E> walk = head.next; //walk through remainder of original list

            while (walk != null && walk != tail) {

                ListNode<E> newest = new ListNode<>(walk.val, other.tail.prev, other.tail);
                other.tail.prev.next = newest;
                other.tail.prev = newest;
                walk = walk.next;

            }
        }
        return other;
    }

    public void print() {
        ListNode cur = head.next; // first element
        while (cur != null && cur != tail) {
            System.out.println(cur.val);
            cur = cur.next;
        }
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        DoublyLinkedList<Integer> dl = new DoublyLinkedList<>();
        DoublyLinkedList<Integer> d2 = new DoublyLinkedList<>();

        dl.addFirst(4);
        dl.addFirst(3);
        dl.addFirst(2);
        dl.addFirst(1);
        dl.addLast(5);

        d2.addFirst(4);
        d2.addFirst(3);
        d2.addFirst(2);
        d2.addFirst(1);
        d2.addLast(5);

        //System.out.println(d2.equals(dl));
        DoublyLinkedList<Integer> dc = dl.clone();
        dl.print();
        dc.print();


    }

}
