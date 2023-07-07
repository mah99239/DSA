package Data_structure.LinkedList

class CircularlyLinkedListK
{
    class ListNode(val value: Int?, var next: ListNode?)

    var tail: ListNode? = null
    var size: Int = 0
    
    fun size(): Int = size
    
    fun isEmpty(): Boolean = size == 0
    
    fun first(): Int? = if (isEmpty()) -1 else tail?.next?.value
    
    fun last(): Int? = if (isEmpty()) -1 else tail?.value
    
    fun rotate()
    {
        if (tail != null)
        {
            tail = tail!!.next
        }
    }
    
    fun addFirst(value: Int?)
    {
        if (size == 0)
        {
            tail = ListNode(value, null)
            tail?.next = tail
        }
        else
        {
            val node = ListNode(value, tail?.next)
            tail?.next = node
        }
        size++
    }
    
    fun addLast(value: Int?)
    {
        addFirst(value)
        tail = tail?.next
    }
    
    fun removeFirst(): Int?
    {
        if (isEmpty()) return -1
        
        val head = tail?.next
        if (head == tail) tail = null
        else tail?.next = head?.next
        size--
        return head?.value
        
    }
    
    fun removeLast(): Int?//O(n) time
    {
        if(isEmpty()) return -1
        
        if(size  == 1) return removeFirst()
        
        var temp = tail?.next
        while(temp?.next != tail)
        {
            temp = temp?.next
        }
        val itemRemove = tail?.value
        temp?.next = tail?.next
        tail = temp
        size--
        return itemRemove
        
    }
    
    fun print()
    {
        if(isEmpty()) return
        var node = tail?.next
        while (node != tail)
        {
            println("value = " + node?.value)
            node = node?.next
        }
        println("value = " + node?.value)
    }
    
}