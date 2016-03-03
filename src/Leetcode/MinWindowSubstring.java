package Leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by vrajp on 2/25/2016.
 */
public class MinWindowSubstring {

    public static void main (String a[]) {
        MinWindowSubstring mws = new MinWindowSubstring();

        System.out.println(mws.minWindow("adobecodebanc", "banc"));
    }

    // String s only containing exact numbers of characters in t
    public String minWindow(String s, String t) {

        int[] charCount = new int[256];
        HashSet<Character> charSet = new HashSet<>();

        for(char ch : t.toCharArray()) {
            charCount[ch - 'A']++;
            charSet.add(ch);
        }

        int i = 0, start = 0, minStart = 0, minLength = Integer.MAX_VALUE;
        Queue<CharWrapper> queue = new LinkedList<>();

        while (i < s.length()) {
            char currentChar = s.charAt(i);
            if (charSet.contains(currentChar)) {
                if (charCount[currentChar - 'A'] == 0) {
                    while (!queue.isEmpty()) {
                        CharWrapper tempCW = queue.remove();
                        charCount[tempCW.ch - 'A']++;
                        if (!queue.isEmpty())
                            start = queue.peek().index;
                        else
                            start = i;
                        if (currentChar == tempCW.ch)
                            break;
                    }
                }
                queue.add(new CharWrapper(i, currentChar));
                charCount[currentChar - 'A']--;
            } else {
                if (i == start)
                    start++;
            }

            if (allMatches(charCount)) {
                if (minLength > i - start + 1) {
                    minLength = i - start + 1;
                    minStart = start;
                }
                CharWrapper tempCW = queue.remove();
                charCount[tempCW.ch - 'A']++;
                if (!queue.isEmpty())
                    start = queue.peek().index;
                else
                    start = i;
            }
            i++;
        }
        return minLength == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart+minLength);
    }

    public boolean allMatches(int[] charCount) {
        for (int i : charCount) {
            if (i != 0)
                return false;
        }
        return true;
    }
}

class CharWrapper {
    char ch;
    int index;

    public CharWrapper(int index, char ch) {
        this.index = index;
        this.ch = ch;
    }
}
