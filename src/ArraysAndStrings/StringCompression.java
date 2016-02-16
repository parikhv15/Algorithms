package ArraysAndStrings;

/**
 * Created by vrajp on 2/7/2016.
 */
public class StringCompression {

    public static void main (String a[]) {
        StringCompression sc = new StringCompression();

        System.out.println(sc.compressString("aaabbcccc"));
    }

    public String compressString(String s) {

        String nS = "";

        int i = 0, j = 1;
        int length = 1;

        while (j <= s.length()) {

            while (j < s.length() && s.charAt(i) == s.charAt(j)) {
                j++;
                length++;
            }

            nS += s.charAt(i);
            nS += length;
            i = j++;
            length = 1;
        }
        return nS;
    }
}
