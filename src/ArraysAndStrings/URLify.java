package ArraysAndStrings;

/**
 * Created by vrajp on 2/7/2016.
 */
public class URLify {

    public static void main(String a[]) {
        URLify url = new URLify();

        System.out.println(url.convertToURL("Mr Vraj Parikh    ".toCharArray(), 14));;
    }

    public String convertToURL(char[] chars, int length) {

        int j = chars.length - 1;
        for (int i = length - 1; i >= 0; i--) {
            if (chars[i] == ' ') {
                chars[j--] = '0';
                chars[j--] = '2';
                chars[j--] = '%';
            }
            else
                chars[j--] = chars[i];
        }

        return new String(chars);
    }
}
