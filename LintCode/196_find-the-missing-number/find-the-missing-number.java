/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/find-the-missing-number
@Language: Java
@Datetime: 17-05-26 21:07
*/

public class Solution {
    /**    
     * @param nums: an array of integers
     * @return: an integer
     */
    public int findMissing(int[] nums) {
        int n = nums.length;
        boolean zero = false;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[nums[i] % n] == 0) {
                zero = true;
            }
            nums[nums[i] % n] += n;
        }
        if (!zero) {
            return 0;
        }
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] < n) {
                return i;
            }
        }
        return n;
    }
}