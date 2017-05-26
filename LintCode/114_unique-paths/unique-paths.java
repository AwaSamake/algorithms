/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/unique-paths
@Language: Java
@Datetime: 17-05-25 23:15
*/

public class Solution {
    /**
     * @param n, m: positive integer (1 <= n ,m <= 100)
     * @return an integer
     */
    public int uniquePaths(int m, int n) {
        if (m <= 0 || n <= 0) {
            return 0;
        }
        int[][] grid = new int[m][n];
        for (int i = m - 1; i >= 0; --i) {
            for (int j = n - 1; j >= 0; --j) {
                grid[i][j] = getPaths(grid, i, j);
            }
        }
        return grid[0][0];
    }
    
    private int getPaths(int[][] grid, int i, int j) {
        if (i >= grid.length - 1 || j >= grid[0].length - 1) {
            return 1;
        }
        return grid[i][j + 1] + grid[i + 1][j];
    }
    
}
