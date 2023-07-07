package leetcode.arrays;

public class HeightChecker {
    public static void main(String[] args) {
        int[] nums = {1, 1, 4, 2, 1, 3};
        HeightChecker h = new HeightChecker();
        System.out.println(h.heightChecker(nums));
    }

    public  int heightChecker(int[] heights) {
        int k = 0;
        int[] sort = new int[heights.length];
        System.arraycopy(heights, 0, sort, 0, heights.length);

        for (int i = 0; i < sort.length; i++) {

            for (int j = i + 1; j < sort.length; j++) {
                if (sort[i] > sort[j]) {
                    int temp = sort[i];
                    sort[i] = sort[j];
                    sort[j] = temp;
                }
            }
        }
        for (int i = 0; i < sort.length; i++) {
        if(heights[i] != sort[i])
        {
            k++;
        }
        }

        return k;
    }
}
