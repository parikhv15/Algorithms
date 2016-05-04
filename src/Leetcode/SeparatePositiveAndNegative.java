package Leetcode;

/**
 * Created by vrajp on 5/3/2016.
 */
public class SeparatePositiveAndNegative {

    public static void main (String a[]) {
        SeparatePositiveAndNegative span = new SeparatePositiveAndNegative();

        int[] arr = {-3, 2, 4, -7};

//        span.dutchNationalFlag(arr); // O(n^2)
//        span.divide(arr, 0, arr.length - 1); // O(nlogn)
        span.separate(arr); // O(n)

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public void separate (int[] nums) {
        int max = Integer.MIN_VALUE, numOfNeg = 0;

        // Count Max and number of negative
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max)
                max = nums[i];

            if (nums[i] < 0)
                numOfNeg++;
        }

        // Bring negative to front and encode positive
        int i = 0, j = 1;
        while (true) {
            // First positive
            while (i <= numOfNeg && nums[i] < 0)
                i++;

            // First Negative
            while (j < nums.length && nums[j] >= 0)
                j++;

            if (i > numOfNeg || j >= nums.length)
                break;

            nums[i] += (i+1) * max;
            swap(nums, i, j);
        }

        // Decode positive numbers
        for (i = numOfNeg ; i < nums.length ; i++) {
            int div = nums[i] / max;

            if (div > 0 && nums[i] != max) {
                nums[i] %= max;
                swap(nums, i, numOfNeg+div-2);
            }
        }
    }

    public void dutchNationalFlag (int[] nums) {
        int pos = 0;

        for (int i = 0 ; i < nums.length ; i++) {
            if (nums[i] <= 0) {
                int temp = nums[i];
                for (int j = i ; j > pos ; j--) {
                    nums[j] = nums[j-1];
                }
                nums[pos++] = temp;
            }
        }
    }

    public void divide(int[] nums, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            divide(nums, start, mid);
            divide(nums, mid + 1, end);
            combine(nums, start, mid, end);
        }
    }

    public void combine(int[] nums, int start, int mid, int end) {
        int i = start;
        int j = mid + 1;

        while (i <= mid && nums[i] < 0)
            i++;

        while (j <= end && nums[j] < 0)
            j++;

        reverse(nums, i, mid);
        reverse(nums, mid + 1, j-1);
        reverse(nums, i, j-1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start++, end--);
        }
    }

    public void swap(int[] nums, int i ,int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
