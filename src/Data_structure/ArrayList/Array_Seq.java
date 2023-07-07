package Data_structure.ArrayList;

public class Array_Seq {
      int size ;
     int[]array;
    Array_Seq()
    {
        array = new int[]{};
        size = array.length;
    }
    public Array_Seq(int []A)
    {
        array = A;
        System.out.println(A.length);
        size = array.length;
    }

    public  int length()  // O(1)
    {
        return array.length;
    }
    public  void iterater()   //O(n)
    {
        for(int i : array)
        {
            System.out.println(i);
        }
    }

    public  int getAt(int index)
    {
        return array[index];
    }
    public  void setAt(int index,int value)
    {
        array[index] = value;
    }

    public void copy_forward(int index, int n, int[]A, int j)
    {
        if (n >= 0) System.arraycopy(array, index + 0, A, j + 0, n);

    }
    public void copy_backward(int index, int n, int []A, int j)
    {
        if (n - 1 >= 0) System.arraycopy(array, index + 1, A, j + 1, n - 1);
    }

    public void inset_at(int i, int x)
    {
        var n = array.length;
        int[] A = new int[ n + 1];
        copy_forward(0, i, A, 0);
        A[i] = x;
        copy_forward(i, n - i, A, i + 1);
        new Array_Seq(A);

    }
    public int  delete_at(int i)
    {
        int n = array.length;
        var A = new int[n - 1];
        copy_forward(0, i, A, 0);
        int x = A[i];
        copy_forward(i + 1, n - i - 1, A, i);
        new Array_Seq(A);
        return x;
    }

    public void insert_first(int x) {
        inset_at(0, x);
    }
    public int delete_first()
    {
        return delete_at(0);
    }
    public void insert_last(int x)
    {
        inset_at(array.length ,x );
    }
    public int   delete_last()
    {
        return delete_at(array.length - 1);
    }

    public static void main(String[] args) {
        int []array = new int[]{11,12};
       var x= new Array_Seq();

       x.insert_first(1);
       x.insert_first(2);
       x.insert_first(3);
       x.insert_first(4);
       x.insert_first(5);
        x.iterater();
    }
}
