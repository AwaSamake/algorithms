/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/unique-paths-ii
@Language: Java
@Datetime: 17-06-10 00:09
*/

public class Solution {
    /**
     * @param obstacleGrid: A list of lists of integers
     * @return: An integer
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int m = obstacleGrid.length;
		if (m <= 0) {
			return 0;
		}
		int n = obstacleGrid[0].length;
		if (n <= 0) {
			return 0;
		}
		int[][] dp = new int[m + 1][n + 1];
		dp[m][n - 1] = 1;
		for (int i = m - 1; i >= 0; --i) {
			for (int j = n - 1; j >= 0; --j) {
				dp[i][j] = (obstacleGrid[i][j] == 0) ? dp[i + 1][j] + dp[i][j + 1] : 0;
			}
		}
		return dp[0][0];
	}
}