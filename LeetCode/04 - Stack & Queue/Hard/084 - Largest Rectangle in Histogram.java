/**
 *
 * 084. Largest Rectangle in Histogram
 *    Given n non-negative integers representing the histogram's bar height where the
 *    width of each bar is 1, find the area of largest rectangle in the histogram.
 *    https://leetcode.com/static/images/problemset/histogram.png
 *    Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
 *    https://leetcode.com/static/images/problemset/histogram_area.png
 *    The largest rectangle is shown in the shaded area, which has area = 10 unit.
 *
 *    For example,
 *    Given heights = [2,1,5,6,2,3],
 *    return 10.
 *
 */

import java.util.*;

public class Solution {
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