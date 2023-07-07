package leetcode.arrays;

public class ReplaceElements {
    public static void main(String[] args) {
        int[] arr = {17,18,5,4,6,1};
        replaceElements(arr);
        for(int i : arr)
        {
            System.out.println(i);
        }
    }
    public  static int[] replaceElements(int[] arr) {
        for(int i = 0; i < arr.length-1; i++)
        {
            int longest =  arr[i+1];

            for(int j = i+1; j < arr.length-1; j++)
            {

                if(arr[j+1] > longest) longest = arr[j+1];
            }
            arr[i] = longest;
        }
        arr[arr.length - 1] = -1;
        return arr;
    }
}
