package Pramp;

import java.util.HashMap;

/**
 * Created by vrajp on 2/26/2016.
 */
public class SmallestSubstring {

    public static void main(String a[]) {
        SmallestSubstring ss = new SmallestSubstring();

        char[] chars = {'x', 'y', 'z'};

        System.out.println(ss.smallestSubString("xyyzyzyx", chars));
    }

    public String smallestSubString(String s, char[] chars) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < chars.length; i++) {
            map.put(chars[i], 0);
        }

        int start = 0, minStart = 0, length = 0, minLength = Integer.MAX_VALUE;

        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);

            if (!map.containsKey(currChar))
                continue;
            else {
                int tempCount = map.get(currChar);

                if (tempCount == 0)
                    length++;

                map.put(currChar, ++tempCount);
            }

            while (length == chars.length) {
                int len = i - start + 1;

                if (minLength > len) {
                    minLength = len;
                    minStart = start;
                }

                char startChar = s.charAt(start);
                if (map.containsKey(startChar)) {
                    int tempCount = map.get(startChar) - 1;

                    if (tempCount == 0)
                        length--;

                    map.put(startChar, tempCount);
                }
                start++;
            }
        }

        return s.substring(minStart, minStart+minLength);
    }
}
