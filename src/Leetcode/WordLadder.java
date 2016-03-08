package Leetcode;

import java.util.*;

/**
 * Created by vrajp on 3/7/2016.
 */
public class WordLadder {

    public static void main(String[] a) {
        WordLadder wl = new WordLadder();

        String[] words = {"a", "b", "c"};

        Set<String> set = new HashSet<String>(Arrays.asList(words));

        System.out.println(wl.ladderLength("a", "c", set));
    }
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        Queue<WordWrapper> q = new LinkedList<>();

        q.offer(new WordWrapper(beginWord, 1));

        while (!q.isEmpty()) {
            WordWrapper wordWrap = q.poll();
            String word = wordWrap.word;

            char[] wordArr = word.toCharArray();

            if (word.equals(endWord))
                return wordWrap.index;

            for (int i = 0 ; i < wordArr.length ; i++) {
                for (char c = 'a' ; c <= 'z' ; c++) {
                    if (c == wordArr[i])
                        continue;
                    char temp = wordArr[i];

                    wordArr[i] = c;

                    String newWord = new String(wordArr);
                    if (wordList.contains(newWord)) {
                        q.offer(new WordWrapper(newWord, wordWrap.index+1));
                        wordList.remove(newWord);
                    }

                    wordArr[i] = temp;
                }
            }
        }
        return 0;
    }
}

class WordWrapper {
    String word;
    int index;

    public WordWrapper (String word, int index) {
        this.word = word;
        this.index = index;
    }
}
