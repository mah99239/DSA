package Data_structure.LinkedList

class SinglyLinkedListK {
    var head: ListNode? = null
    var tail: ListNode? = null
    var size = 0

    fun size(): Int = size

    fun isEmpty(): Boolean = size == 0

    fun first(): Int? = if (isEmpty()) -1 else head?.value

    fun last(): Int? = if (isEmpty()) -1 else tail?.value

    fun addFirst(value: Int) {
        head = ListNode(value, head)
        if (size == 0) tail = head
        size++
    }

    fun addLast(value: Int) {
        val newest: ListNode = ListNode(value, null)
        if (isEmpty()) {
            head = newest
        } else {
            tail?.next = newest
        }
        tail = newest
        size++
    }
    fun removeFirst():Int?{
        if(isEmpty()) return -1
        val temp = head
        head = head?.next
        size--

        if(size == 0)
        {
            tail = null
        }
        return temp?.value
    }
    fun removeLast(): Int?{
        if(isEmpty()) return -1
        if(size == 1) return removeFirst()

        var temp: ListNode? = head
        while(temp?.next?.next != null)
        {
            temp = temp.next
        }
        val itemRemove = temp?.next?.value
        temp?.next = null
        size--
        return itemRemove
    }
    fun print()
    {
        var node :ListNode? = head
        while(node != null)
        {
            println("value = " + node.value)
            node = node.next
        }

    }
    fun main(args: Array<String>) {

        val list = SinglyLinkedListK()
        list.addFirst(4)
        list.addFirst(3)
        list.addFirst(2)
        list.addFirst(1)
        list.print()
    }

    class ListNode(var value: Int?, var next: ListNode?)

}