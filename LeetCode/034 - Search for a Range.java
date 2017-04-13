/**
 *
 * 034. Search for a Range
 *     Given an array of integers sorted in ascending order, find the starting and ending 
 *     position of a given target value.
 *     
 *     Your algorithm's runtime complexity must be in the order of O(log n).
 *     
 *     If the target is not found in the array, return [-1, -1].
 *     
 *     For example,
 *     Given [5, 7, 7, 8, 8, 10] and target value 8,
 *     return [3, 4].
 *
 */
import java.util.*;

public class Solution {
	public int[] searchRange(int[] nums, int target) {
		int[] result = new int[] {-1, -1};
		if (nums.length == 0) {
		    return result;
		}
		int lower = 0, upper = nums.length - 1;
		while (lower < upper) {
		    int mid = (lower + upper) / 2;
			if (nums[mid] < target) {
				lower = mid + 1;
			} else {
				upper = mid;
			}
		}
		if (nums[lower] != target) {
		    return result;
		}
		result[0] = lower;
		lower = 0;
		upper = nums.length - 1;
		while (lower < upper) {
		    int mid = (lower + upper) / 2 + 1;
			if (nums[mid] <= target) {
				lower = mid;
			} else {
				upper = mid - 1;
			}
		}
		if (nums[upper] != target) {
		    return result;
		}
		result[1] = upper;
		return result;
	}
}