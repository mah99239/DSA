package leetcode.arrays;

public class DobleExist {

    public static void main(String[] args) {
        int []n = {7,1,14,11};
        System.out.println(checkIfExist(n));
    }
    public static boolean checkIfExist(int[] arr) {
        for (int i = 0; i < arr.length; i++)
        {
            for(int j = 0; j < arr.length; j++)
            {
                if(i == j) continue;
                if(arr[i] == 2 * arr[j])
                {
                    return true;
                }
            }

        }
        return false;
    }
}
