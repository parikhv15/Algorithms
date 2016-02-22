package Leetcode;

/**
 * Created by vrajp on 2/21/2016.
 */
public class PerfectSquareSum {
    public static void main (String a[]) {
        PerfectSquareSum pss = new PerfectSquareSum();

        System.out.println(pss.getMinPerfectSquareSum(12, 0));
        System.out.println(pss.getMinPerfectSquareSumDP(12));
    }

    public int getMinPerfectSquareSum(int n, int x) {
        int min = Integer.MAX_VALUE;
        int count = Integer.MAX_VALUE;

        if (n < 0)
            return Integer.MAX_VALUE;

        if (n == 0)
            return x;

        for (int i = n; i > 0; i--) {
            int sqrt = (int) Math.sqrt(i);

            if (i == sqrt * sqrt)
                count = getMinPerfectSquareSum(n - i, x+1);

            if (min > count)
                min = count;
        }

        return min;
    }

    public int getMinPerfectSquareSumDP(int n) {
        int[] count = new int[n+1];
;

        for (int i = 1; i <= n; i++) {
            int sqrt = (int) Math.sqrt(i);

            if (sqrt == i*i)
                count[i] = 1;
            else {
                int min = Integer.MAX_VALUE;

                for (int j = 1 ; j <= sqrt ; j++) {
                    min = Math.min(min, count[i-j*j]+1);
                }
                count[i] = min;
            }
        }
        return count[n];
    }
}
