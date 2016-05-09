package SortingAndSearching;


import utils.ds.Arrays;

/**
 * Created by vrajp on 5/5/2016.
 */
public class SortedMerge {

    public static void main(String a[]) {
        SortedMerge sm = new SortedMerge();

        int[] arr1 = new int[10];
        arr1[0] = 1;
        arr1[1] = 3;
        arr1[2] = 5;
        arr1[3] = 7;
        arr1[4] = 9;

        int[] arr2 = {2, 4, 6, 8, 10};

        sm.sortMerge(arr1, 5, arr2, 5);

        Arrays.print(arr1);
    }

    public void sortMerge(int[] arr1, int m, int[] arr2, int n) {
        int i = m-1, j = n-1, k = arr1.length - 1;

        while (i >= 0 && j >=0) {
            if (arr1[i] > arr2[j])
                arr1[k--] = arr1[i--];

            if (arr1[i] < arr2[j])
                arr1[k--] = arr2[j--];
        }

        while (j >= 0)
            arr1[k--] = arr2[j--];
    }
}
