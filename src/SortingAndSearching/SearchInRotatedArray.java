package SortingAndSearching;

/**
 * Created by vrajp on 5/7/2016.
 */
public class SearchInRotatedArray {

    public static void main(String[] a) {
        SearchInRotatedArray sisa = new SearchInRotatedArray();

        int[] nums = {5,1,2,3,4};
        int num = 3;

        System.out.println(sisa.binarySearchRotated(nums, num));
    }

    public int binarySearchRotated(int nums[], int num) {
        int pivot = findPivot(nums, 0, nums.length-1);

        if (pivot == -1 || pivot == 0)
            return search(nums, 0, nums.length - 1, num);

        if (nums[0] <= num)
            return search(nums, 0, pivot, num);

        return search(nums, pivot + 1, nums.length - 1, num);
    }

    public int findPivot(int[] nums, int start, int end) {
        if (start > end)
            return -1;

        int mid = ( start + end ) / 2;

        if (mid < end && nums[mid] > nums[mid+1])
            return mid+1;

        if (mid > start && nums[mid] < nums[mid-1])
            return mid;

        if (nums[mid] > nums[end])
            return findPivot(nums, mid+1, end);

        return findPivot(nums, start, mid);
    }

    public int search(int[] nums, int start, int end, int num) {
        if (start > end)
            return -1;

        int mid = (start + end) / 2;

        if (nums[mid] == num)
            return mid;
        else if (nums[mid] > num)
            return search(nums, start, mid, num);
        else
            return search(nums, mid+1, end, num);
    }
}
