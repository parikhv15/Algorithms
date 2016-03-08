package ArraysAndStrings;

import java.util.InputMismatchException;
import java.util.LinkedList;

/**
 * Created by vrajp on 2/10/2016.
 */
public class EnglishInt {

    String smalls[] = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight",
            "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen",
            "Seventeen", "Eighteen", "Nineteen"};

    String tens[] = {"", "", "Twenty", "Thirty", "Fourty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    String bigs[] = {"", "Thousand", "Million", "Billion"};

    String hundred = "hundred";

    public static void main(String a[]) {

        EnglishInt ei = new EnglishInt();

        System.out.println(ei.convertToEnglish(100));
    }

    public String convertToEnglish(int number) {
        LinkedList<String> parts = new LinkedList<>();

        if (number == 0)
            return smalls[0];

        int chunkCount = 0;
        while (number > 0) {
            if (number % 1000 != 0) {
                String chunk = convertChunkToEnglish(number % 1000) + bigs[chunkCount];
                parts.addFirst(chunk);
            }
            number /= 1000;
            chunkCount++;
        }

        return convertToString(parts);
    }

    public String convertChunkToEnglish(int number) {
        LinkedList<String> parts = new LinkedList<>();

        if (number >= 100) {
            parts.addLast(smalls[number / 100] + " " + hundred);
            number %= 100;
        }

        if (number >= 10 && number <= 19) {
            parts.addLast(smalls[number]);
        } else if (number >= 20) {
            parts.addLast(tens[number / 10]);
            number %= 10;
        }

        if (number >= 1 && number <= 9) {
            parts.addLast(smalls[number]);
        }

        return convertToString(parts);
    }

    public String convertToString(LinkedList<String> parts) {
        StringBuilder sb = new StringBuilder();

        while (!parts.isEmpty()) {
            sb.append(parts.remove());
            sb.append(" ");
        }

        return sb.toString();
    }
}
