package leetcode.arrays;

import java.util.Arrays;

public class SquaresOfSortedArray {
    public static void main(String[] args) {
        int[] nums = {-5,-3,-2,-1};

        sortedSquares2(nums);
    }

    public static int[] sortedSquares(int[] nums) {
        int[] squareNums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            squareNums[i] = nums[i] * nums[i];
        }
        return Arrays.stream(squareNums).sorted().toArray();
    }

    public static int[] sortedSquares2(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
                nums[i] = nums[i] * nums[i];
        }

        int l = 0 ;
        while (l < nums.length-1)
        {
            System.out.print(1);
            for(int j = l+1; j < nums.length; j++)
            {
                if(nums[l] > nums[j])
                {
                    int temp = nums[l];
                    nums[l] = nums[j];
                    nums[j] = temp;}
            }

    l++;


        }
        return nums;
    }
}
