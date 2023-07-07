package leetcode.arrays;

import java.util.Arrays;

public class FindMaxConsecutiveOnes {
    public static void main(String[] args) {
        int[] nums = {1,1,0,1,1,1};

        var x = findMaxConsecutiveOnes(nums);
        System.out.println("Max = " + x);
    }

    /**
     * Testcase
     * Input: nums = [1,0,1,1,0,1]
     * Output: 2
     * Input: nums = [1,1,0,1,1,1]
     * Output: 3
     * @param nums
     * @return
     */
    public static int findMaxConsecutiveOnes(int[] nums) {
        // Hint: Initialise and declare a variable here to
        // keep track of how many 1's you've seen in a row.
        int j = 0;
        int[] sum = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            // Do something with element nums[i].
            if (nums[i] < 2) {
                if(nums[i] == 0)
                {
                    j++;
                }else {
                 sum[j] += nums[i];
                }
            }

        }
       // System.out.println(Arrays.stream(sum).max().getAsInt());
        return Arrays.stream(sum).max().getAsInt();
    }


  static   int sum(int[] sum) {
        int mix = 0;
        for (int i : sum) {

            if (i > mix) mix = i;
        }
        return mix;
    }
}
