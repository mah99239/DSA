package Data_structure.ArrayList;

import java.util.Arrays;

public class MyArrayList {
    private static final int CAPACITY_DEFAULT = 16;
    private int[] arr;
    private int capacity;
    int size;

    public MyArrayList() {
        this(CAPACITY_DEFAULT);
    }

    public MyArrayList(int capacity) {
        this.capacity = capacity;

        arr = new int[capacity];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return arr.length < 0;
    }


    public int get(int index) {
        if (isEmpty() || index >= size()) return -1;
        else return arr[index];
    }

    public void push(int item) {
        if (capacity == size()) {
            capacity = 2 * capacity;
            resize(capacity);
        }

        arr[size++] = item;

    }

    public void insert(int i, int item) {
        copyForward(i);
        arr[i] = item;
    }

    public void copyForward(int i) {
        // arr = Arrays.copyOf(arr, capacity + 1);
        resize(capacity + 1);
        for (int j = size; j >= i; j--) {
            arr[j] = arr[j - 1];
        }

    }

    public void copyBackward(int i) {
        for (int j = i; j < size; j++) {
            arr[j] = arr[j + 1];
        }
    }

    public int pop() {
        if (isEmpty()) return -1;
        else {
            int remove = arr[size];
            size--;
            if (size <= capacity / 4)
            {
                capacity = capacity / 4;
                resize(capacity);
            }
            return remove;
        }
    }


    public void delete(int index) {
        if (isEmpty() || size == 0) return;
        copyBackward(index);

        if (size <= capacity / 4)
        {
            capacity = capacity / 4;
            resize(capacity);
        }
    }

    public void remove(int item) {

        if (find(item) != -1) {
            int i = find(item);
            copyBackward(i);
        }

    }

    public int find(int item) {
        for (int i = 0; i < size; i++) {
            if (arr[i] == item) return i;
        }
        return -1;
    }

    /**
     * resize(new_capacity) // private function
     * TODO: when you reach capacity, resize to double the size
     * Complete: when popping an item, if size is 1/4 of capacity, resize to half
     *
     * @param newCapacity
     */
    private void resize(int newCapacity) {

        arr = Arrays.copyOf(arr, newCapacity);
    }

    public void print() {
        for (int i : arr) System.out.println(i);
    }

    public static void main(String[] args) {
        MyArrayList arr = new MyArrayList(4);
        arr.push(1);
        arr.push(2);
        arr.push(3);
        arr.push(4);
        arr.push(4);
        arr.push(4);
        arr.push(4);
        arr.push(4);
        arr.push(4);
        arr.push(4);

        arr.delete(0);
        arr.delete(1);
        arr.delete(0);
        arr.delete(0);
        arr.delete(0);
        arr.delete(0);
        arr.delete(0);
        arr.delete(0);
        arr.delete(0);
        arr.delete(0);

        System.out.println("size =" + arr.size);

        arr.print();
    }

}
