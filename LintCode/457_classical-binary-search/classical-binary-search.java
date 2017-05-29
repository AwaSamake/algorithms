/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/classical-binary-search
@Language: Java
@Datetime: 17-05-29 20:18
*/

public class Solution {
    /**
     * @param nums: An integer array sorted in ascending order
     * @param target: An integer
     * @return an integer
     */
    public int findPosition(int[] nums, int target) {
        int lower = 0, upper = nums.length - 1;
        while (lower <= upper) {
            int mid = (lower + upper) >> 1;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                lower = mid + 1;
            } else {
                upper = mid - 1;
            }
            
        }
        return -1;
    }
}