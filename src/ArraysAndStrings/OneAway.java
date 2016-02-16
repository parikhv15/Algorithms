package ArraysAndStrings;

/**
 * Created by vrajp on 2/7/2016.
 */
public class OneAway {
    public static void main(String a[]) {
        OneAway oa = new OneAway();

        System.out.println(oa.isOneAway("vra", "vraj"));
    }

    public boolean isOneAway(String s1, String s2) {
        if (Math.abs(s1.length() - s2.length()) > 1)
            return false;

        if (s1.length() > s2.length()) {
            String temp = s1;
            s1 = s2;
            s2 = temp;
        }

        int i = 0, j = 0;

        while (i < s1.length() && j < s2.length()) {
            boolean diff = false;

            if (s1.charAt(i) != s2.charAt(j)) {
                if (diff)
                    return false;

                diff = true;

                if (s1.length() == s2.length())
                    i++;
            }
            else
                i++;

            j++;

        }

        return true;
    }
}
