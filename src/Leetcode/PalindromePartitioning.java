package Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vrajp on 3/9/2016.
 */
public class PalindromePartitioning {

    public static void main(String a[]) {
        PalindromePartitioning pp = new PalindromePartitioning();

        String s = "efe";

        pp.generateAllPalindromeSubStrings(s);

        System.out.println(pp.partition(s));
    }

    public List<List<String>> partition(String s) {
        boolean[][] dp = generateAllPalindromeSubStrings(s);

        List<List<String>> combinations = new ArrayList<List<String>>();

        List<String> list = new ArrayList<String>();

        partitionUtil(combinations, list, s, 0, dp);

        return combinations;
    }

    public void partitionUtil(List<List<String>> combinations, List<String> list, String s, int start, boolean[][] dp) {
        if (start > s.length())
            return;

        if (start == s.length()) {
            combinations.add(new ArrayList<String>(list));
            return;
        }

        for (int i = 0 ; i < s.length() ; i++) {
            System.out.println(start + ":" + i + ":" + dp[start][i]);
            if (dp[start][i]) {
                list.add(s.substring(start, i+1));
                partitionUtil(combinations, list, s, i+1, dp);
                list.remove(list.size()-1);
            }
        }
    }

    public boolean[][] generateAllPalindromeSubStrings(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];

        // For Substring of length 1
        for (int i = 0 ; i < s.length() ; i++) {
            dp[i][i] = true;
        }

        // For Substring of length 2
        for (int i = 0 ; i < s.length() - 1 ; i++) {
            if (s.charAt(i) == s.charAt(i+1))
                dp[i][i+1] = true;
        }

        // For Substrings of Length > 2
        for (int len = 3 ; len <= s.length() ; len++) {
            for (int i = 0 ; i < s.length()-len+1 ; i++) {
                int j = i + len - 1;

                if (s.charAt(i) == s.charAt(j) && dp[i+1][j-1]) {
                    dp[i][j] = true;
                }
            }
        }

        return dp;
    }
}
