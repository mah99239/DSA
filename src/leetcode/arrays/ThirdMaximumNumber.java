package leetcode.arrays;

public class ThirdMaximumNumber {
    public static void main(String[] args) {
        int[]nums = {1,2};
        System.out.println(thirdMax(nums));
    }
    public static int thirdMax(int[] nums) {

    int countMax = 1, r = nums.length-2;

    for(int i = 0; i < nums.length; i++)
    {
        for(int j = i + 1; j < nums.length; j++)
        {
            if(nums[i] > nums[j])
            {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
    }
    int max = nums[nums.length-1];
        while (countMax < 3 && r >= 0)
    {
       if(nums[r] != nums[r + 1])
        {
            countMax++;
        }
        if(countMax == 3) max = nums[r];

        r--;
    }

    return max;
    }
}
