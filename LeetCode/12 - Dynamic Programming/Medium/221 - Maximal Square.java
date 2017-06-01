/**
 *
 * 221. Maximal Square
 *    Given a 2D binary matrix filled with 0's and 1's, find the largest square containing
 *    only 1's and return its area.
 *
 *    For example, given the following matrix:
 *
 *    1 0 1 0 0
 *    1 0 1 1 1
 *    1 1 1 1 1
 *    1 0 0 1 0
 *    Return 4.
 *
 */

import java.util.*;

public class Solution {
    /**
     * @param matrix: a matrix of 0 and 1
     * @return: an integer
     */
    public int maximalSquare(char[][] matrix) {
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
            if (matrix[i][0] == '1') {
                dp[i][0] = 1;
                max = 1;
            }
        }
        for (int i = 0; i < n; ++i) {
            if (matrix[0][i] == '1') {
                dp[0][i] = 1;
                max = 1;
            }
        }
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                if (matrix[i][j] == '1') {
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