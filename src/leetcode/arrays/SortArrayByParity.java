package leetcode.arrays;

public class SortArrayByParity {
    public static void main(String[] args) {
        int[] nums = {3,1,2,4};
        sortArrayByParity(nums);
        for(int i : nums)
        {
            System.out.println(i);
        }
    }
    public static int[] sortArrayByParity(int[] nums) {
            int l = 0, r = nums.length-1;
            while(l < r)
            {
                if(nums[l] % 2 != 0)
                {
                    int temp = nums[l];
                    nums[l] = nums[r];
                    nums[r--] = temp;
                }
                else {
                    l++;
                }
            }
        return nums;
    }
}
