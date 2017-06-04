/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/find-minimum-in-rotated-sorted-array
@Language: Java
@Datetime: 17-06-04 05:29
*/

public class Solution {
    /**
     * @param nums: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] nums) {
		int lower = 0;
		int upper = nums.length - 1;
		if (upper < 0) {
			return -1;
		}
		int min = Integer.MAX_VALUE;
		while (lower <= upper) {
			int mid = (lower + upper) >> 1;
			if (nums[mid] < nums[upper]) {
				upper = mid - 1;
			} else {
				lower = mid + 1;
			}
			min = Math.min(min, nums[mid]);
		}
		return min;
	}
}