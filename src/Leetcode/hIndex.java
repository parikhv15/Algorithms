package Leetcode;

import java.util.Arrays;

/**
 * Created by vrajp on 3/7/2016.
 */
public class HIndex {

    public static void main(String a[]) {
        HIndex hi = new HIndex();

        int[] citations = {1,1,2,3,4,5,7};

        System.out.println(hi.hIndex(citations));
        Arrays.sort(citations);
        System.out.println(hi.hIndexSorted(citations, 0, citations.length-1));
    }

    public int hIndex(int[] citations) {
        int max = 0;

        for (int c : citations) {
            if  (max < c)
                max = c;
        }

        int count[] = new int[max+1];

        for (int c : citations) {
            count[c] += 1;
        }

        int hIndex = 0;
        for (int i = count.length-1 ; i >= 0 ; i--) {
            hIndex += count[i];

            if (hIndex >= i)
                return i;
        }
        return 0;
    }

    public int hIndexSorted(int[] citations, int start, int end) {
        if (start > end)
            return 0;

        int mid = (start + end) / 2;

        int h = citations.length - mid;

        if (citations[mid] >= h) {
            int temp = hIndexSorted(citations, start, mid-1);
            return temp == 0 ? h : temp;
        }
        else
            return hIndexSorted(citations, mid+1, end);
    }
}
