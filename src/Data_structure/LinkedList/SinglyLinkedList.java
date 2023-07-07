package Data_structure.LinkedList;


import java.util.ArrayList;
import java.util.Objects;

public class SinglyLinkedList<E> implements Cloneable{
    ListNode head;
    ListNode tail;
    int size = 0;

    class  ListNode<E> {
        private final E val;
      private   ListNode next;

        ListNode(E e, ListNode n) {
            this.val = e;
            this.next = n;

        }

    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E first() {

        return isEmpty() ? null :(E) head.val;
    }

    public E last() {
        if (isEmpty()) return null;

        return (E) tail.val;
    }

    /**
     * ALgorithm:
     * newNode = ListNode(vakue)
     * newNode.next = head
     * head = newNode
     * size = size + 1
     *
     * @param value of the node
     */
    public void addFirst(E value) {
        head = new ListNode<E>(value, head);
        if (size == 0) {
            tail = head;
        }
        System.out.println("tail = " + tail.val);
        size++;
    }

    /**
     * Algorithm: addLast(e)
     * newest = Node(e)
     * newest.next = null
     * tail.next = newest
     * tail = newest
     * size = size + 1
     *
     * @param value of the node
     */
    public void addLast(E value) {
        ListNode<E> newest = new ListNode(value, null);
        if (isEmpty()) head = newest;
        else
            tail.next = newest; // must be point next to the new node.
        tail = newest;
        size++;
    }

    /**
     * Algorithm removeFirst()
     * if head == null then
     * the list isEmpty
     * head =  head.next
     * size = size - 1
     */
    public E removeFirst() {
        if (isEmpty()) return null;

        ListNode node = head;
        head = head.next;
        size--;
        if(size == 0)
            tail = null;

        return (E)node.val;

    }

    public E removeLeast() {
        if(isEmpty()) return null;
        if(size == 1) return removeFirst();
        ListNode temp = head;
        while (temp.next != tail)
        {
            temp = temp.next;
        }
        E remove =(E) temp.next.val;
        temp.next = null;
        tail = temp;
        size--;
        return remove;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        SinglyLinkedList<E> other = (SinglyLinkedList<E>) super.clone();//safe cast

        if(size> 0)
        {
            other.head = new ListNode(head.val, null);
            ListNode<E> walk = head.next; // walk through the original list
            ListNode<E> otherTail = other.head; // remember most recently created node.
            while (walk != null)
            {
                ListNode<E> newest = new ListNode<>(walk.val, null);
                otherTail.next = newest; // link previous node
                otherTail = newest;
                walk = walk.next;
            }
        }
        return other;

    }

    @Override
    public int hashCode() {
        ArrayList<Integer> x = new ArrayList();

        int hash = 0;
        ListNode cur = head;
        while (cur != null)
        {
            hash = 31 * hash + Objects.hashCode(cur.val);
            cur = cur.next;
        }
        return hash;
    }

    public void print()
    {
        ListNode node = head;
        while (node != null)
        {
            System.out.println("value = " + node.val);
            node = node.next;
        }


    }
    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.addFirst(4);
        list.addFirst(3);
        list.addFirst(2);
        list.addFirst(1);
        list.addLast(5);
        list.addFirst(1);

        list.removeLeast();
        list.removeLeast();
        list.removeLeast();
        list.removeLeast();
        list.removeLeast();
        list.removeLeast();


        System.out.println(list.last());
      //  System.out.println(list.last());

      //  System.out.println(list.ad);
        list.print();
        SinglyLinkedListK list2 = new SinglyLinkedListK();
        list2.addFirst(4);
        list2.addFirst(3);
        list2.addFirst(2);
        list2.addFirst(1);
        list2.addFirst(1);
    //    list2.print();
    }

}
