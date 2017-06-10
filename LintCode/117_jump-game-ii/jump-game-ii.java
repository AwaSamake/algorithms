/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/jump-game-ii
@Language: Java
@Datetime: 17-06-09 23:53
*/

public class Solution {
    /**
     * @param A: A list of lists of integers
     * @return: An integer
     */
    public int jump(int[] A) {
		if (A.length < 2) {
			return A.length;
		}
		int[] dp = new int[A.length];
		for (int i = A.length - 2; i > -1; --i) {
			int min = Integer.MAX_VALUE;
			for (int j = i + 1; j < A.length && j <= A[i] + i; ++j) {
				if (dp[j] < min) {
					min = dp[j];
				}
			}
			dp[i] = 1 + min;
		}
		return dp[0];
	}
}
