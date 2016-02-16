package ArraysAndStrings;

/**
 * Created by vrajp on 2/10/2016.
 */
public class ContiguousSequence {
    public static void main(String a[]) {
        ContiguousSequence cs = new ContiguousSequence();

        int[] array = {-8, -3, -2, -4, -10};

        System.out.println(cs.contiguousMaxSum(array));
    }

    public int contiguousMaxSum(int[] array) {
        int maxSum = - Integer.MAX_VALUE;
        int sum = 0;

        for (int i = 0; i < array.length; i++) {

            int localSum = sum + array[i];

            // For Max Sum Output as 0 for all negative elements of Array
//            sum = localSum > 0 ? localSum : 0;

            // For Max Sum Output as negative for all negative elements of Array
            sum = array[i] > localSum ? array[i] : localSum;

            maxSum = maxSum < sum ? sum : maxSum;
        }
        return maxSum;
    }
}
