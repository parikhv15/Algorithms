package SortingAndSearching;

import utils.ds.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by vrajp on 5/5/2016.
 */
public class GroupAnagrams {
    public static void main(String[] a) {
        GroupAnagrams ga = new GroupAnagrams();

        String[] words = {"ada", "daa", "vraj", "jrva", "rajv"};

        System.out.println(ga.groupAnagrams(words));
    }

    public List<List<String>> groupAnagrams(String[] words) {
        HashMap<String, ArrayList<String>> map = new HashMap<>();

        for (String word : words) {
            String key = sortChars(word);

            ArrayList<String> temp;

            if (!map.containsKey(key))
                temp = new ArrayList<>();
            else
                temp = map.get(key);

            temp.add(word);
            map.put(key, temp);
        }

        List<List<String>> result = new ArrayList<>();

        for (String key : map.keySet()) {
            result.add(map.get(key));
        }

        return result;
    }

    public String sortChars(String s) {
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }
}
