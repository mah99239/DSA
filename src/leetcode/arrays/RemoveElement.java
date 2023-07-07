package leetcode.arrays;

public class RemoveElement {
    public static void main(String[] args) {
        //[0,1,2,2,3,0,4,2]
        //2
        int[] nums = new int[]{3,2,2,3};
        int x = 3;
        System.out.println(removeElementWithTwoPointer(nums, x));
    }

    public static int removeElement(int[] nums, int val) {
        int l = nums.length;
        for (int i = l - 1; i >= 0; i--) {
            if (nums[i] == val) {
                for (int j = i + 1; j < l ; j++) {
                    nums[j - 1] = nums[j];
                }
                l--;
            }
        }

        return l;
    }
    public static int removeElementWithTwoPointer(int[] nums, int val)
    {
        int  l = 0, r =  nums.length - 1;
        while(l < r+1)
        {
            if(nums[l] == val){
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r--] = temp;

            }else
            {
                l++;
            }

        }
        return r+1;
    }
}
