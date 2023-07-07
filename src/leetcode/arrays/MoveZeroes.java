package leetcode.arrays;

public class MoveZeroes {
    public static void main(String[] args) {
        int [] nums = {0};
        moveZeroes(nums);
        for(int i : nums) System.out.println(i);

    }
    public static void moveZeroes(int[] nums)
    {
    int l = 0, r = nums.length-1;
        while(l < r)
        {
            if(nums[l] == 0)
            {
                for(int j = l; j < r; j++)
                {
                nums[j] = nums[j+1];
                }
                nums[r--] = 0;
            }else {
                l++;

            }
        }
    }
}
