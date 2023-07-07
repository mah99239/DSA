package leetcode.arrays;

public class MergeSortedArray {
    /**
     * TestCase:
     * Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
     * Output: [1,2,2,3,5,6]
     *
     * Input: nums1 = [1], m = 1, nums2 = [], n = 0
     * Output: [1]
     *
     * Input: nums1 = [0], m = 0, nums2 = [1], n = 1
     * Output: [1]
     * @param args
     */
    public static void main(String[] args) {
    int[] nums1 = new int[]{1,2,3,0,0,0};
    int[] nums2 = new int[]{2,4,5};
    int m = 3;
    int n = 3;
    MergeSortedArray x= new MergeSortedArray();
    x.merge(nums1, m, nums2, n);
    }

    public void merge(int[] nums1, int m, int[] nums2, int n)
    {
        int p1 = m - 1, p2 = n-1, i = m + n - 1;
        while(p2 >= 0)
        {
            if(p1 >= 0 && nums1[p1] > nums2[p2])
            {
                nums1[i--] = nums1[p1--];
            }
            else{
                nums1[i--] = nums2[p2--];
            }
        }

        for(int s : nums1)
        {
            System.out.println(s);
        }
    }
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        int[]arr = new int[m+n];
        int x = 0, z = 0, i = 0;
        if(nums2.length == -1) nums2[0] =0;
        while (i < m+n)
        {
            System.out.println("x = " + x + "z = " + z);
            if(nums1[x] <= nums2[z] & nums1[x] != 0 || nums2[z] == 0)
            {
                arr[i++] = nums1[x++];
            }else if(nums2[z] < nums1[x]  || nums1[x] == 0)
            {
                arr[i++] = nums2[z++];

            }
            if(i == m+n -1) nums1 = arr;
        }
        nums1 = arr;

        for(int s: nums1)
        {
            System.out.println(s);
        }


    }
}
