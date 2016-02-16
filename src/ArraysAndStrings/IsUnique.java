package ArraysAndStrings;

/**
 * Created by vrajp on 2/7/2016.
 */
public class IsUnique {

    public static void main(String a[]) {
        IsUnique iu = new IsUnique();

        System.out.println(iu.isUnique("aa"));;
    }

    public boolean isUnique(String s) {
        s = s.toLowerCase();

        int bitVector = 0;

        for (int i = 0 ; i < s.length() ; i++) {

            int value = s.charAt(i) - 'a';

            if ((bitVector & (1 << value)) > 0)
                return false;

            bitVector |= 1 << value;
        }
        return true;
    }
}
