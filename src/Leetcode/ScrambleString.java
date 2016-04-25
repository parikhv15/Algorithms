package Leetcode;

import java.util.HashMap;

/**
 * Created by vrajp on 4/11/2016.
 */
public class ScrambleString {

    public static void main(String a[]) {
        ScrambleString ss = new ScrambleString();

        HashMap<Wrapper, Boolean> map = new HashMap<>();

        long startTime = System.currentTimeMillis();

        System.out.println(ss.isScrambleUtil("great", "reatg"));

        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println(elapsedTime);
    }

    public boolean isScramble(String s1, String s2, HashMap<Wrapper, Boolean> map) {
        if (s1.length() != s2.length() )
            return false;

        if (s1.equals(s2))
            return true;

        Wrapper w = new Wrapper(s1, s2);

        if (map.containsKey(w))
            return map.get(w);

        boolean result = false;

        for (int i = 1 ; i < s1.length() ; i++) {
            if (isScramble(s1.substring(0, i), s2.substring(0, i), map) && isScramble(s1.substring(i, s1.length()), s2.substring(i), map))
                result = true;

            if (isScramble(s1.substring(0, i), s2.substring(s2.length() - i), map) && isScramble(s1.substring(i), s2.substring(0, s2.length() - i), map))
                result = true;
        }

        map.put(new Wrapper(s1, s2), result);

        return result;
    }

    public boolean isScrambleUtil(String s1, String s2) {
        if (s1.length() != s2.length() )
            return false;

        if (s1.equals(s2))
            return true;


        if (!isAnagram(s1, s2))
            return false;


        for (int i = 1 ; i < s1.length() ; i++) {
            if (isScrambleUtil(s1.substring(0, i), s2.substring(0, i)) && isScrambleUtil(s1.substring(i, s1.length()), s2.substring(i)))
                return true;

            if (isScrambleUtil(s1.substring(0, i), s2.substring(s2.length() - i)) && isScrambleUtil(s1.substring(i), s2.substring(0, s2.length() - i)))
                return true;
        }

        return false;
    }

    public boolean isAnagram(String s1, String s2) {
        HashMap<Character, Integer> chars = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {
            int count = 1;
            char c1 = s1.charAt(i), c2 = s2.charAt(i);

            if (chars.containsKey(c1))
                count = chars.get(c1) + 1;

            chars.put(c1, count);

            count = -1;

            if (chars.containsKey(c2))
                count = chars.get(c2) - 1;

            chars.put(c2, count);
        }

        for(Character key : chars.keySet()) {
            if (chars.get(key) != 0)
                return false;
        }

        return true;
    }

}

class Wrapper {
    String s1;
    String s2;

    Wrapper(String s1, String s2) {
        this.s1 = s1;
        this.s2 = s2;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Wrapper) {
            if (this.s1.equals(((Wrapper)o).s1) && this.s2.equals(((Wrapper)o).s2))
                return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.s1.hashCode() + this.s2.hashCode();
    }
}
