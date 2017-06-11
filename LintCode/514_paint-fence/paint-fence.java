/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/paint-fence
@Language: Java
@Datetime: 17-06-11 05:05
*/

public class Solution {
    /**
     * @param n non-negative integer, n posts
     * @param k non-negative integer, k colors
     * @return an integer, the total number of ways
     */
    public int numWays(int n, int k) {
        int[] dp = new int[] { k, k*k, 0 };
        if (n < 3) {
            return dp[n - 1];
        }
        if (k == 1) {
            return 0;
        }
        
        for (int i = 3; i <= n; ++i) {
            dp[2] = (k - 1) * (dp[0] + dp[1]);
            dp[0] = dp[1];
            dp[1] = dp[2];
        }
        return dp[2];
    }
}