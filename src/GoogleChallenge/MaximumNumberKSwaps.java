package GoogleChallenge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Created by vrajp on 4/9/2016.
 */
public class MaximumNumberKSwaps {

    public static void main(String a[]) {
        MaximumNumberKSwaps ms = new MaximumNumberKSwaps();

        int num = 3126664;

        String number = Integer.toString(num);

        int numArr[] = new int[number.length()];

        for (int i = 0; i < numArr.length; i++) {
            numArr[i] = number.charAt(i) - '0';
        }

        int ans[] = ms.getMaxNumber(numArr, 2);

        System.out.println(ans);
    }

    public int[] getMaxNumber(int[] num, int k) {
        int n = 0, i = 0;

        while( i < num.length ) {
            MaxCountWrapper mc = getMaxOnRight(num, i+1);

            int tempLen = Math.min(mc.indexes.size(), k);

            PriorityQueue<Integer> pq = new PriorityQueue<>(tempLen, Collections.reverseOrder());
            for (int j = i; j < i + tempLen; j++) {
                pq.offer(num[j]);
                num[j] = mc.max;
                k--;
            }

            for (int j = 0; j < tempLen; j++) {
                num[mc.indexes.get(j)] = pq.poll();
            }

            i += tempLen;

            if (k == 0)
                break;
        }
        return num;
    }

    public MaxCountWrapper getMaxOnRight(int[] num, int i) {
        int max = Integer.MIN_VALUE;

        MaxCountWrapper mc = null;

        for (int j = i ; j < num.length ; j++) {
            if (max == num[i]) {
               mc.indexes.add(i);
            }

            if (max < num[j]) {
                max = num[j];
                mc = new MaxCountWrapper(max);
                mc.indexes.add(j);
            }
        }

        return mc;
    }
}

class MaxCountWrapper {
    int max;
    ArrayList<Integer> indexes;

    MaxCountWrapper (int max) {
        this.max = max;
        this.indexes = new ArrayList<>();
    }
}
