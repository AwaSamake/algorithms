/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/interleaving-string
@Language: Java
@Datetime: 17-06-01 04:08
*/

public class Solution {
    /*
     * @param : A string
     * @param : A string
     * @param : A string
     * @return: Determine whether s3 is formed by interleaving of s1 and s2
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        
        int m = s1.length() + 1;
        int n = s2.length() + 1;
        boolean[][] dp = new boolean[m][n];
        dp[0][0] = true;
        for(int i = 1; i < m; ++i) {
            dp[i][0] = s1.charAt(i - 1) == s3.charAt(i - 1) && dp[i - 1][0];
        }
        for(int i = 1; i < n; ++i) {
            dp[0][1] = s2.charAt(i - 1) == s3.charAt(i - 1) && dp[0][i - 1];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; ++j) {
                dp[i][j] = (s3.charAt(i + j - 1) == s1.charAt(i - 1) && dp[i-1][j]) 
                || (s3.charAt(i + j - 1) == s2.charAt(j - 1) && dp[i][j - 1]);
            }
        }
        return dp[m-1][n-1];
    }
};