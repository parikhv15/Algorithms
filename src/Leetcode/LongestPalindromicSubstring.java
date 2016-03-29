package Leetcode;

import ArraysAndStrings.StringCompression;

/**
 * Created by vrajp on 3/13/2016.
 */
public class LongestPalindromicSubstring {

    public static void main(String a[]) {
        LongestPalindromicSubstring lps = new LongestPalindromicSubstring();

        System.out.println(lps.lpsManacherAlgorithm("sslss"));
    }

    public String lpsManacherAlgorithm(String s) {
        String t = preprocessString(s);

        int[] lps = new int[t.length()];

        lps[0] = 0;

        int C = 0, R = 0;

        int maxIndex = 0, maxLength = Integer.MIN_VALUE;

        for (int i = 1; i < t.length(); i++) {

            int mirror = 2*C-i;

            lps[i] = R > i ? Math.min(R - i, lps[mirror]) : 0;

            while (i+lps[i]+1 < t.length() && i-lps[i]-1 >= 0 && t.charAt(i + lps[i] + 1) == t.charAt(i - lps[i] - 1))
                lps[i]++;

            if (i + lps[i] > R) {
                C = i;
                R = i + lps[i];
            }

            if (lps[i] > maxLength) {
                maxLength = lps[i];
                maxIndex = i;
            }
        }

        printArray(lps);
        int start = (maxIndex-maxLength)/2;

        return s.substring(start, start+maxLength);
    }

    public void printArray(int[] lps) {
        for (int i = 0; i < lps.length; i++) {
            System.out.print(lps[i] + " ");
        }
        System.out.println();
    }

    public String preprocessString(String s) {
        String s_new = "";

        for (int i = 0; i < s.length(); i++) {
            s_new += "#" + s.charAt(i);
        }

        s_new += "#";

        return s_new;
    }
}
