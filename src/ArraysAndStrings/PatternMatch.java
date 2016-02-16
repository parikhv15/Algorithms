package ArraysAndStrings;

/**
 * Created by vrajp on 2/9/2016.
 */
public class PatternMatch {

    public static void main (String a[]) {
         PatternMatch pm  = new PatternMatch();

        pm.substringMatchKMP("ababcababababdabacdababcabab", "ababcabab");
    }

    public void substringMatchKMP(String text, String pattern) {
        int lps[] = computeLPS(pattern);

        int m = pattern.length();
        int n = text.length();

        System.out.println("Longest Proper Prefix: ");
        printArray(lps);

        int i = 0, j = 0;

        while (i < n) {
            if (pattern.charAt(j) == text.charAt(i)) {
                i++;
                j++;
            }

            if (j == m) {
                System.out.println("Found Pattern at " + (i - j));
                j = lps[j-1];
            }
            else if (i < n && pattern.charAt(j) != text.charAt(i)) {
                if (j != 0)
                    j = lps[j-1];
                else
                    i++;
            }
        }
    }

    public int[] computeLPS(String pattern) {
        int m = pattern.length();

        int[] lps = new int[m];

        int len = 0, i = 1;

        lps[0] = 0;

        while (i < m) {
            if (pattern.charAt(i) == pattern.charAt(len))
                lps[i++] = ++len;
            else {
                if (len != 0) {
                    len = lps[len-1];
                }
                else {
                    lps[i++] = 0;
                }
            }

        }
        return lps;
    }

    public void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
