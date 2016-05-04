package Leetcode;

/**
 * Created by vrajp on 4/30/2016.
 */
public class MaximumGap {

    public static void main(String a[]) {
        MaximumGap mg = new MaximumGap();

        int nums[] = {100,3,2,1};
        System.out.println(mg.maximumGap(nums));
    }

    public int maximumGap(int[] nums) {
        if (nums.length < 2)
            return 0;

        int length = nums.length;

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0 ; i < nums.length ; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }

        int gap = (int) Math.ceil((double) (max - min) / (length - 1));

        if (gap == 0)
            gap++;

        int bucketMin[] = new int[length];
        int bucketMax[] = new int[length];

        for (int i = 0 ; i < nums.length ; i++) {
            int idx = (nums[i] - min) / gap;

            if (bucketMin[idx] == 0 || nums[i] < bucketMin[idx])
                bucketMin[idx] = nums[i];

            bucketMax[idx] = Math.max(bucketMax[idx], nums[i]);
        }

        int maxGap = 0;

        for (int i = 0 ; i < nums.length ; i++) {
            maxGap = Math.max(maxGap, bucketMin[i] - min);

            if (bucketMax[i] != 0)
                min = bucketMax[i];
        }

        return maxGap;
    }
}
