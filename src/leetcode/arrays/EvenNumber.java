package leetcode.arrays;

public class EvenNumber {
    public static void main(String[] args) {
        int[] nums = {555,901,482,1771};
        System.out.println(findNumbers(nums));
    }

    /**
     * TestCase:
     * Input: nums = [555,901,482,1771]
     * Output: 1
     * Explanation:
     * Only 1771 contains an even number of digits.
     *
     *
     * Input: nums = [12,345,2,6,7896]
     * Output: 2
     * Explanation:
     * 12 contains 2 digits (even number of digits).
     * 345 contains 3 digits (odd number of digits).
     * 2 contains 1 digit (odd number of digits).
     * 6 contains 1 digit (odd number of digits).
     * 7896 contains 4 digits (even number of digits).
     * Therefore only 12 and 7896 contain an even number of digits.
     *
     * @return
     */
    public static int findNumbers(int[] nums) {
        if(nums.length == 0) return 0;
        int even = 0;
        for (int i : nums)
        {
            if(isEven(countDigit(i)))
            {
                even++;
            }
        }
        return even;

    }

    static boolean isEven(int num) {
        return num > 1 && num % 2 == 0;
    }
    static int countDigit(int num)
    {
        int count =0;
        while (num != 0)
        {
            num/= 10;
            ++count;
        }
        return count;
    }
}
