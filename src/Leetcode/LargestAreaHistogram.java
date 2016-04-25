package Leetcode;

import java.util.Stack;

/**
 * Created by vrajp on 4/24/2016.
 */
public class LargestAreaHistogram {

    public static void main(String a[]) {
        LargestAreaHistogram lah = new LargestAreaHistogram();

        int heights[] = {4,2,0,3,2,5};

        System.out.println(lah.largestRectangleArea(heights));
    }
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();

        int maxArea = Integer.MIN_VALUE;
        int i = 0;

        while (i < heights.length) {
            int area = 0;
            if (st.isEmpty() || heights[i] >= heights[st.peek()]) {
                st.push(i);
                i++;
            } else {
                int top = st.pop();
                area = heights[top] * (st.isEmpty() ? i : i - 1 - st.peek());

                maxArea = Math.max(maxArea, area);
            }
        }

        while (!st.isEmpty()) {
            int top = st.pop();
            int area = heights[top] * (st.isEmpty() ? i : i - 1 - st.peek());

            maxArea = Math.max(maxArea, area);
        }

        return maxArea == Integer.MIN_VALUE ? 0 : maxArea;
    }
}
