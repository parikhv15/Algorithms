package GeeksForGeeks.Arrays;

/**
 * Created by vrajp on 3/10/2016.
 */
public class MaxMinForm {

    public static void main(String a[]) {
        MaxMinForm mmf = new MaxMinForm();

        int[] nums = {1,2,3,4,5,6,7};

        mmf.rearrangeMaxMinForm(nums);

        mmf.printArray(nums);
    }

    public void printArray(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    public void rearrangeMaxMinForm (int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            System.out.println("Outside: " + i);
            while (num > 0) {
                int position;

                if (i >= nums.length / 2) {
                    position = 2*(nums.length - i - 1);
                } else {
                    position = 2*i + 1;
                }

                System.out.println(i + ":" + position);
                if (i == position) {
                    nums[i] = -num;
                    break;
                }
                // Swap num and nums[position]
                int temp = num;
                num = nums[position];
                nums[position] = temp;

                nums[position] = - nums[position];

                i = position;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = -nums[i];
        }
    }
}
