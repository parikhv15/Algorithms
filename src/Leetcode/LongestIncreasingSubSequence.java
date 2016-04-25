package Leetcode;

/**
 * Created by vrajp on 4/23/2016.
 */
public class LongestIncreasingSubSequence {

    public static void main(String a[]) {
        LongestIncreasingSubSequence lis = new LongestIncreasingSubSequence();

        int nums[] = {10,9,2,5,3,4};

        System.out.println(lis.longestIncreasingSubSequence(nums));
    }

    public int longestIncreasingSubSequence(int[] nums) {
        int length = 0;

        int sArray[] = new int[nums.length];
        int pre[] = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            pre[i] = -1;
        }

        for (int i = 1 ; i < nums.length ; i++) {
            if (nums[i] > nums[sArray[length]]) {
                length++;
                sArray[length] = i;
                pre[i] = sArray[length-1];
            } else {
                int j = binarySearch(nums, sArray, nums[i], length);

                sArray[j] = i;

                if (j != 0) {
                    pre[i] = sArray[j-1];
                }
            }
        }

        printLIS(nums, pre, sArray, length);

        return length+1;
    }

    public void printLIS(int[] nums, int[] pre, int[] sArray, int length) {
        int pos = sArray[length];

        while (pos != -1) {
            System.out.print(nums[pos] + " ");
            pos = pre[pos];
        }
        System.out.println();
    }

    public int binarySearch(int[] nums, int[] arr, int num, int length) {
        int low = 0;
        int high = length;

        while (low < high) {
            int mid = (low + high) / 2;

            if (nums[arr[mid]] < num)
                low = mid + 1;
            else if (nums[arr[mid]] > num)
                high = mid;
            else
                return mid;
        }

        return low;
    }
}
