package utils.ds;

/**
 * Created by vrajp on 3/17/2016.
 */
public class SegmentTree {

    private int[] segmentTree;
    private int[] nums;

    int size;

    public static  void main(String a[]) {
        int[] nums = {2,3,1,5,6};

        SegmentTree st = new SegmentTree(nums);

        st.update(2, 4);

        System.out.println(st.sumRange(1,3));
    }

    public SegmentTree(int nums[]) {
        this.nums = nums;
        this.size = nums.length;

        int height = (int) Math.ceil(Math.log(size) / Math.log(2));

        int n = 2 * (int) Math.pow(2, height) - 1;

        this.segmentTree = new int[n];

        constructSegmentTree(nums, 0, size - 1, 0);
    }

    private int constructSegmentTree(int[] nums, int start, int end, int index) {
        if (start == end)
            segmentTree[index] = nums[start];
        else {
            int mid = (start + end) / 2;

            segmentTree[index] = constructSegmentTree(nums, start, mid, 2*index+1) + constructSegmentTree(nums, mid + 1, end, 2*index+2);
        }

        return segmentTree[index];
    }

    public void update(int i, int value) {
        if (i <= 0 || i >= size)
            return;

        updateUtil(0, size - 1, i, 0, value - nums[i]);
    }

    private void updateUtil(int start, int end, int i, int index, int diff) {

        segmentTree[index] += diff;

        if (start != end) {
            int mid = (start + end) / 2;

            if (i <= mid)
                updateUtil(start, mid, i, 2 * index + 1, diff);
            else
                updateUtil(mid + 1, end, i, 2 * index + 2, diff);

        }
    }

    public int sumRange(int i, int j) {
        if (i < 0 || i > j || j >= size)
            return 0;

        return sumRangeutil(0, size - 1, i, j, 0);
    }

    private int sumRangeutil(int start, int end, int i, int j, int index) {
        if (start >= i && end <= j)
            return segmentTree[index];

        if (start > j || end < i)
            return 0;

        int mid = (start + end) / 2;

        return sumRangeutil(start, mid, i, j, 2 * index + 1) + sumRangeutil(mid+1, end, i, j, 2 * index + 2);
    }
}
