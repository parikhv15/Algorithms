package utils.ds;

/**
 * Created by vrajp on 5/3/2016.
 */
public class Arrays<E> {

    public static void print(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void reverse(int[] array, int start, int end) {
        while (start < end) {
            swap(array, start++, end--);
        }
    }
}
