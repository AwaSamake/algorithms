/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/paint-house-ii
@Language: Java
@Datetime: 17-05-28 04:37
*/

public class Solution {
    /**
     * @param costs n x k cost matrix
     * @return an integer, the minimum cost to paint all houses
     */
    public int minCostII(int[][] costs) {
		int n = costs.length;
		if (n < 1) {
			return 0;
		}
		int c = costs[0].length;
		int[][] cache = new int[costs.length][costs[0].length];
		for (int i = 0; i < c; ++i) {
			cache[0][i] = costs[0][i];
		}
		for (int i = 1; i < n; ++i) {
			
			for (int j = 0; j < c; ++j) {
				int min = Integer.MAX_VALUE;
				for (int k = 0; k < c; ++k) {
					if (j != k) {
						min = Math.min(min, cache[i - 1][k]);
					}
				}
				cache[i][j] = costs[i][j] + min;
			}
		}
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < c; ++i) {
			min = Math.min(min, cache[n - 1][i]);
		}
		return min;
	}

}