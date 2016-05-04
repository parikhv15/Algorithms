package HackerRank;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by vrajp on 5/2/2016.
 */
public class BearAndSteadyGene {


    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);

        HashMap<Character, Integer> map = new HashMap<>();
        map.put('A', 0);
        map.put('C', 0);
        map.put('G', 0);
        map.put('T', 0);

        int n = sc.nextInt() / 4;
        String dna = sc.next();

        for (int i = 0 ; i < dna.length() ; i++) {
            char ch = dna.charAt(i);

            int c = map.get(ch) + 1;
            map.put(ch, c);
        }

        int ans = Integer.MAX_VALUE;

        int i = 0;
        for (int j = 0 ; j < dna.length() ; j++) {
            char ch = dna.charAt(j);

            if (!isValid(map, n)) {
                int c = map.get(ch) - 1;

                map.put(ch, c);
            } else if (i < j) {
                ans = Math.min(ans, j - i + 1);

                int c = map.get(dna.charAt(i)) + 1;

                map.put(dna.charAt(i), c);
                i++;
                j--;
            }
        }

        System.out.println(ans);
    }

    public static boolean isValid(HashMap<Character, Integer> map, int n) {
        return (map.get('A') <= n && map.get('G') <= n && map.get('C') <= n && map.get('T') <= n);
    }
}
