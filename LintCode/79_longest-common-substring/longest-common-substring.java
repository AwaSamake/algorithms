/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/longest-common-substring
@Language: Java
@Datetime: 17-06-06 21:05
*/

public class Solution {
    /**
     * @param A, B: Two string.
     * @return: the length of the longest common substring.
     */
    public int longestCommonSubstring(String A, String B) {
		int m = A.length();
		int n = B.length();
		if (m == 0 || n == 0) {
			return 0;
		}
		int[][] dp = new int[m][n];
		int max = 0;
		for (int i = 0; i < n; ++i) {
			if (A.charAt(0) == B.charAt(i)) {
				dp[0][i] = 1;
				max = 1;
			}
		}
		for (int i = 0; i < m; ++i) {
			if (A.charAt(i) == B.charAt(0)) {
				dp[i][0] = 1;
				max = 1;
			}
		}
		for (int i = 1; i < m; ++i) {
			for (int j = 1; j < n; ++j) {
				if (A.charAt(i) == B.charAt(j)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
					max = Math.max(max, dp[i][j]);
				}
			}
		}
		return max;
	}
}