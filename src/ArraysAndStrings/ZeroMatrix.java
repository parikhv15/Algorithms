package ArraysAndStrings;

/**
 * Created by vrajp on 2/9/2016.
 */
public class ZeroMatrix {

    public static void main (String a[]) {
        ZeroMatrix zm = new ZeroMatrix();


        int matrix[][] = {{0, 1, 2, 3}, {4, 5, 0, 7}, {8, 9, 10, 11}, {12, 13, 14, 15}};

        zm.appendZeroMatrix(matrix);
        zm.printMatrix(matrix);
    }

    public void appendZeroMatrix (int[][] matrix) {
        boolean firstRowZero = false;
        boolean firstColumnZero = false;

        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0)
                firstRowZero = true;
        }

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0)
                firstColumnZero = true;
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;

                }
            }
        }
        printMatrix(matrix);
        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i][0] == 0)
                nullifyRow(matrix, i);
        }
        printMatrix(matrix);
        for (int i = 1; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0)
                nullifyColumn(matrix, i);
        }
        printMatrix(matrix);

        if (firstRowZero)
            nullifyRow(matrix, 0);

        if (firstColumnZero)
            nullifyColumn(matrix, 0);
    }

    public void nullifyRow(int[][] matrix, int index) {
        for (int i = 0; i < matrix[0].length; i++) {
            matrix[index][i] = 0;
        }
    }

    public void nullifyColumn(int[][] matrix, int index) {
        System.out.println(index);
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][index] = 0;
        }
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
