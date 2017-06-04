/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/container-with-most-water
@Language: Java
@Datetime: 17-06-04 04:15
*/

public class Solution {
    /**
     * @param heights: an array of integers
     * @return: an integer
     */
    public int maxArea(int[] heights) {
        int max = 0;
        int lower = 0;
        int higher = heights.length - 1;
        while (lower < higher) {
            max = Math.max(max, Math.min(heights[lower], heights[higher]) * (higher - lower));
            if (heights[lower] < heights[higher]) {
                lower++;
            } else {
                higher--;
            }
        }
        return max;
    }
}