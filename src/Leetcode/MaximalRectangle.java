package Leetcode;

import java.util.Stack;

/**
 * Created by vrajp on 4/24/2016.
 */
public class MaximalRectangle {

    public static void main(String a[]) {
        MaximalRectangle mr = new MaximalRectangle();

        char[][] matrix = {"101101".toCharArray(), "111111".toCharArray(), "011011".toCharArray(),
                "111010".toCharArray(), "011111".toCharArray(), "110111".toCharArray()};

        System.out.println(mr.maximalRectangle(matrix));
    }

    public int maximalRectangle(char[][] matrix) {
        int maxArea = 0;

        if(matrix.length == 0)
            return maxArea;

        int m = matrix.length;
        int n = matrix[0].length;

        int[] heights = new int[matrix[0].length];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                heights[j] = (matrix[i][j] == '1' ? heights[j] + 1 : 0);
            }

            Stack<Integer> s = new Stack<>();

            for (int j = 0; j < n + 1; j++) {
                int height = (j == n ? 0 : heights[j]);

                if (s.isEmpty() || height >= heights[s.peek()]) {
                    s.push(j);
                } else {
                    int top = s.pop();

                    int area = heights[top] * (s.isEmpty() ? j : j - 1 - s.peek());

                    maxArea = Math.max(maxArea, area);

                    j--;
                }
            }
        }
        return maxArea;
    }
}
