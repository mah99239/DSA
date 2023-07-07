package leetcode.arrays;

import java.util.ArrayList;
import java.util.List;

public class FindDisappraredNumbers {

    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        //  findDisappeardNumbers(nums);
        findDisappeardNumbers(nums).forEach(integer ->
                System.out.println(integer.intValue()));
        //  int c = 10 ^ 5;
        // System.out.println(c);
    }

    //Bad solution
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        int constraint = 100000;
        if (n >= constraint || nums[n - 1] >= constraint) return null;

        List<Integer> disappered = new ArrayList<>();

        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                //   System.out.println(i);
                if (nums[i] < nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }

            }

        }

        // if(n >= constraint || nums[nums.length-1]  >= constraint ) return  null;


        int count = 1;
        for (int i = 0; i < n; i++) {
            if (nums[i] == count - 1) continue;

            if (nums[i] == count) count++;
            else if (nums[i--] > count) disappered.add(count++);

        }

        while (count <= nums.length) {
            disappered.add(count++);

        }

        return disappered;
    }


    /**
     * pseudocode:
     * find 1 to n exist in array or not
     * if not exist add item not exist in list
     * <p>
     * find count
     *
     * @param nums Give n array nums of n integers where nums[i] is in range [1 , n],
     * @return an array of all the integers in the range [1,n] that do not appear in nums.
     */
    public static List<Integer> findDisappeardNumbers(int[] nums) {
        List<Integer> disappered = new ArrayList<>();
       /* int mixN = 100000;
        if(nums.length > mixN) return null;

        for (int i = nums.length - 1; i >= 0; i--) {
            if(nums[i] > mixN) return null;

            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] < nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }

            }

        }

        int writePointer = 1;
        for (int readPointer = 1; readPointer < nums.length; readPointer++) {
            if (nums[readPointer] != nums[readPointer - 1]) {
                nums[writePointer] = nums[readPointer];

                writePointer++;
            }
        }*/

        for(int i=0;i<nums.length;i++)
        {
            if(nums[i] != i+1 && nums[i] != nums[nums[i] - 1])
            {
                //swap
                int temp =  nums[i];
                nums[i] = nums[temp-1];
                nums[temp-1] = temp;
                // to check the current ith pos'n again so that the correct value is here
                i--;
            }
        }
        for (int i : nums) System.out.println(i);
        for(int i =0;i<nums.length; i++)
        {
            if(nums[i]!=i+1)
            {
                disappered.add(i+1);
            }
        }


        return disappered;
    }
}
