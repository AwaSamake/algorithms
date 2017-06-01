/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/first-position-of-target
@Language: Java
@Datetime: 17-06-01 01:15
*/

class Solution {
    /**
     * @param nums: The integer array.
     * @param target: Target to find.
     * @return: The first position of target. Position starts from 0.
     */
    public int binarySearch(int[] nums, int target) {
        int lower = 0;
        int upper = nums.length - 1;
        int index = -1;
        while (lower <= upper) {
            int mid = (lower + upper) >> 1;
            if (nums[mid] == target) {
                index = mid;
            }
            if (nums[mid] >= target) {
                upper = mid - 1;
            } else {
                lower = mid + 1;
            }
        }
        return index;
    }
}