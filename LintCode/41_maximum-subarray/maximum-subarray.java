/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/maximum-subarray
@Language: Java
@Datetime: 17-06-10 21:37
*/

public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */
    public int maxSubArray(int[] nums) {
        if (nums.length < 1) {
            return 0;
        }
        int max = nums[0];
        int maxBegin = 0;
        int maxEnd = 0;
        int begin = 0;
        int end = 0;
        int sum = 0;
        while (end < nums.length) {
            sum += nums[end];
            if (sum < 0) {
                sum = 0;
                begin = end + 1;
            } else {
                if (sum > max) {
                    max = sum;
                    maxBegin = begin;
                    maxEnd = end;
                }
            }
            end++;
        }
        return max;
    }
}