package GeeksForGeeks.Arrays;

/**
 * Created by vrajp on 4/1/2016.
 */
public class MaxSumIncreasingSubSeq {

    public static void main(String a[]) {
        MaxSumIncreasingSubSeq msis = new MaxSumIncreasingSubSeq();

        int arr[] = {10, 5, 4, 3};

        System.out.println(msis.findMaxSum(arr, -1, 0));
    }

    public int findMaxSum(int[] nums, int index, int sum) {
        if (index >= nums.length)
            return sum;

        int max = Integer.MIN_VALUE;

        for (int i = index + 1 ; i < nums.length; i++) {
            if (sum == 0 || nums[i] > nums[index]) {
                max = Math.max(max, findMaxSum(nums, i, sum + nums[i]));
            }

            if (sum == 0 && index == -1)
                max = Math.max(max, findMaxSum(nums, i, sum));
        }

        return max == Integer.MIN_VALUE ? sum : max;
    }
}
