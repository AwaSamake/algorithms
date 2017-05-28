/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/paint-house
@Language: Java
@Datetime: 17-05-28 03:36
*/

public class Solution {
	/**
	 * @param costs n x 3 cost matrix
	 * @return an integer, the minimum cost to paint all houses
	 */
	public int minCost(int[][] costs) {
		int n = costs.length;
		if (n < 1) {
			return 0;
		}
		int[][] cache = new int[costs.length][costs[0].length];
		cache[0][0] = costs[0][0];
		cache[0][1] = costs[0][1];
		cache[0][2] = costs[0][2];
		for (int i = 1; i < n; ++i) {
			cache[i][0] = costs[i][0] + Math.min(cache[i - 1][1], cache[i - 1][2]);
			cache[i][1] = costs[i][1] + Math.min(cache[i - 1][0], cache[i - 1][2]);
			cache[i][2] = costs[i][2] + Math.min(cache[i - 1][0], cache[i - 1][1]);
		}
		return Math.min(Math.min(cache[n - 1][0], cache[n - 1][1]), cache[n - 1][2]);
	}
}