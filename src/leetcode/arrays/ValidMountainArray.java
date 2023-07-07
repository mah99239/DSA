package leetcode.arrays;

public class ValidMountainArray {

    public static void main(String[] args) {

        int[] nums = {1,3,2};
        System.out.println(validMountainArray(nums));
    }

    public static boolean validMountainArray(int[] arr) {
        int i = 0 , l = arr.length;
                    while (i+1 < l && arr[i] < arr[i + 1])
                    {
                        i++;
                    }

                    if(i == 0 || i == l - 1)return  false;

                    while(i+1 < l && arr[i] > arr[i+1])
                    {
                        i++;
                    }


            return (i == l - 1);
    }
}
