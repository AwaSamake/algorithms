/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/minimum-size-subarray-sum
@Language: Java
@Datetime: 17-05-26 05:39
*/

public class Solution {
    /**
     * @param nums: an array of integers
     * @param s: an integer
     * @return: an integer representing the minimum size of subarray
     */
    public int minimumSize(int[] nums, int s) {
        int i = 0;
        int j = 0;
        int length = -1;
        int sum = 0;
        while (j < nums.length || sum >= s) {
            if (sum < s) {
                sum += nums[j++];
            } else {
                if (length == -1) {
                    length = j - i;
                } else {
                    length = Math.min(length, j - i);
                }
                sum -= nums[i++];
            }
        }
        return length;
    }
}