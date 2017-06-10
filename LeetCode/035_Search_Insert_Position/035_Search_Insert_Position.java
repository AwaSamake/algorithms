/**
 *
 * 035 Search Insert Position
 * Given a sorted array and a target value, return the index if the target is found. If 
 * not, return the index where it would be if it were inserted in order. You may assume 
 * no duplicates in the array.
 *
 */
import java.util.*;

class Solution {
	public int searchInsert(int[] nums, int target) {
		int lower = 0, upper = nums.length - 1;
		int mid = 0;
		while (lower <= upper) {
			mid = (lower + upper) >> 1;
			if (nums[mid] == target) {
				return mid;
			} else if (nums[mid] < target) {
				lower = mid + 1;
			} else {
				upper = mid - 1;
			}
		}
		return nums[mid] >= target ? mid : mid + 1;
	}
}