package ArraysAndStrings;

/**
 * Created by vrajp on 2/7/2016.
 */
public class RotateMatrix {
    public static void main (String a[]) {
        RotateMatrix rm = new RotateMatrix();

        int[][] matrix = {{0, 1, 2, 3}, {4, 5, 6, 7}, {8, 9, 10, 11}, {12, 13, 14, 15}};
        rm.rotateMatrix(matrix, 1);
        rm.printMatrix(matrix);
    }

    public void rotateMatrix(int[][] matrix, int rotation) {
        for (int j = 0; j < matrix[0].length / 2 ; j++) {

            int first = j;
            int last =  matrix[0].length - j - 1;

            for (int i = first; i < last; i++) {
                int offset = matrix[0].length - i - 1;

                int temp = matrix[first][i];

                matrix[first][i] = matrix[offset][first];
                matrix[offset][first] = matrix[last][offset];
                matrix[last][offset] = matrix[i][last];
                matrix[i][last] = temp;
            }
        }
        System.out.println();

    }

    public void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
