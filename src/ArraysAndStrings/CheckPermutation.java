package ArraysAndStrings;

/**
 * Created by vrajp on 2/7/2016.
 */
public class CheckPermutation {

    public static void main(String a[]) {
        CheckPermutation cp = new CheckPermutation();

        System.out.println(cp.isPermutation("goda", "dogs"));;
    }

    public boolean isPermutation(String s1, String s2) {

        if (s1.length() != s2.length())
            return false;

        int characters[] = new int[256];

        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();

        for (int i = 0; i < s1.length(); i++) {
            characters[s1.charAt(i) - 'a']++;
            characters[s2.charAt(i) - 'a']--;
        }

        for (int i = 0; i < characters.length; i++) {
            if (characters[i] != 0)
                return false;
        }
        return true;
    }
}
