/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/minimum-subarray
@Language: Java
@Datetime: 17-06-10 00:30
*/

public class Solution {
    /**
     * @param nums: a list of integers
     * @return: A integer indicate the sum of minimum subarray
     */
    public int minSubArray(ArrayList<Integer> nums) {
        int[] dp = new int[nums.size()];
        dp[0] = nums.get(0);
        int min = dp[0];
        for (int i = 1; i < nums.size(); ++i) {
            dp[i] = Math.min(nums.get(i), nums.get(i) + dp[i - 1]);
            min = Math.min(min, dp[i]);
        }
        return min;
    }
}
