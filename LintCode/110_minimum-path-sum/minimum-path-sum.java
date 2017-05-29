/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/minimum-path-sum
@Language: Java
@Datetime: 17-05-29 22:55
*/

public class Solution {
    /**
     * @param grid: a list of lists of integers.
     * @return: An integer, minimizes the sum of all numbers along its path
     */
    public int minPathSum(int[][] grid) {
        if (grid.length < 1 || grid[0].length < 1) {
            return -1;
        }
        for (int i = grid.length - 1; i > -1; --i) {
            for (int j = grid[0].length - 1; j > -1; --j) {
                grid[i][j] = minPathSum(grid, i, j);
            }
        }
        return grid[0][0];
    }
    
    private int minPathSum(int[][] grid, int i, int j) {
        if (i + 1 < grid.length || j + 1 < grid[0].length) {
            int right = (j + 1 < grid[0].length) ? grid[i][j + 1] : Integer.MAX_VALUE;
            int down = (i + 1 < grid.length) ? grid[i + 1][j] : Integer.MAX_VALUE;
            return grid[i][j] + Math.min(right, down);
        }
        return grid[i][j];
    }
}
