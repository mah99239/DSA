package leetcode.arrays;

public class DuplicateZeros {

    public static void main(String[] args) {
        int[] arr = new int[]{1,0,2,3,0,4,5,0};
        DuplicateZeros d = new DuplicateZeros();
        d.duplicateZeros(arr);
    }

    public void duplicateZeros(int[] arr) {
        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == 0) {

                insertZeroAt(arr, i);
                ++i;

            }
        }



    }

    void insertZeroAt(int[] array, int i) {

        int[] newArr = array;
        System.out.println("i =" + i );
        if (i == array.length - 1) {return;}

        if (array.length - 1 - i >= 0) System.arraycopy(array, i, newArr, i + 1, array.length - 1 - i);
        newArr[i+1] = 0;
        array = newArr;



    }
}
