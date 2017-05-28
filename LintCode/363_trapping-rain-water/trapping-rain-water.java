/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/trapping-rain-water
@Language: Java
@Datetime: 17-05-27 22:02
*/

public class Solution {
    /**
     * @param heights: an array of integers
     * @return: a integer
     */
    public int trapRainWater(int[] heights) {
        int[] walls = new int[heights.length];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < walls.length; ++i) {
            if (heights[i] > max) {
                max = heights[i];
            }
            walls[i] = max;
        }
        max = Integer.MIN_VALUE;
        for (int i = walls.length - 1; i > -1; --i) {
            if (heights[i] > max) {
                max = heights[i];
            }
            walls[i] = Math.min(walls[i], max);
        }
        
        int water = 0;
        for (int i = 0; i < walls.length; ++i) {
            water += walls[i] - heights[i];
        }
        return water;
    }
}