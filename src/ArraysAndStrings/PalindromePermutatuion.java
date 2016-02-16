package ArraysAndStrings;

/**
 * Created by vrajp on 2/7/2016.
 */
public class PalindromePermutatuion {

    public static void main(String a[]) {
        PalindromePermutatuion pp = new PalindromePermutatuion();

        System.out.println( pp.isPermutationOfPalindrome("aba"));
    }

    public boolean isPermutationOfPalindrome(String s) {

        s = s.toLowerCase();

        int bitVector = 0;

        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            bitVector = setBitVector(bitVector, index);
        }

        return bitVector == 0 || checkOneBitSet(bitVector);
    }

    public int setBitVector(int bitVector, int index) {
        int mask = 1 << index;

        if ((bitVector & mask) == 0)
            bitVector |= mask;
        else
            bitVector &= ~mask;

        return bitVector;
    }

    public boolean checkOneBitSet(int bitVector) {
        return (bitVector & (bitVector - 1)) == 0;
    }
}
