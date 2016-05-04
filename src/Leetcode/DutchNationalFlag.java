package Leetcode;

import org.apache.commons.lang3.ArrayUtils;
import utils.ds.Arrays;

/**
 * Created by vrajp on 5/3/2016.
 */
public class DutchNationalFlag {

    public static void main(String[] a) {
        DutchNationalFlag dnf = new DutchNationalFlag();

        int[] arr = {1,0,0,2,1,2,2,0,1};

        dnf.sortColors(arr);

        Arrays.print(arr);
    }

    public void sortColors(int[] colors) {
        int r = 0, g = 0, b = colors.length - 1;

        while (g <= b) {
            switch (colors[g]) {
                case 0:
                    Arrays.swap(colors, r++, g++);
                    break;

                case 1:
                    g++;
                    break;

                case 2:
                    Arrays.swap(colors, g, b--);
                    break;
            }
        }
    }
}
