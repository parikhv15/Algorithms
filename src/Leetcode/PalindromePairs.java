package Leetcode;

import LinkedList.Palindrome;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by vrajp on 3/18/2016.
 */
public class PalindromePairs {

    public static void main(String a[]) {
        PalindromePairs pp = new PalindromePairs();

        String[] words = {"a",""};

        pp.palindromePairs(words);

        System.out.println();
    }

    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> output = new ArrayList<List<Integer>>();

        int[][] manacherLength = new int[words.length][];

        TrieNode root = new TrieNode('#');
        TrieNode invRoot = new TrieNode('#');

        for (int i = 0 ; i < words.length ; i++) {
            manacherLength[i] = new int[2*words[i].length()+1];

            lpsManacher(words[i], manacherLength[i]);
            addWordInv(invRoot, words[i], manacherLength[i], i);
        }

        for (int i = 0 ; i < words.length ; i++) {

            int word2 = isPalindromeMatch(invRoot, words[i]);

            if (word2 != -1 && word2 != i) {
                List<Integer> pair = new ArrayList<>();

                pair.add(i);
                pair.add(word2);

                output.add(pair);
            }
        }

        return output;
    }

    public void lpsManacher(String word, int[] lps) {
        String preWord = preProcessWord(word);

        int center = 0, right = 0;

        for (int i = 1 ; i < preWord.length() ; i++) {
            int mirror = 2 * center - i;

            lps[i] = (right > i) ? Math.min(right - i, lps[mirror]) : 0;

            while (i + lps[i] + 1 < preWord.length() && i - lps[i] - 1 >= 0 && preWord.charAt(i + lps[i] + 1) == preWord.charAt(i - lps[i] - 1))
                lps[i]++;

            if (i + lps[i] > right) {
                center = i;
                right = i + lps[i];
            }
        }
    }

    public String preProcessWord(String word) {
        String s = "";

        for (int i = 0 ; i < word.length() ; i++) {
            s += "|" + word.charAt(i);
        }

        return s+"|";
    }

    public int isPalindromeMatch(TrieNode root, String word) {
        HashMap<Character, TrieNode> children = root.children;

        TrieNode trie = null;

        for (int i = 0 ; i < word.length() ; i++) {
            char ch = word.charAt(i);

            if (children.containsKey(ch)) {
                trie = children.get(ch);
                children = trie.children;
            } else {
                return -1;
            }
        }

        for (Character c : children.keySet()) {
            TrieNode node = children.get(c);

            if (node.isPal)
                return node.index;
        }

        if (trie.isLeaf)
            return trie.index;

        return -1;
    }

    public void addWord(TrieNode root, String word) {
        HashMap<Character, TrieNode> children = root.children;

        for (int i =  0 ; i < word.length() ; i++) {
            char currChar = word.charAt(i);

            TrieNode tempNode;

            if (children.containsKey(currChar)) {
                tempNode = children.get(currChar);
            } else {
                tempNode = new TrieNode(currChar);
                children.put(currChar, tempNode);
            }


            if (i == word.length())
                tempNode.isLeaf = true;

            children = tempNode.children;
        }
    }

    public void addWordInv(TrieNode root, String word, int[] lps, int index) {
        HashMap<Character, TrieNode> children = root.children;

        for (int i =  word.length() - 1 ; i >= 0 ; i--) {
            char currChar = word.charAt(i);

            TrieNode tempNode;

            if (children.containsKey(currChar)) {
                tempNode = children.get(currChar);
            } else {
                tempNode = new TrieNode(currChar);
                children.put(currChar, tempNode);
            }

            tempNode.index = index;

            if (isPalindrome(lps, i))
                tempNode.isPal = true;

            if (i == 0)
                tempNode.isLeaf = true;

            children = tempNode.children;
        }
    }

    public boolean isPalindrome(int[] lps, int i) {
        int start = 2 * i + 1;
        int end = 0;

        int sum = start + end;
        int mid = (int) Math.ceil((double)(start + end) / 2);

        if (mid - lps[mid] <= 0 && mid + lps[mid] >= start)
            return true;

        return false;
    }
}

class TrieNode {
    HashMap<Character, TrieNode> children;
    char c;
    boolean isPal;
    boolean isLeaf;
    int index;

    public TrieNode(char c) {
        this.c = c;
        children = new HashMap<>();
        index = -1;
    }
}
