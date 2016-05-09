package Leetcode;

import utils.ds.Arrays;

/**
 * Created by vrajp on 5/8/2016.
 */
public class KthLargest {

    public static void main(String[] a) {
        KthLargest kl = new KthLargest();

        int[] nums = {-1, -1};
        System.out.println(kl.findKthLargest(nums, 2));
    }

    public int findKthLargest(int[] nums, int k) {
        return findKthLargestUtil(nums, nums.length - k + 1, 0, nums.length - 1);
    }

    public int findKthLargestUtil(int[] nums, int k, int start, int end) {
        if (k > 0 && k <= end - start + 1) {
            int pos = getPartition(nums, k, start, end);

            if (pos - start == k - 1)
                return nums[pos];

            if (pos - start > k - 1)
                return findKthLargestUtil(nums, k, start, pos - 1);

            return findKthLargestUtil(nums, k-pos+start-1, pos + 1, end);
        }

        return Integer.MAX_VALUE;
    }

    public int getPartition(int[] nums, int k, int start, int end) {
        int n = end - start + 1;

        int pivot = (int) (start + (Math.random() % n));
        Arrays.swap(nums, start, pivot);

        int i = start + 1;

        for (int j = i; j <= end; j++) {
            if (nums[j] <= nums[start]) {
                Arrays.swap(nums, i++, j);
            }
        }
        Arrays.swap(nums, i-1, start);

        return i-1;
    }
}
