/**
 *
 * 097. Interleaving String
 *    Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 *
 *    For example,
 *    Given:
 *    s1 = "aabcc",
 *    s2 = "dbbca",
 *
 *    When s3 = "aadbbcbcac", return true.
 *    When s3 = "aadbbbaccc", return false.
 *
 */

import java.util.*;

public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        int m = s1.length() + 1;
        int n = s2.length() + 1;
        boolean[][] dp = new boolean[m][n];
        dp[0][0] = true;
        for (int i = 1; i < m; ++i) {
            dp[i][0] = (s1.charAt(i - 1) == s3.charAt(i - 1) && dp[i - 1][0]);
        }
        for (int i = 1; i < n; ++i) {
            dp[0][i] = (s2.charAt(i - 1) == s3.charAt(i - 1) && dp[0][i - 1]);
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; ++j) {
                if ((s3.charAt(i + j - 1) == s1.charAt(i - 1) && dp[i - 1][j]) || (s3.charAt(i + j - 1) == s2.charAt(j - 1) && dp[i][j - 1])) {
                    dp[i][j] = true;
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}