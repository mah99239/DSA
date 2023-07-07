package leetcode.arrays;

public class RemoverDuplicatesELements {
    public static void main(String[] args) {
        int[] nums = {1,1,2};
        System.out.println(removeDuplicates(nums));
    }

    public static int removeDuplicates(int[] nums) {
        int k = nums.length;
        for(int i = 1; i < k; i++)
        {
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
    }
