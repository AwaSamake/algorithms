/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/triangle
@Language: Java
@Datetime: 17-06-09 02:22
*/

public class Solution {
    /**
     * @param triangle: a list of lists of integers.
     * @return: An integer, minimum path sum.
     */
    public int minimumTotal(int[][] triangle) {
		if (triangle.length == 0) {
			return -1;
		}
		if (triangle.length == 1) {
			return triangle[0][0];
		}
		int n = triangle[triangle.length - 1].length;
		int[] dp = new int[n + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[1] = triangle[0][0];
		for (int i = 1; i < n; ++i) {
			for (int j = i + 1; j > 0; --j) {
				dp[j] = triangle[i][j - 1] + Math.min(dp[j], dp[j - 1]);
			}
		}
		int min = Integer.MAX_VALUE;
		for (int i : dp) {
			if (i < min) {
				min = i;
			}
		}
		return min;
	}
}
