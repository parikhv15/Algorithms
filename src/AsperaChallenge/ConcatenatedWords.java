package AsperaChallenge;

import sun.text.normalizer.Trie;

import java.io.*;
import java.net.URL;
import java.util.*;

/**
 * Created by vrajp on 4/8/2016.
 */
public class ConcatenatedWords {

    private TrieNode trieHead;

    ConcatenatedWords () {
        trieHead = new TrieNode('*');
    }

    public static void main(String a[]) {
        String filename = a[0];

        ConcatenatedWords cw = new ConcatenatedWords();
        Queue<WordSuffixMapper> queue = new LinkedList<>();

        cw.readFile(filename, queue);

        TreeSet<String> concatenatedWords = cw.getConcatenatedWords(queue);

        cw.printOutput(concatenatedWords);
    }

    public TreeSet<String> getConcatenatedWords(Queue<WordSuffixMapper> queue) {
        LengthComparator lengthComparator = new LengthComparator();

        TreeSet<String> concatenatedWords = new TreeSet<>(lengthComparator);

        while (!queue.isEmpty()) {
            WordSuffixMapper wordSuffixMapper = queue.poll();

            if (findPrefix(wordSuffixMapper.getWord(), wordSuffixMapper.getSuffix(), queue)) {
                String concateWord = wordSuffixMapper.getWord();

                concatenatedWords.add(concateWord);
            }
        }

        return concatenatedWords;
    }

    public void printOutput(TreeSet<String> concatenatedWords) {
        Iterator itr = concatenatedWords.iterator();
        int kMax = 1;

        while(itr.hasNext() && kMax <= 2) {
            String word = (String) itr.next();
            System.out.println("Longest Concatenated Word " + kMax + ": " + word + " [" + word.length() + " characters" + "]");
            kMax++;
        }
        System.out.println();
        System.out.println("Total Number of Concatenated Words: " + concatenatedWords.size());
    }

    public void readFile(String filename, Queue<WordSuffixMapper> queue) {
        URL url = getClass().getResource("file.txt");

        File file = new File(url.getPath());

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));

            String line = br.readLine();

            while (line != null) {
                findPrefixAndAddWord(line, queue);
                line = br.readLine();
            }

            br.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public boolean findPrefix(String word, String suffix, Queue<WordSuffixMapper> queue) {
        HashMap<Character, TrieNode> children = trieHead.getChildren();

        TrieNode node = null;

        for (int i = 0; i < suffix.length(); i++) {
            char currChar = suffix.charAt(i);

            if (children.containsKey(currChar)) {
                node = children.get(currChar);
                children = node.getChildren();

                if (node.isLeaf()) {
                    if (i == suffix.length() - 1)
                        return true;
                    else
                        queue.offer(new WordSuffixMapper(word, suffix.substring(i + 1, suffix.length())));
                }
            } else {
                return false;
            }
        }

        return false;
    }
    public void findPrefixAndAddWord(String word, Queue<WordSuffixMapper> queue) {
        HashMap<Character, TrieNode> children = trieHead.getChildren();

        for (int i = 0; i < word.length(); i++) {
            char currChar = word.charAt(i);

            TrieNode node = null;

            if (!children.containsKey(currChar)) {
                node = new TrieNode(currChar);
                children.put(currChar, node);
            } else {
                node = children.get(currChar);

                if (node.isLeaf()) {
                    queue.offer(new WordSuffixMapper(word, word.substring(i + 1, word.length())));
                }
            }

            children = node.getChildren();

            if (i == word.length() - 1)
                node.setLeaf(true);
        }
    }


}

class TrieNode {
    private char ch;
    private boolean isLeaf;
    private HashMap<Character, TrieNode> children;

    TrieNode (char ch) {
        this.ch = ch;
        this.children = new HashMap<>();
    }

    public char getCh() {
        return ch;
    }

    public void setCh(char ch) {
        this.ch = ch;
    }

    public boolean isLeaf() {
        return isLeaf;
    }

    public void setLeaf(boolean leaf) {
        isLeaf = leaf;
    }

    public HashMap<Character, TrieNode> getChildren() {
        return children;
    }

    public void setChildren(HashMap<Character, TrieNode> children) {
        this.children = children;
    }
}

class WordSuffixMapper {
    private String word;
    private String suffix;

    WordSuffixMapper (String word, String suffix) {
        this.word = word;
        this.suffix = suffix;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }
}

class LengthComparator implements Comparator<String> {

    @Override
    public int compare(String s1, String s2) {
        return Integer.compare(s2.length(), s1.length());
    }
}
