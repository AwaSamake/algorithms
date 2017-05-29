/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/largest-rectangle-in-histogram
@Language: Java
@Datetime: 17-05-28 23:33
*/

public class Solution {
    /**
     * @param height: A list of integer
     * @return: The area of largest rectangle in the histogram
     */
    public int largestRectangleArea(int[] heights) {
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < heights.length; ++i) {
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                max = Math.max(max, width * height);
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int height = heights[stack.pop()];
            int width = stack.isEmpty() ? heights.length : heights.length - stack.peek() - 1;
            max = Math.max(max, width * height);
        }
        return max;
    }
}
