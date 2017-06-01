/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/maximal-square
@Language: Java
@Datetime: 17-06-01 02:23
*/

public class Solution {
    /**
     * @param matrix: a matrix of 0 and 1
     * @return: an integer
     */
    public int maxSquare(int[][] matrix) {
        if (matrix.length < 1) {
            return 0;
        }
        if (matrix[0].length < 1) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int max = 0;
        for (int i = 0; i < m; ++i) {
            dp[i][0] = matrix[i][0];
            max = Math.max(max, dp[i][0]);
        }
        for (int i = 0; i < n; ++i) {
            dp[0][i] = matrix[0][i];
            max = Math.max(max, dp[0][i]);
        }
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                if (matrix[i][j] == 1) {
                    dp[i][j] = min(dp[i - 1][j - 1], dp[i][j - 1], dp[i - 1][j]) + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max * max;
    }
    
    private int min(int a, int b, int c) {
        if (a > b) {
            return Math.min(b, c);
        } else {
            return Math.min(a, c);
        }
    }
}