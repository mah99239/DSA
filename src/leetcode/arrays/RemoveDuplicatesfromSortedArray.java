package leetcode.arrays;

public class RemoveDuplicatesfromSortedArray {
    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicatesformTwoPointers(nums));
        //for(int i : nums) System.out.println(i);
    }

    public static int removeDuplicates(int[] nums) {
        int k = nums.length;
        for(int i = 1; i < k; i++)
        {
           // System.out.println(i);
            if(nums[i] == nums[i-1])
            {


                for(int j = i; j < k-1; j++)
                {
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;

                }
                k--;
                i--;

            }
        }
        return k;
    }

    public static int removeDuplicatesformTwoPointers(int[] nums)
    {
        if(nums == null)return 0;

        int writePointer = 1;
        for(int readPointer = 1; readPointer < nums.length; readPointer++)
        {
            if(nums[readPointer] != nums[readPointer - 1])
            {
                nums[writePointer] = nums[readPointer];

                writePointer++;
            }
        }
        for(int i = 0; i < writePointer; i++) System.out.println(nums[i]);
        return writePointer;
    }
}
