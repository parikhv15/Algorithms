package Leetcode;

import java.util.*;

/**
 * Created by vrajp on 3/7/2016.
 */
public class WordLadderII {

    public static void main(String[] a) {
        WordLadderII wl = new WordLadderII();

        String[] words = {"hot","cog","dog","tot","hog","hop","pot","dot"};

        Set<String> set = new HashSet<String>(Arrays.asList(words));

        System.out.println(wl.findLadders("hot", "dog", set));
    }
    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        Queue<WordWrapperII> q = new LinkedList<>();
        List<List<String>> ladders = new ArrayList<List<String>>();
        List<String> ladder;

        HashSet<String> visited = new HashSet<>();

        q.add(new WordWrapperII(beginWord, 1, null));

        int preIndex = 0;

        while (!q.isEmpty()) {
            WordWrapperII wordWrap = q.remove();
            String word = wordWrap.word;

            char[] wordArr = word.toCharArray();

            if (word.equals(endWord)) {
                ladder = new ArrayList<>();

                generateLadder(wordWrap, ladder);

                ladders.add(ladder);
            }

            if (preIndex < wordWrap.index) {
                wordList.removeAll(visited);
                visited.clear();
            }

            preIndex = wordWrap.index;

            for (int i = 0 ; i < wordArr.length ; i++) {
                for (char c = 'a' ; c <= 'z' ; c++) {
                    if (c == wordArr[i])
                        continue;

                    char temp = wordArr[i];

                    wordArr[i] = c;

                    String newWord = new String(wordArr);
                    if (wordList.contains(newWord)) {
                        q.add(new WordWrapperII(newWord, wordWrap.index+1, wordWrap));
                        visited.add(newWord);
                    }

                    wordArr[i] = temp;
                }
            }
        }
        return ladders;
    }

    public void generateLadder(WordWrapperII wordWrap, List<String> ladder) {
        if (wordWrap == null)
            return;

        generateLadder(wordWrap.pre, ladder);
        ladder.add(wordWrap.word);
    }
}


class WordWrapperII {
    String word;
    int index;
    WordWrapperII pre;

    public WordWrapperII (String word, int index, WordWrapperII pre) {
        this.word = word;
        this.index = index;
        this.pre = pre;
    }
}
