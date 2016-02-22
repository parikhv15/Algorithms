package Leetcode;

/**
 * Created by vrajp on 2/22/2016.
 */
public class CountPrimes {

    public static void main(String a[]) {
        CountPrimes cp = new CountPrimes();

        System.out.println(cp.countPrimes(499979));
    }

    public int countPrimes(int n) {
        boolean isNotPrime[] = new boolean[n];

        for (int i = 2 ; i*i < n ; i++) {
            if (isNotPrime[i])
                continue;

            for (int j = i*i ; j < n ; j+=i) {
                isNotPrime[j] = true;
            }
        }
        int count = 0;
        for (int i = 2 ; i < n ; i++) {
            if (!isNotPrime[i])
                count++;
        }
        return count;
    }
}
